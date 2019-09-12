package com.ltsk.whcg.digital.mapper;

import com.ltsk.whcg.entity.NoiseAndBuilding;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingMapper {
	
//	@Select("select * from whcg_dcm.v_sdlj where complaint_time > trunc(sysdate) and zone_name= #{xzqh}")

	 @Select("<script> " +  
	            "SELECT * " +  
	            "from whcg_dcm.v_sdlj " +  
	            " <where> " +  
	            "  complaint_time > trunc(sysdate)" +  
	            " <if test='xzqh != null'>and zone_name=#{xzqh}</if> " +  
	            " </where> " +  
	            " </script> ")  
    public List<NoiseAndBuilding> getAll(@Param("xzqh")String xzqh);

	 //违章建筑数
//    @Select("select count(*) num from whcg_dcm.v_sdlj  t where t.COMPLAINT_TIME > trunc(sysdate)")
	 @Select("<script> " +  
	            "SELECT count(*) num " +  
	            "from whcg_dcm.v_sdlj " +  
	            " <where> " +  
	            "  complaint_time > trunc(sysdate)" +  
	            " <if test='xzqhname != null'>and zone_name=#{xzqhname}</if> " +  
	            " </where> " +  
	            " </script> ")  
	 public int getBuildingNum(@Param("xzqhname")String xzqhname);
}
