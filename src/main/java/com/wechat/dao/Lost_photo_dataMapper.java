package com.wechat.dao;

import com.wechat.model.Lost_photo_data;
import com.wechat.model.Lost_photo_dataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Lost_photo_dataMapper {
    int countByExample(Lost_photo_dataExample example);

    int deleteByExample(Lost_photo_dataExample example);

    int insert(Lost_photo_data record);

    int insertSelective(Lost_photo_data record);

    List<Lost_photo_data> selectByExample(Lost_photo_dataExample example);

    int updateByExampleSelective(@Param("record") Lost_photo_data record, @Param("example") Lost_photo_dataExample example);

    int updateByExample(@Param("record") Lost_photo_data record, @Param("example") Lost_photo_dataExample example);
}