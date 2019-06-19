package com.springboot.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-11 17:14
 */
@Document
public class MongoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String text;

    private Date gmtCreate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
