package com.ltsk.whcg.base.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexMapper {

    //油烟违规数
//    @Select("select count(*) num from ssyybjxx s ,cyyycginfo c where s.hotelname = c.hotelname ")
	@Select("<script> " +  
            "SELECT count(*) num " +  
            "from ssyybjxx s ,cyyycginfo c " + 
            "where s.hotelname = c.hotelname"+
            " <if test='xzqhname != null'>and c.district=#{xzqhname}</if> " +  
            " </script> ")  
    Integer countFumeAlarm(@Param("xzqhname")String xzqhname);

    //生活垃圾日进场量
//    @Select("select sum(netweight) num from GFCZZD ")
	@Select("<script> " +  
            "SELECT sum(netweight) num " +  
            "from CZJL  " + 
            "where taredatetime>trunc(sysdate) "+
            " <if test='xzqhname != null'>and area=#{xzqhname}</if> " +  
            " </script> ")  
    Double countHouseholdGarbage(@Param("xzqhname")String xzqhname);

    // 生活垃圾运输车在线
//    @Select("select count(*)  num from GFCL_REALTIME t where t.carstatus != 'null' and t.carstatus != #{status}")
	@Select("<script> " +  
            "SELECT count(*)  num " +  
            "from GFCL_REALTIME t   " + 
            "where t.carstatus= #{status} or t.carstatus =  #{type1} "+
            " <if test='xzqhname != null'>and xzqhname=#{xzqhname}</if> " +  
            " </script> ")  
	Integer countHouseholdGarbageCar(@Param("status")String type,@Param("type1") String type1,@Param("xzqhname")String xzqhname);

    // 生活垃圾运输车总量
//    @Select("select count(*) num from GFCL_REALTIME")
	@Select("<script> " +  
            "SELECT count(*)  num " +  
            "from GFCL_REALTIME t where 1=1   " + 
            " <if test='xzqhname != null'>and xzqhname=#{xzqhname}</if> " +  
            " </script> ") 
    Integer countHouseholdGarbageCarSum(@Param("xzqhname")String xzqhname);

    // 餐厨垃圾总进场量
//    @Select("select sum(t.neatweight) num from CCLJCZ t where  t.weightime > trunc(sysdate)")
    @Select("<script> " +  
            "SELECT sum(t.neatweight) num " +  
            "from CCLJCZ t  where  t.weightime > trunc(sysdate) " + 
            " <if test='xzqhname != null'>and ORGNAME=#{xzqhname}</if> " +  
            " </script> ") 
    Double countKitchenWaste(@Param("xzqhname")String xzqhname);

    // 餐厨垃圾运输车在线
//    @Select("select count(*) num  from CCSYC where updatetime > (sysdate - 1/2880)")
    @Select("<script> " +  
            "SELECT count(*) num " +  
            "from CCSYC where  updatetime > (sysdate - 1/2880) " + 
            " <if test='xzqhname != null'>and organization=#{xzqhname}</if> " +  
            " </script> ") 
    Integer countKitchenWasteCar(@Param("xzqhname")String xzqhname);

    // 获取可疑工地、消纳点数量
//    @Select("select count(*) num from SUSPICSITEUNLOAD s where s.barriertype = #{type} and updatetime = ( select max(updatetime) from SUSPICSITEUNLOAD where barriertype = #{type}) and name like '湖北省武汉市%'")
    @Select("<script> " +  
            "select count(*) num " +  
            "from SUSPICSITEUNLOAD s where  s.barriertype = #{type} and updatetime = ( select max(updatetime) from SUSPICSITEUNLOAD where barriertype = #{type}) and name like '湖北省武汉市%'" + 
            " <if test='xzqhname != null'>and name like #{xzqhname}</if> " +  
            " </script> ") 
    Integer countSuspicSiteUnloadNum(@Param("type") String type,@Param("xzqhname") String xzqhname);

    // 获取今日工地数量
    @Select("select count(*) num from SITE s where  updatetime = ( select max(updatetime) from SITE)")
    Integer countSiteNum();

    // 获取今日消纳点数量
    @Select("select count(*) num from UNLOAD s where  updatetime = ( select max(updatetime) from UNLOAD)")
    Integer countUnloadNum();


}
