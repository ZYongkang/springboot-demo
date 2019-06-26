package com.springboot.demo.service;

import com.springboot.demo.dao.ArtworkDao;
import com.springboot.demo.model.ArtworkDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-06 16:36
 */
@Service
public class ArtworkService {

    @Autowired
    private ArtworkDao artworkDao;

    public ArtworkDO getById(Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        return artworkDao.getById(id);
    }

    public ArtworkDO getBySid(String sid) {
        return artworkDao.getBySid(sid);
    }
}
