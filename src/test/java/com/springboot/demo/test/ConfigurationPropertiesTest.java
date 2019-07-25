package com.springboot.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-07-25 11:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationPropertiesTest {

    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user.toString());
    }
}
