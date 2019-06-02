package com.wechat.service;



import com.wechat.model.Pickitem_photo_user;
import com.wechat.model.Pick_up_items;

import java.util.List;

public interface Pick_itemService {


    /**
     * 查找所有的 Pick 的物品信息，没有图片
     * @return
     */
    List<Pickitem_photo_user> findAll();


    /**
     *  查找 items中的图片
     * @param
     * @return
     */
    List<Pickitem_photo_user> findAlladdpath(List<Pickitem_photo_user>  noPath);

    //---zkt
    Pickitem_photo_user findOne(Integer ID);

}
