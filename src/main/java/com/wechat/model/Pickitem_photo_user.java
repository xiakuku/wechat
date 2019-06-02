package com.wechat.model;

import java.util.List;

public class Pickitem_photo_user {

    private Pick_up_items pick_up_items;

    private List<String> photo_path;

    //-----zkt
    private User user;

    //----

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

    //---zkt
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    //-----


    @Override
    public String toString() {
        return super.toString();
    }
}
