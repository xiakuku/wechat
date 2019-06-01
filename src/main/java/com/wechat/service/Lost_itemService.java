package com.wechat.service;

import com.wechat.model.Lost_and_photo;
import com.wechat.model.Lost_item;

import java.util.List;

public interface Lost_itemService {

     Lost_item findById(Integer id);

    /**
     * 查找所有lost 的物品信息，没有图片
     * @return
     */
     List<Lost_item> findAll();

    /**
     * 查找所有lost 的物品信息，附加图片
     * @return
     */

     List<Lost_and_photo> findAllInfo( List<Lost_item> lost_items);
}
