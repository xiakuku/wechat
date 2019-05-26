package com.wechat.model;

public class User {
    private String openid;

    private String name;

    private String gender;

    private String phone;

    private String qq;

    public User(String openid, String name, String gender, String phone, String qq) {
        this.openid = openid;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.qq = qq;
    }

    public String getOpenid() {
        return openid;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getQq() {
        return qq;
    }
}