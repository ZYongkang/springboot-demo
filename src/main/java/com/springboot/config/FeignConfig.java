package com.springboot.config;

import feign.Contract;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-07-07 14:07
 */
@Configuration
public class FeignConfig {

    @Bean
    public Contract feignContract() {
        return new SpringMvcContract.BaseContract.Default();
//        return new feign.Contract.Default();
    }

}
