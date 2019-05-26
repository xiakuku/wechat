package com.wechat.dao;

import com.wechat.model.Lost_photo_data;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository()
public interface Lost_photo_dataMapper {
    @Insert({
        "insert into lost_photo_data (Id, Photo)",
        "values (#{id,jdbcType=INTEGER}, #{photo,jdbcType=CHAR})"
    })
    int insert(Lost_photo_data record);

    int insertSelective(Lost_photo_data record);
}