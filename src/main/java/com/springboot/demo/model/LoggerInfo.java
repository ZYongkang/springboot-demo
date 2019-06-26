package com.springboot.demo.model;

import com.alibaba.fastjson.JSONObject;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-25 16:56
 */
@Document("log")
public class LoggerInfo {

    @Id
    private ObjectId id;
    private String sid;
    private String url;
    private String classname;
    private String methodName;
    private String ip;
    private String requestMethod;
    private String paramMap2Json;
    private String return2Json;
    private Date createTime;

    public LoggerInfo() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParamMap2Json() {
        return paramMap2Json;
    }

    public void setParamMap2Json(String paramMap2Json) {
        this.paramMap2Json = paramMap2Json;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getReturn2Json() {
        return return2Json;
    }

    public void setReturn2Json(String return2Json) {
        this.return2Json = return2Json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoggerInfo that = (LoggerInfo) o;
        return Objects.equals(sid, that.sid) &&
                Objects.equals(url, that.url) &&
                Objects.equals(classname, that.classname) &&
                Objects.equals(methodName, that.methodName) &&
                Objects.equals(paramMap2Json, that.paramMap2Json);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sid, url, classname, methodName, ip, requestMethod, paramMap2Json, return2Json, createTime);
    }

    public void loadParam(String url, String ip, String requestMethod, String className, String methodName, Map param) {
        this.setUrl(url);
        this.setClassname(className);
        this.setCreateTime(new Date());
        this.setMethodName(methodName);
        this.setIp(ip);
        this.setRequestMethod(requestMethod);
        if (param != null) {
            String json = JSONObject.toJSONString(param);
            this.setParamMap2Json(json);
        }
    }
}
