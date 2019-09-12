package com.ltsk.whcg.bridge.mapper;

import com.ltsk.whcg.entity.BridgeDefectRecord;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BridgeDefectRecordMapper {

    @Select("SELECT * FROM [dbo].[V_Data_Daily_DefectRecord] where DateDiff(dd,CreatedTime,getdate())= 0 order by CreatedTime desc")
    public List<BridgeDefectRecord> getAll();

    @Select("SELECT count(*) num  FROM [dbo].[V_Data_Daily_DefectRecord] where DateDiff(dd,CreatedTime,getdate())= 0")
    public int getBridgeDefectRecordNum();
    
    @Select("select LEFT(ItemDescription,3) as xzqh,COUNT(*) as sum from V_Data_Daily_DefectRecord group by LEFT(ItemDescription,3)")
    public List<Map<String, Object>> getBridgeDefectSumGroupXzqh();
    
    @Select("select count(*) from V_Data_Daily_DefectRecord")
    public Integer getBridgeDefectSum();
    
    @Select({"<script>",
        "SELECT TOP 10 BridgeName,COUNT(*) as sum FROM V_Data_Daily_DefectRecord t ",
        "WHERE 1=1 ",
        "<when test='xzqh!=null'>",
        "AND LEFT(ItemDescription,3) = #{xzqh} ",
        "</when>",
        "group by BridgeName order by sum desc",
        "</script>"})
    public List<Map<String, Object>> getBridgeDefectSumGroupName(@Param("xzqh")String xzqh);
    
    @Select("select convert(int,LEFT(CONVERT(VARCHAR,RecordTime,108),2)) / 2 as  times,COUNT(*) as num from V_Data_Daily_DefectRecord where LEFT(ItemDescription,3)=#{xzqh} group by convert(int,LEFT(CONVERT(VARCHAR,RecordTime,108),2)) / 2 order by times")
    public List<Map<String, Object>> getBridgeDefectNumQJ(String xzqh);
    
}
