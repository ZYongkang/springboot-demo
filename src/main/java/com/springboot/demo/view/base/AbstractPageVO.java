package com.springboot.demo.view.base;

import com.alibaba.fastjson.JSONObject;

/**
 * 页面VO对象的抽象类
 * @Author wangchungang@artspring.com.cn
 */
public abstract class AbstractPageVO {

    /**
     * 将页面VO对象转换成JSON对象
     * @return
     */
    public abstract JSONObject toJSON();
}
