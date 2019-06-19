package com.springboot.demo.controller;

import com.springboot.demo.model.ArtworkDO;
import com.springboot.demo.service.ArtworkService;
import com.springboot.demo.view.service.ArtworkViewService;
import com.springboot.demo.view.vo.ArtworkVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-06 16:36
 */
@Controller
@RequestMapping("/artwork")
@Slf4j
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

    @Autowired
    private ArtworkViewService artworkViewService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/get_by_id", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getArtWorkDOById(@RequestParam(name = "id") Integer id) {
        Map<String, Object> modelMap = new HashMap<>();
        log.info("url:'/demo/artwork/get_by_id';param:id="+id);
        if (id == null || id <= 0) {
            modelMap.put("status", 2);
            modelMap.put("msg", "id is null or id <= 0");
            return modelMap;
        }
        try {
            ArtworkVO artworkVO = artworkViewService.getById(id);
            if (artworkVO == null) {
                modelMap.put("data", null);
                modelMap.put("status", -1);
                modelMap.put("msg", "no data");
                return modelMap;
            }
            String sid = artworkVO.getSid();
            Query query = new Query();
            query.addCriteria(Criteria.where("sid").is(sid));
            ArtworkDO artworkDO = mongoTemplate.findOne(query, ArtworkDO.class);
            if (artworkDO != null) {
                System.out.println(artworkDO.toString());
            }
            modelMap.put("status", 0);
            modelMap.put("msg", "success");
            modelMap.put("data", artworkVO.toJSON());
            return modelMap;
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("status", -1);
            modelMap.put("msg", "error" + e.getMessage());
            return modelMap;
        }
    }

}
