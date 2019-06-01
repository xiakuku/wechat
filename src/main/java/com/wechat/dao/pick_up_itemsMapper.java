package com.wechat.dao;

import com.wechat.model.Lost_item;
import com.wechat.model.Pick_and_photo;
import com.wechat.model.Pick_up_items;
import com.wechat.model.Pick_up_itemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Pick_up_itemsMapper {
    int countByExample(Pick_up_itemsExample example);

    int deleteByExample(Pick_up_itemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pick_up_items record);

    int insertSelective(Pick_up_items record);

    List<Pick_up_items> selectByExample(Pick_up_itemsExample example);

    Pick_up_items selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pick_up_items record, @Param("example") Pick_up_itemsExample example);

    int updateByExample(@Param("record") Pick_up_items record, @Param("example") Pick_up_itemsExample example);

    int updateByPrimaryKeySelective(Pick_up_items record);

    int updateByPrimaryKey(Pick_up_items record);


    //查找所有的信息
    List<Pick_up_items> selectAllitem();


    // 通过id查找所有的 该信息的图片
    List<String> findPhototPathByItemId(Integer id);
}