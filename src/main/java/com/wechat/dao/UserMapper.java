package com.wechat.dao;

import com.wechat.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserMapper {
    @Delete({
        "delete from user",
        "where Openid = #{openid,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String openid);

    @Insert({
        "insert into user (Openid, Name, ",
        "Gender, Phone, QQ)",
        "values (#{openid,jdbcType=CHAR}, #{name,jdbcType=CHAR}, ",
        "#{gender,jdbcType=CHAR}, #{phone,jdbcType=CHAR}, #{qq,jdbcType=CHAR})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "Openid, Name, Gender, Phone, QQ",
        "from user",
        "where Openid = #{openid,jdbcType=CHAR}"
    })
    @ResultMap("BaseResultMap")
    User selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set Name = #{name,jdbcType=CHAR},",
          "Gender = #{gender,jdbcType=CHAR},",
          "Phone = #{phone,jdbcType=CHAR},",
          "QQ = #{qq,jdbcType=CHAR}",
        "where Openid = #{openid,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(User record);
}