package com.ltsk.whcg.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ltsk.whcg.entity.BridgeXzqh;

@Repository
public interface BridgeXzqhMapper {
	@Select({"<script>",
        "SELECT * FROM BRIDGEXZQH t",
        "WHERE 1=1",
        "<when test='xzqh!=null'>",
        "AND xzqh = #{xzqh}",
        "</when>",
        "</script>"})
	public List<BridgeXzqh> getAll(@Param("xzqh")String xzqh);
	
}
