package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Ccljc;
import com.ltsk.whcg.entity.Czjl;
import com.ltsk.whcg.entity.GarbageNow;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KitchenWasteFactoryMapper {

    @Select("select * from CCLJC")
    List<Ccljc>  getAll();

    @Select("<script> " +  
            "select * from (SELECT a.*,rownum rn from (SELECT * " +  
            "from  CZJL  " +  
            "<where>"+
             "  grossdatetime between to_date(#{startTime},'yyyy-MM-dd hh24:mi:ss') and to_date(#{endTime},'yyyy-MM-dd hh24:mi:ss') "+
            " <if test=' unit !=null '>"+
             "and handleunit =  #{unit}"+
             "</if> " +  
            " <if test='area !=null '>"+
            "and area =  #{area}"+
             "</if> " +  
            "</where>"+
           " and #{endNum} >= rownum"+
            " order by handleunit,grossdatetime ) a ) where rn > #{startNum}"+
            " </script> ")  
    List<Czjl> getAllToday(@Param("endNum") Integer endNum,@Param("startNum")Integer startNum,@Param("startTime")String startTime,@Param("endTime")String endTime, @Param("area")String area, @Param("unit")String unit);
    
  
    @Select("<script> " +  
            "SELECT * " +  
            "from  CZJL  " +  
            "<where>"+
             "   grossdatetime between to_date(#{startTime},'yyyy-MM-dd hh24:mi:ss') and to_date(#{endTime},'yyyy-MM-dd hh24:mi:ss') "+
            " <if test=' unit !=null '>"+
             "and handleunit =  #{unit}"+
             "</if> " +  
            " <if test='area !=null '>"+
            "and area =  #{area}"+
             "</if> " +  
            "</where>"+
            " order by handleunit,grossdatetime"+
            " </script> ")  
    List<Czjl> getAllList(@Param("startTime")String startTime,@Param("endTime")String endTime, @Param("area")String area, @Param("unit")String unit);

    
    //    @Select("select count(*) from CZJL z where taredatetime > trunc(sysdate)   order by taredatetime ")
    @Select("<script> " +  
            "SELECT count(*) " +  
            "from  CZJL " +  
            "<where>"+
             "  grossdatetime between to_date(#{startTime},'yyyy-MM-dd hh24:mi:ss') and to_date(#{endTime},'yyyy-MM-dd hh24:mi:ss') "+
            " <if test=' unit !=null '>"+
             "and handleunit =  #{unit}"+
             "</if> " +  
            " <if test='area !=null '>"+
            "and area =  #{area}"+
             "</if> " +  
            "</where>"+
            " </script> ")  
	Integer getCountToday(@Param("startTime")String startTime,@Param("endTime")String endTime, @Param("area")String area, @Param("unit")String unit);

//    @Select("select count(*) from CZJL z where taredatetime > trunc(sysdate) and productinorout = '1' ")
    @Select("<script> " +  
            "SELECT count(*) " +  
            "from  CZJL " +  
            "<where>"+
             " productinorout = '1' and  grossdatetime between to_date(#{startTime},'yyyy-MM-dd hh24:mi:ss') and to_date(#{endTime},'yyyy-MM-dd hh24:mi:ss') "+
            " <if test=' unit !=null '>"+
             "and handleunit =  #{unit}"+
             "</if> " +  
            " <if test='area !=null '>"+
            "and area =  #{area}"+
             "</if> " +  
            "</where>"+
            " order by grossdatetime "+
            " </script> ")  
    Integer getIn(@Param("startTime")String startTime,@Param("endTime")String endTime, @Param("area")String area, @Param("unit")String unit);
    
//    @Select("select count(*) from CZJL z where taredatetime > trunc(sysdate) and productinorout = '0' ")
    @Select("<script> " +  
            "SELECT count(*) " +  
            "from  CZJL " +  
            "<where>"+
             " productinorout = '0' and   grossdatetime between to_date(#{startTime},'yyyy-MM-dd hh24:mi:ss') and to_date(#{endTime},'yyyy-MM-dd hh24:mi:ss') "+
            " <if test=' unit !=null '>"+
             "and handleunit =  #{unit}"+
             "</if> " +  
            " <if test='area !=null '>"+
            "and area =  #{area}"+
             "</if> " +  
            "</where>"+
            " order by grossdatetime "+
            " </script> ")  
    Integer getOut(@Param("startTime")String startTime,@Param("endTime")String endTime, @Param("area")String area, @Param("unit")String unit);

//    @Select("select sum(netweight) from CZJL z where taredatetime > trunc(sysdate) and productinorout = '1' ")
    @Select("<script> " +  
            "SELECT sum(netweight) " +  
            "from  CZJL " +  
            "<where>"+
             " productinorout = '1' and  grossdatetime between to_date(#{startTime},'yyyy-MM-dd hh24:mi:ss') and to_date(#{endTime},'yyyy-MM-dd hh24:mi:ss')"+
            " <if test=' unit !=null '>"+
             "and handleunit =  #{unit}"+
             "</if> " +  
            " <if test='area !=null '>"+
            "and area =  #{area}"+
             "</if> " +  
            "</where>"+
            " order by grossdatetime "+
            " </script> ")  
  
    Double getInNum(@Param("startTime")String startTime,@Param("endTime")String endTime, @Param("area")String area, @Param("unit")String unit);
    
//    @Select("select sum(netweight) from CZJL z where taredatetime > trunc(sysdate) and productinorout = '0' ")
    @Select("<script> " +  
            "SELECT count(*) " +  
            "from  CZJL " +  
            "<where>"+
             " productinorout = '0' and  grossdatetime between to_date(#{startTime},'yyyy-MM-dd hh24:mi:ss') and to_date(#{endTime},'yyyy-MM-dd hh24:mi:ss') "+
            " <if test=' unit !=null '>"+
             "and handleunit =  #{unit}"+
             "</if> " +  
            " <if test='area !=null '>"+
            "and area =  #{area}"+
             "</if> " +  
            "</where>"+
            " order by grossdatetime "+
            " </script> ")  
    Double getOutNum(@Param("startTime")String startTime,@Param("endTime")String endTime, @Param("area")String area, @Param("unit")String unit);

    
    @Select("select distinct(handleunit) from czjl ")
	List<String> getUnit();
    
    @Select("select distinct(area) from czjl ")
   	List<String> getArea();

    
    @Select("SELECT area xzqh,sum(netweight) weigh from  CZJL where   grossdatetime between "
    		+ "to_date(#{startTime},'yyyy-MM-dd hh24:mi:ss') and to_date(#{endTime},'yyyy-MM-dd hh24:mi:ss') group by area")
	List<GarbageNow> getAllByArea(@Param("startTime")String startTime,@Param("endTime")String endTime);
}
