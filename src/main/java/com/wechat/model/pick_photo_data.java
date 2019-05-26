package com.wechat.model;

public class pick_photo_data {
    private Integer id;

    private String photo;

    public pick_photo_data(Integer id, String photo) {
        this.id = id;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }
}