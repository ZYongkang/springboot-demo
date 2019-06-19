package com.springboot.demo.mongo.dao.impl;

import com.springboot.demo.mongo.dao.MongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-11 17:53
 */
@Component
public class MongoDaoImpl implements MongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Object save(Object object) {
        return mongoTemplate.save(object);
    }
}
