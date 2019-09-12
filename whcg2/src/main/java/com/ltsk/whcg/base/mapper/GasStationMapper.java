package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Gasstation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasStationMapper {

    @Select("<script> " +  
            "SELECT * " +  
            "from GASSTATION " +  
            " <where> " +  
            "  station_type_cn = #{type}" +  
            " <if test='xzqh != null'>and district_cn=#{xzqh}</if> " +  
            " </where> " +  
            " </script> ")  
    List<Gasstation> getByType(@Param("type") String type,@Param("xzqh")String xzqh);
    @Select("SELECT count(*) from GASSTATION where station_type_cn =#{type}")
    Integer getSum(@Param("type")String type);
}
