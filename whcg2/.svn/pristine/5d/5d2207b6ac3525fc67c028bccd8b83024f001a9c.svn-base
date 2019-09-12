package com.ltsk.whcg.zhjg.mapper;

import java.util.List;

import com.ltsk.whcg.entity.Role;
import com.ltsk.whcg.entity.RoleIdByName;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.ltsk.whcg.entity.User;

@Mapper
@Repository
public interface UserMapper {
	@Select("select * from ZHJGINFO.SYS_USER where username=#{username}")
	public User findByName(@Param("username") String username);
	@Insert("insert into ZHJGINFO.SYS_USER values(null,#{userid},#{username},#{password},#{xzqh},#{type},null,null,#{insert_time},#{mail},#{idCard},#{realName},#{headShip},#{deptCode},#{mobile})")
	public Integer addUser(User user);
	@Update("update ZHJGINFO.SYS_USER set password=#{password},update_time=#{update_time} where username=#{username}")
	public Integer updatePwd(@Param("password")String newPassword,@Param("username")String username,@Param("update_time")String update_time);
//	@Select("select rolename from C##ZHJGINFO.SYS_USER_ROLE where userid=#{userid}")
	@Select("select t2.rolename from ZHJGINFO.SYS_USER_ROLE t1 left join ZHJGINFO.SYS_ROLE t2 on t1.roleid=t2.roleid  where userid=#{userid}")
	public List<String> getRoleName(@Param("userid")String userid);
	/**
	 * 给对应用户赋权限
	 * */
	@Insert("${userRoleSql}")
	public Integer putUserIsRole(@Param("userRoleSql")String userRoleSql);

	/**
	 * 查询所有角色名及id
	 * */
	@Select("select roleid,rolename from ZHJGINFO.SYS_ROLE")
	public List<RoleIdByName> getRoleIdByName();

	/**
	 * 删除用户
	 * */
	@Delete("${deleteUserSql}")
	public Integer deleteUserInfo(@Param("deleteUserSql")String deleteUserSql);
}
