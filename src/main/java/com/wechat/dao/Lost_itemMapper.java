package com.wechat.dao;

import com.wechat.model.Lost_item;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository()
public interface Lost_itemMapper {
    @Delete({
        "delete from lost_item",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into lost_item (Id, Description, ",
        "Photo, QQ, Openid, ",
        "Release_time, Item_type)",
        "values (#{id,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, ",
        "#{photo,jdbcType=VARCHAR}, #{qq,jdbcType=VARCHAR}, #{openid,jdbcType=VARCHAR}, ",
        "#{releaseTime,jdbcType=TIMESTAMP}, #{itemType,jdbcType=VARCHAR})"
    })
    int insert(Lost_item record);

    int insertSelective(Lost_item record);

    @Select({
        "select",
        "Id, Description, Photo, QQ, Openid, Release_time, Item_type",
        "from lost_item",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Lost_item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lost_item record);

    @Update({
        "update lost_item",
        "set Description = #{description,jdbcType=VARCHAR},",
          "Photo = #{photo,jdbcType=VARCHAR},",
          "QQ = #{qq,jdbcType=VARCHAR},",
          "Openid = #{openid,jdbcType=VARCHAR},",
          "Release_time = #{releaseTime,jdbcType=TIMESTAMP},",
          "Item_type = #{itemType,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Lost_item record);
}