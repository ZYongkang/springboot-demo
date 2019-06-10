package com.springboot.demo.controller;

import com.springboot.demo.model.ArtworkDO;
import com.springboot.demo.service.ArtworkService;
import com.springboot.demo.view.service.ArtworkViewService;
import com.springboot.demo.view.vo.ArtworkVO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

    @Autowired
    private ArtworkViewService artworkViewService;

    @RequestMapping(value = "/get_by_id", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getArtWorkDOById(@RequestParam(name = "id", required = true) Integer id) {
        Map<String, Object> modelmap = new HashMap<>();
        if (id == null || id <= 0) {
            modelmap.put("status", 2);
            modelmap.put("msg", "id is null or id <= 0");
            return modelmap;
        }
        try {
            ArtworkVO artworkVO = artworkViewService.getById(id);
            if (artworkVO == null) {
                modelmap.put("data", null);
                modelmap.put("status", 0);
                modelmap.put("msg", "no data");
                return modelmap;
            }
            modelmap.put("status", 0);
            modelmap.put("msg", "success");
            modelmap.put("data", artworkVO.toJSON());
            return modelmap;
        } catch (Exception e) {
            e.printStackTrace();
            modelmap.put("status", -1);
            modelmap.put("msg", "error" + e.getMessage());
            return modelmap;
        }
    }

}
