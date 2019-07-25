package com.springboot.demo.model;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-27 22:09
 */
public class MicroBeanObject<T> {

    private Integer status;
    private String msg;
    private T data;

    public MicroBeanObject() {
    }

    public MicroBeanObject(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object covert2Object(Class clazz) {
        return JSON.parseObject(JSON.toJSONString(this.data), clazz);
    }

    @Override
    public String toString() {
        return "MicroBeanObject{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
