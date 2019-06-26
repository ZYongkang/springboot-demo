package com.springboot.demo.mongo.service;

import com.springboot.demo.mongo.dao.MongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-11 17:51
 */
@Service
public class MongoService {

    @Autowired
    private MongoDao mongoDao;

    public Object save(Object object) {
        if (object == null) {
            return null;
        }
        return mongoDao.save(object);
    }

}
