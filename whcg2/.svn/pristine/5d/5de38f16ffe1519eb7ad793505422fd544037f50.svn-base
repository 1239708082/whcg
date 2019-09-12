package com.ltsk.whcg.muck.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.entity.MuckTrace;

@Repository
public interface MuckTrackMapper {

	
	@Select("select lon gdx,lat gdy from (select t.* ,row_number() over(partition by t.lon order by t.updatetime )mm from  ${tableName} t  where t.vehicleno = #{vehicleno}) where mm=1 order by updatetime")
	List<MuckTrace> getTrace(@Param("tableName")String tableName,@Param("vehicleno") String vehicleno);
	
	
}
