/**
 * 
 */
package com.ltsk.whcg.base.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ltsk.whcg.entity.WasteTransferStation;

/**
 * @author YH
 * @ClassName: WasteTransferStationMapper 
 * @Description
 * @date 2019年7月30日 下午5:46:13 
 */
public interface WasteTransferStationMapper {

	@Select("select * from CGGFINFO.ZYSSINFO where xzqh = #{xzqh}")
	List<WasteTransferStation> listWasteTransferStationInfoByXzqh(@Param("xzqh") String xzqh);
	
	@Select("select * from CGGFINFO.ZYSSINFO ")
	List<WasteTransferStation> listWasteTransferStationInfo();
	
}
