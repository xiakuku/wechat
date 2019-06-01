package com.wechat.dao;

import com.wechat.model.Lost_item;
import com.wechat.model.Lost_itemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Lost_itemMapper {
    int countByExample(Lost_itemExample example);

    int deleteByExample(Lost_itemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lost_item record);

    int insertSelective(Lost_item record);

    List<Lost_item> selectByExample(Lost_itemExample example);

    Lost_item selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lost_item record, @Param("example") Lost_itemExample example);

    int updateByExample(@Param("record") Lost_item record, @Param("example") Lost_itemExample example);

    int updateByPrimaryKeySelective(Lost_item record);

    int updateByPrimaryKey(Lost_item record);


    // 查找所有信息
    List<Lost_item> selectAllitem();

    // 通过id查找到所有 该信息的图片
    List<String> findPhototPathByItemId(Integer id);

}