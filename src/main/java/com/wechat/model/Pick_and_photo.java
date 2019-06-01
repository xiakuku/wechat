package com.wechat.model;

import java.util.List;

public class Pick_and_photo {

    private Pick_up_items pick_up_items;

    private List<String> photo_path;

    public Pick_up_items getPick_up_items() {
        return pick_up_items;
    }

    public void setPick_up_items(Pick_up_items pick_up_items) {
        this.pick_up_items = pick_up_items;
    }

    public List<String> getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(List<String> photo_path) {
        this.photo_path = photo_path;
    }
}
