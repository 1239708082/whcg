package com.ltsk.whcg.zhjg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ltsk.whcg.entity.Menu;

@Mapper
@Repository
public interface TreeMapper {
	@Select("select rolename from SYS_ROLE ")
	public List<String> getRoleName();
	@Select("select menu_name,title_name from SYS_MENU")
	public List<Menu> getMenuName();
}
