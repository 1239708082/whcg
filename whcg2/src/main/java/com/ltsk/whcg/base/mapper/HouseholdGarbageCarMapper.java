package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.GfclRealtime;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseholdGarbageCarMapper {

	/**
	 * 查询所有生活垃圾车辆总数
	 * @param xzqh_str
	 * @return
	 */
	 @Select({"<script>",
	        "SELECT count(*) sum FROM GFCL_REALTIME t",
	        "WHERE updatetime > trunc( sysdate -1/1440) ",
	        "<when test='xzqh_str!=null'>",
	        "AND xzqhname = #{xzqh_str}",
	        "</when>",
	        "</script>"})
    Integer count(@Param("xzqh_str")String xzqh_str);

	 /**
	  * 查询在线车辆数量
	  * @param carstatus
	  * @param xzqh
	  * @return
	  */
    @Select({"<script>",
        "SELECT * FROM GFCL_REALTIME t",
        "WHERE t.carstatus != 'null' and carstatus != #{carstatus} and updatetime > trunc( sysdate -1/1440)",
        "<when test='xzqh!=null'>",
        "AND xzqhname = #{xzqh}",
        "</when>",
        "</script>"})
    List<GfclRealtime> getAllRealtime(@Param("carstatus") String carstatus,@Param("xzqh") String xzqh);
}
