package com.wechat.service.impl;

import com.wechat.dao.Pick_up_itemsMapper;
import com.wechat.dao.UserMapper;
import com.wechat.model.Pickitem_photo_user;
import com.wechat.model.Pick_up_items;
import com.wechat.model.User;
import com.wechat.service.Pick_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Pick_itemServiceimpl implements Pick_itemService {

    @Autowired
    private Pick_up_itemsMapper pick_up_itemsMapper;

    //----zkt
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Pickitem_photo_user> findAll() {
        List<Pickitem_photo_user> pickitem_photo_users = pick_up_itemsMapper.selectAllitems();
        return pickitem_photo_users;
    }




    //---zkt
    @Override
    public Pickitem_photo_user findOne(Integer ID) {
        Pickitem_photo_user pickitem_photoUser = new Pickitem_photo_user();
        List<String> paths = pick_up_itemsMapper.findPhototPathByItemId(ID);
        Pick_up_items pick_up_items = pick_up_itemsMapper.selectByPrimaryKey(ID);
        pickitem_photoUser.setPick_up_items(pick_up_items);
        pickitem_photoUser.setPhoto_path(paths);
        return pickitem_photoUser;
    }

    @Override
    public List<Pickitem_photo_user> findAlladdpath(List<Pickitem_photo_user> noPath) {

        for(Pickitem_photo_user item:noPath){

              List<String> paths = pick_up_itemsMapper.findPhototPathByItemId(item.getPick_up_items().getId());
              item.setPhoto_path(paths);

//            //-----zkt
//            //通过ItemID获取用户的OpenID
//            String openIDByItemId = pick_up_itemsMapper.findOpenIDByItemId(list.getId());
//            System.out.println("-----------------------------ItemID: "+list.getId()+"GetOpenID:"+openIDByItemId);
//            //通过OpenID获取用户的相关信息
//            User user = userMapper.selectByPrimaryKey(openIDByItemId);
//
//            System.out.println("--------------------------------------"+user);
//            //Openid不能给，null了
//            user.setOpenid(null);
//            //-------
//            pick.setUser(user);
        }


        return noPath;
    }
}
