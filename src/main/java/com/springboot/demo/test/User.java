package com.springboot.demo.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-07-25 11:38
 */
/*
* springboot 在较新的版本中使用ConfigurationProperties注解的时候不能再使用@Component
* 否则会导致整个项目在启动的时候报错：
* com.springboot.demo.test.User is annotated with @ConfigurationProperties and @Component.
* This may cause the @ConfigurationProperties bean to be registered twice.'
* 可以使用的方法为不使用@Component，这样虽然编译会有警告，但是可以运行，并且是预期的结果
*/
@ConfigurationProperties(prefix = "user")
public class User {

    private Integer id;
    private String sid;
    private String nickname;

    public User() {
    }

    public User(Integer id, String sid, String nickname) {
        this.id = id;
        this.sid = sid;
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
