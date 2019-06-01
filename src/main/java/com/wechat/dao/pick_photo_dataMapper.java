package com.wechat.dao;

import com.wechat.model.Pick_photo_data;
import com.wechat.model.Pick_photo_dataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Pick_photo_dataMapper {
    int countByExample(Pick_photo_dataExample example);

    int deleteByExample(Pick_photo_dataExample example);

    int insert(Pick_photo_data record);

    int insertSelective(Pick_photo_data record);

    List<Pick_photo_data> selectByExample(Pick_photo_dataExample example);

    int updateByExampleSelective(@Param("record") Pick_photo_data record, @Param("example") Pick_photo_dataExample example);

    int updateByExample(@Param("record") Pick_photo_data record, @Param("example") Pick_photo_dataExample example);
}