package com.wechat.service.impl;

import com.wechat.dao.Pick_up_itemsMapper;
import com.wechat.model.Pick_and_photo;
import com.wechat.model.Pick_up_items;
import com.wechat.service.Pick_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Pick_itemServiceimpl implements Pick_itemService {

    @Autowired
    private Pick_up_itemsMapper pick_up_itemsMapper;


    @Override
    public List<Pick_up_items> findAll() {
        return pick_up_itemsMapper.selectAllitem();
    }

    @Override
    public List<Pick_and_photo> findAllInfo(List<Pick_up_items> pick_items) {

        List<Pick_and_photo> pick_and_photoList =new ArrayList<Pick_and_photo>();

        for(Pick_up_items list:pick_items){
            List<String> paths=pick_up_itemsMapper.findPhototPathByItemId(list.getId());
            Pick_and_photo pick= new Pick_and_photo();
            pick.setPhoto_path(paths);
            pick.setPick_up_items(list);
            pick_and_photoList.add(pick);
        }
        return pick_and_photoList;
    }
}
