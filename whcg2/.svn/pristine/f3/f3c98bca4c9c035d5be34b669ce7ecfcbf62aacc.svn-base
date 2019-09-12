package com.ltsk.whcg.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ltsk.whcg.entity.GdInfo;

@Repository

public interface GdMapper {

	
	@Select("<script> " +  
            "SELECT * " +  
            "from ZHQTGD " +  
            " <where> " +  
            "  updatetime  >= trunc(sysdate)" +  
            " <if test='xzqh != null'>and addr like #{xzqh}</if> " +  
            " </where> " +  
            " </script> ")  
    public List<GdInfo> getAll(@Param("xzqh")String xzqh);
}


