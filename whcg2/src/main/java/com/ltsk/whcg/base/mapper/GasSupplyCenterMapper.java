package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.GasSite;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 瓶装气供应点
 */
@Repository
public interface GasSupplyCenterMapper {

//    @Select("select * from gas_site")
    @Select("<script> " +  
            "SELECT * " +  
            "from gas_site " +  
            " <where> " +  
            "  1=1 " +  
            " <if test='xzqh != null'>and xzqh=#{xzqh}</if> " +  
            " </where> " +  
            " </script> ")  
    public List<GasSite> getAll(@Param("xzqh")String xzqh);
    @Select("update GAS_SITE set gdx=#{gdx},gdy=#{gdy} where gasid=#{gasid}")
    public Integer update(@Param("gdx")String gdx,@Param("gdy")String gdy,@Param("gasid")String gasid);
    @Select("SELECT count(*) from gas_site")
    public Integer getSum();
}
