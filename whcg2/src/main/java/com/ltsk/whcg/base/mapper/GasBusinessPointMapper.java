package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Gasbusinesspoint;
import com.ltsk.whcg.entity.Unload;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasBusinessPointMapper {

//    @Select("select * from GASBUSINESSPOINT where district_cn = #{xzqh}")
    @Select("<script> " +  
            "SELECT * " +  
            "from GASBUSINESSPOINT t " +  
            " <where> "
            + " t.latitude like '30%' " +  
            " <if test='xzqh != null'>and district_cn=#{xzqh}</if> " +  
            " </where> " +  
            " </script> ")  
    List<Gasbusinesspoint> getAll(@Param("xzqh")String xzqh);
    @Select("SELECT count(*) from GASBUSINESSPOINT t where t.latitude like '30%'")
    Integer getSum();
}
