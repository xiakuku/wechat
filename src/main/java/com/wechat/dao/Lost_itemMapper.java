package com.wechat.dao;

import com.wechat.model.lost_item;
import com.wechat.model.lost_itemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface lost_itemMapper {
    int countByExample(lost_itemExample example);

    int deleteByExample(lost_itemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(lost_item record);

    int insertSelective(lost_item record);

    List<lost_item> selectByExample(lost_itemExample example);

    lost_item selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") lost_item record, @Param("example") lost_itemExample example);

    int updateByExample(@Param("record") lost_item record, @Param("example") lost_itemExample example);

    int updateByPrimaryKeySelective(lost_item record);

    int updateByPrimaryKey(lost_item record);
}