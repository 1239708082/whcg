package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Ccsyc;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KitchenWasteCarMapper {

//    @Select("select * from CCSYC where updatetime > (sysdate - 1/2880)")
	@Select({"<script>",
        "SELECT * FROM CCSYC t",
        "WHERE updatetime > (sysdate - 1/2880)",
        "<when test='xzqh!=null'>",
        "AND organization like #{xzqh}",
        "</when>",
        "</script>"})
    List<Ccsyc> getAll(@Param("xzqh")String xzqh);
	
	
//	@Select("select count(*) from CCLJCL")
	@Select({"<script>",
        "SELECT count(*) FROM CCLJCL  ",
        "WHERE  devtype = '2' ",
        "<when test='xzqh!=null'>",
        "AND districtname = #{xzqh}",
        "</when>",
        "</script>"})
	Integer get_sum(@Param("xzqh")String xzqh);
}
