package com.wechat.dao;

import com.wechat.model.pick_photo_data;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository()
public interface pick_photo_dataMapper {
    @Insert({
        "insert into pick_photo_data (Id, Photo)",
        "values (#{id,jdbcType=INTEGER}, #{photo,jdbcType=CHAR})"
    })
    int insert(pick_photo_data record);

    int insertSelective(pick_photo_data record);
}