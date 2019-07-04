package com.wechat.model;

import java.util.Date;

public class lost_item {
    private Integer id;

    private String description;

    private String phone;

    private String qq;

    private String openid;

    private Date releaseTime;

    private String itemType;

    private String getaddress;

    private String role;

    private String ifdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getGetaddress() {
        return getaddress;
    }

    public void setGetaddress(String getaddress) {
        this.getaddress = getaddress == null ? null : getaddress.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getIfdelete() {
        return ifdelete;
    }

    public void setIfdelete(String ifdelete) {
        this.ifdelete = ifdelete == null ? null : ifdelete.trim();
    }
}