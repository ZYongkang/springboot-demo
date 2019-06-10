package com.springboot.demo.view.base;

import com.alibaba.fastjson.JSONObject;

/**
 * 基于实体类的VO对象的接口。
 * @Author wangchungang@artspring.com.cn
 */
public interface IModelVO {
    public void loadParamFromDO(Object modelDO);
    public void convertToDO(Object modelDO);
    public JSONObject toJSON();
}
