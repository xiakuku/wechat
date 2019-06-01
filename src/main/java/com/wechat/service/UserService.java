package com.wechat.service;

import com.wechat.model.User;

public interface UserService {

    User findByOPenid(String openid);


    /**
     * 插入新用户信息
     * @param user
     * @return
     */
    Integer insertnewObject(User user);
}
