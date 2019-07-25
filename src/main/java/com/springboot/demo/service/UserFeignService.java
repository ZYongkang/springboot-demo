package com.springboot.demo.service;

import com.springboot.demo.model.MicroBeanObject;
import com.springboot.demo.model.UserDO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignService {
    @GetMapping("/user/get_by_{id}")
    MicroBeanObject<UserDO> getById(@PathVariable("id") Integer id);
}

@Component
class UserFeignClientFallback implements UserFeignService {
    @Override
    public MicroBeanObject<UserDO> getById(Integer id) {
        MicroBeanObject<UserDO> microBeanObject = new MicroBeanObject<>();
        microBeanObject.setMsg("error");
        microBeanObject.setStatus(-1);
        return microBeanObject;
    }
}

@Component
@Slf4j
class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignService> {

    @Override
    public UserFeignService create(Throwable throwable) {
        return id -> {
            log.error("error:", throwable);
            MicroBeanObject<UserDO> microBeanObject = new MicroBeanObject<>();
            microBeanObject.setMsg("error:" + throwable.getMessage());
            microBeanObject.setStatus(-1);
            return microBeanObject;
        };
    }
}


