package com.ltsk.whcg.postuser.mapper;/**
 * Created by Administrator on 2019-1-4.
 */

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: whcg
 * @description: 注册协同标注用户
 * @author: zt
 * @create: 2019-01-04 15:56
 **/
@Repository
public interface AnnotationMapper {
    /**
     * 同步注册  person表
     * */
    @Select("${personsql}")
    public void personInsert(@Param("personsql")String personsql);

    /**
     * 同步注册  role表
     * */
    @Insert("${rolesql}")
    public void roleInsert(@Param("rolesql")String rolesql);

    /**
     * 同步注册  team表
     * */
    @Insert("${teamsql}")
    public void teamInsert(@Param("teamsql")String teamsql);

    /**
     * 修改密码  person
     * */
    @Update("${changeSql}")
    public Integer changePassword(@Param("changeSql")String changeSql);

    /**
     * 判断用户是否存在
     * */
    @Select("${usersql}")
    public Integer isUser(@Param("usersql")String usersql);

    /**
     * 查询用户密码
     * */
    @Select("${usersql}")
    public String getPassword(@Param("usersql")String usersql);

    /**
     * 删除用户
     * */
    /**
     * 删除用户
     * */
    @Delete("${deleteUserSql}")
    public Integer deleteUserInfo(@Param("deleteUserSql")String deleteUserSql);
}
