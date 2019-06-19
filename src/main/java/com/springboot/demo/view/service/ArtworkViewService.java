package com.springboot.demo.view.service;

import com.springboot.demo.model.ArtworkDO;
import com.springboot.demo.service.ArtworkService;
import com.springboot.demo.view.vo.ArtworkVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-06 17:02
 */
@Service
public class ArtworkViewService {

    @Autowired
    private ArtworkService artworkService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    public ArtworkVO getById(Integer id) {
        String cacheKey = "APP.Test.ArtworkDO-Id:" + id;
        if (id == null || id <= 0) {
            return null;
        }
        ArtworkDO artworkDO;
        if (redisTemplate.hasKey(cacheKey)) {
            artworkDO = (ArtworkDO) redisTemplate.opsForValue().get(cacheKey);
        } else {
            artworkDO = artworkService.getById(id);
            if (artworkDO != null) {
                redisTemplate.opsForValue().set(cacheKey, artworkDO);
                Boolean expire = redisTemplate.expire(cacheKey, 1, TimeUnit.MINUTES);
                if (expire == null || !expire) {
                    redisTemplate.delete(cacheKey);
                }
            }
        }

        if (artworkDO == null) {
            return null;
        }
        mongoTemplate.save(artworkDO);
        ArtworkVO artworkVO = new ArtworkVO();
        BeanUtils.copyProperties(artworkDO, artworkVO);
        return artworkVO;
    }
}
