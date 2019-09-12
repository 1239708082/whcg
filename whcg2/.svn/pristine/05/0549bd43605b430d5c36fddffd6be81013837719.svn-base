package com.ltsk.whcg.zhjg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {

	@Insert("insert into  SYS_USER_ROLE (userid,roleid)values(#{userid},#{roleId})")
	public int createNewRole(@Param("roleId")String roleId,@Param("userid")String userid);

	@Select("select roleid from SYS_USER_ROLE where userid =#{userid}")
	public List<String> queryRoleId(String userid);
	
	
}
