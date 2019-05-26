package com.wechat.service.impl;

import com.wechat.dao.Lost_itemMapper;
import com.wechat.model.Lost_item;
import com.wechat.service.Lost_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Lost_itemServiceImpl implements Lost_itemService {


    @Autowired
    private Lost_itemMapper lost_itemMapper;

    @Override
    public Lost_item findById(Integer id) {
        return lost_itemMapper.selectByPrimaryKey(id);
    }
}
