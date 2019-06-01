package com.wechat.service.impl;

import com.wechat.dao.Lost_itemMapper;
import com.wechat.model.Lost_and_photo;
import com.wechat.model.Lost_item;
import com.wechat.service.Lost_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Lost_itemServiceImpl implements Lost_itemService {


    @Autowired
    private Lost_itemMapper lost_itemMapper;

    @Override
    public Lost_item findById(Integer id) {
        return lost_itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Lost_item> findAll() {
        List<Lost_item> list=lost_itemMapper.selectAllitem();
        return list;
    }

    @Override
    public List<Lost_and_photo> findAllInfo(List<Lost_item> lost_items) {

        List<Lost_and_photo> lost_and_photoList =new ArrayList<Lost_and_photo>();

        for(Lost_item item:lost_items){
            List<String> paths=lost_itemMapper.findPhototPathByItemId(item.getId());
            Lost_and_photo lost_and_photo=new Lost_and_photo();
            lost_and_photo.setPhoto_path(paths);
            lost_and_photo.setLost_item(item);
            lost_and_photoList.add(lost_and_photo);
        }
        return lost_and_photoList;
    }

}
