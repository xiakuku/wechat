package com.wechat.model;

import java.util.List;

public class Lost_and_photo {
     private  Lost_item lost_item;

     private List<String> photo_path;


    public Lost_item getLost_item() {
        return lost_item;
    }

    public void setLost_item(Lost_item lost_item) {
        this.lost_item = lost_item;
    }

    public List<String> getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(List<String> photo_path) {
        this.photo_path = photo_path;
    }


}
