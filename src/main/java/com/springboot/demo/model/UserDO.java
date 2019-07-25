package com.springboot.demo.model;

import java.util.Date;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-27 19:58
 */
public class UserDO {


    private Integer id;
    private String sid;
    private String nickname;
    private String url;
    private String role;
    private Integer sex;
    private Integer status;
    private String realInfo;
    private String areaCode;
    private String phone;
    private String location;
    private String deviceId;
    private Integer securityLevel;
    private String securityDescription;
    private Date gmtCreate;
    private Date gmtModified;
    private String email;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealInfo() {
        return realInfo;
    }

    public void setRealInfo(String realInfo) {
        this.realInfo = realInfo;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getSecurityDescription() {
        return securityDescription;
    }

    public void setSecurityDescription(String securityDescription) {
        this.securityDescription = securityDescription;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", url='" + url + '\'' +
                ", role='" + role + '\'' +
                ", sex=" + sex +
                ", status=" + status +
                ", realInfo='" + realInfo + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", securityLevel=" + securityLevel +
                ", securityDescription='" + securityDescription + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", email='" + email + '\'' +
                '}';
    }
}
