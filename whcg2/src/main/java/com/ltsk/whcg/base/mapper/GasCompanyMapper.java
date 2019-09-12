package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Gascompany;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasCompanyMapper {

    @Select("<script> " +  
            "SELECT * " +  
            "from GASCOMPANY t " +  
            " <where> " +  
            " t.longitude like '11_.%' and t.latitude like '3_.%' " +  
            " <if test='xzqh != null'>and district_cn= #{xzqh}</if> " +  
            " </where> " +  
            " </script> ")  
    public List<Gascompany> getAll(@Param("xzqh")String xzqh);
    @Select("SELECT count(*) from GASCOMPANY t where t.longitude like '11_.%' and t.latitude like '3_.%'")
    Integer getSum();
}
