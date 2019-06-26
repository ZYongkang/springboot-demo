package com.springboot.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import com.springboot.demo.model.LoggerInfo;
import com.springboot.demo.mongo.service.MongoService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-25 16:55
 */
@Aspect
@Component
@Slf4j
public class HttpRequestAspect {

    private Object save;

    @Autowired
    private MongoService mongoService;

    /**
     * @PointCut注解表示表示横切点，哪些方法需要被横切 切点表达式
     */
    @Pointcut("execution(public * com.springboot.demo.controller.*.*(..))")
    /*切点签名*/
    public void log() {
    }

    /*@Before注解表示在具体的方法之前执行*/
    @Before("log()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();   //这个方法取客户端ip"不够好"
        String requestMethod = request.getMethod();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Map<String, Object> fieldsName = null;
        try {
            fieldsName = getFieldsName(joinPoint);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        LoggerInfo loggerInfo = new LoggerInfo();

        loggerInfo.setSid(UUID.randomUUID().toString());
        loggerInfo.loadParam(url, ip, requestMethod, className, methodName, fieldsName);
        save = mongoService.save(loggerInfo);
    }

    /*@After注解表示在方法执行之后执行*/
    @After("log()")
    public void after() {
    }

    /*@AfterReturning注解用于获取方法的返回值*/
    @AfterReturning(pointcut = "log()", returning = "object")
    public void getAfterReturn(Object object) {
        LoggerInfo loggerInfo = null;
        try {
            loggerInfo = (LoggerInfo) save;
        } catch (Exception e) {
            log.error("error:{}", e);
        }
        String json = JSONObject.toJSONString(object);
        loggerInfo.setReturn2Json(json);
        mongoService.save(loggerInfo);
    }

    /**
     * 获取参数列表
     *
     * @param joinPoint
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    private Map<String, Object> getFieldsName(JoinPoint joinPoint) throws ClassNotFoundException, NoSuchMethodException {
        // 参数值
        Object[] args = joinPoint.getArgs();
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String[] parameterNames = pnd.getParameterNames(method);
        Map<String, Object> paramMap = new HashMap<>(32);
        if (parameterNames != null && parameterNames.length > 0) {
            for (int i = 0; i < parameterNames.length; i++) {
                paramMap.put(parameterNames[i], args[i]);
            }
        }
        return paramMap;
    }
}
