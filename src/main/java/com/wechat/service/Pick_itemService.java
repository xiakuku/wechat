package com.wechat.service;


import com.wechat.model.Pick_and_photo;
import com.wechat.model.Pick_up_items;

import java.util.List;

public interface Pick_itemService {


    /**
     * 查找所有的 Pick 的物品信息，没有图片
     * @return
     */
    List<Pick_up_items> findAll();

    List<Pick_and_photo> findAllInfo(List<Pick_up_items>  pick_items);



}
