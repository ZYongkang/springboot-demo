package com.springboot.demo.view.service;

import com.springboot.demo.model.ArtworkDO;
import com.springboot.demo.model.MicroBeanObject;
import com.springboot.demo.model.UserDO;
import com.springboot.demo.service.ArtworkService;
import com.springboot.demo.service.UserFeignService;
import com.springboot.demo.view.vo.ArtworkVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-06 17:02
 */
@Service
@Slf4j
public class ArtworkViewService {

    @Autowired
    private ArtworkService artworkService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserFeignService userFeignService;

    public ArtworkVO getById(Integer id, Integer userId) {
        String cacheKey = "APP.Test.ArtworkDO-Id:" + id;
        if (id == null || id <= 0) {
            return null;
        }
        ArtworkDO artworkDO;
        if (redisTemplate.hasKey(cacheKey)) {
            artworkDO = (ArtworkDO) redisTemplate.opsForValue().get(cacheKey);
        } else {
            artworkDO = artworkService.getById(id);
            redisTemplate.opsForValue().set(cacheKey, artworkDO, 10, TimeUnit.MINUTES);
        }

        MicroBeanObject<UserDO> microBeanObject = userFeignService.getById(userId);

        UserDO userDO = null;
        if (microBeanObject != null) {
            Integer status = microBeanObject.getStatus();
            if (status == 0) {
                userDO = (UserDO) microBeanObject.covert2Object(UserDO.class);
            }
        }
        if (userDO != null) {
            System.out.println(userDO);
        }
        if (artworkDO == null) {
            return null;
        }
        ArtworkVO artworkVO = new ArtworkVO();
        BeanUtils.copyProperties(artworkDO, artworkVO);
        return artworkVO;
    }

    public ArtworkVO getBySid(String sid) {
        if (sid == null || sid.isEmpty()) {
            return null;
        }
        String cacheKey = "APP.Test.ArtworkDO-Sid:" + sid;
        ArtworkDO artworkDO = null;
        if (redisTemplate.hasKey(cacheKey)) {
            artworkDO = (ArtworkDO) redisTemplate.opsForValue().get(cacheKey);
        }else {
            artworkDO = artworkService.getBySid(sid);
            redisTemplate.opsForValue().set(cacheKey, artworkDO, 10, TimeUnit.MINUTES);
        }
        if (artworkDO == null) {
            return null;
        }
        ArtworkVO artworkVO = new ArtworkVO();
        BeanUtils.copyProperties(artworkDO, artworkVO);
        return artworkVO;
    }
}
