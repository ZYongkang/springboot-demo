package com.springboot.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-29 13:26
 */
//@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
