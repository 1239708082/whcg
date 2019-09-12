package com.ltsk.whcg.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ltsk.whcg.entity.XZQH;

@Repository
public interface XZQHMapper {
	@Select("select * from XZQH")
	public List<XZQH> getAll();
	@Select("select name from xzqh where no=#{no}")
	public String getXzqhName(@Param("no")String no);
}
