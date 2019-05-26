package com.wechat.dao;

import com.wechat.model.pick_up_items;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository()
public interface pick_up_itemsMapper {
    @Delete({
        "delete from pick_up_items",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into pick_up_items (Id, Description, ",
        "Photo, QQ, Openid, ",
        "Release_time, Item_type)",
        "values (#{id,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, ",
        "#{photo,jdbcType=VARCHAR}, #{qq,jdbcType=VARCHAR}, #{openid,jdbcType=VARCHAR}, ",
        "#{releaseTime,jdbcType=TIMESTAMP}, #{itemType,jdbcType=VARCHAR})"
    })
    int insert(pick_up_items record);

    int insertSelective(pick_up_items record);

    @Select({
        "select",
        "Id, Description, Photo, QQ, Openid, Release_time, Item_type",
        "from pick_up_items",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    pick_up_items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(pick_up_items record);

    @Update({
        "update pick_up_items",
        "set Description = #{description,jdbcType=VARCHAR},",
          "Photo = #{photo,jdbcType=VARCHAR},",
          "QQ = #{qq,jdbcType=VARCHAR},",
          "Openid = #{openid,jdbcType=VARCHAR},",
          "Release_time = #{releaseTime,jdbcType=TIMESTAMP},",
          "Item_type = #{itemType,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(pick_up_items record);
}