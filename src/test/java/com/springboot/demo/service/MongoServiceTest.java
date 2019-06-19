package com.springboot.demo.service;

import com.springboot.demo.model.MongoDO;
import com.springboot.demo.mongo.service.MongoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoServiceTest {

    @Autowired
    private MongoService mongoService;

    @Test
    public void save() {
        MongoDO mongoDO = new MongoDO();
        mongoDO.setId(1);
        mongoDO.setGmtCreate(new Date());
        mongoDO.setText("test");
        mongoService.save(mongoDO);
    }
}