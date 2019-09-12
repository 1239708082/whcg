package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Ccljcydw;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KitchenWasteUnitMapper {
//    @Select("select * from CCLJCYDW where xy is not null and xzqh=#{xzqh}")
    @Select({"<script>",
        "SELECT * FROM CCLJCYDW",
        "WHERE 1=1 and xy is not null",
        "<when test='xzqh!=null'>",
        "AND xzqh = #{xzqh}",
        "</when>",
        "</script>"})
    List<Ccljcydw> getAll(@Param("xzqh")String xzqh);
}
