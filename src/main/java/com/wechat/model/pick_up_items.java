package com.wechat.model;

import java.util.Date;

public class pick_up_items {
    private Integer id;

    private String description;

    private String photo;

    private String qq;

    private String openid;

    private Date releaseTime;

    private String itemType;

    public pick_up_items(Integer id, String description, String photo, String qq, String openid, Date releaseTime, String itemType) {
        this.id = id;
        this.description = description;
        this.photo = photo;
        this.qq = qq;
        this.openid = openid;
        this.releaseTime = releaseTime;
        this.itemType = itemType;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public String getQq() {
        return qq;
    }

    public String getOpenid() {
        return openid;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public String getItemType() {
        return itemType;
    }
}