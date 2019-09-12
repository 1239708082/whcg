package com.ltsk.whcg.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ltsk.whcg.entity.Ccljcz;
import com.ltsk.whcg.entity.Ccljtoday;
import com.ltsk.whcg.entity.GetCcljWeight;

@Mapper

public interface GetCcljWeightMapper {
	
	@Select("select sum(neatweight)/1000 weight,depname key from CCLJCZ where weightime >=trunc(sysdate) group by depname")
	public List<Ccljtoday> getToday();
	
	@Select("select to_char(weightime,'mm/dd') time,round(sum(neatweight)/1000) weight,depname from CCLJCZ where weightime between trunc(sysdate)-7 and trunc(sysdate) group by to_char(weightime,'mm/dd'),depname order by time")
	public List<GetCcljWeight> getWeight();
	
	@Select("select orgname,round(sum(neatweight)/1000) weight from CCLJCZ c left join xzqh x on c.orgname=x.name where weightime>=trunc(sysdate) group by orgname order by min(x.id) ")
	public List<GetCcljWeight> getWrightOrgname();
	
	@Select("select to_char(weightime,'yyyy/mm/dd') time,ceil(sum(neatweight)/1000) weight,orgname from CCLJCZ where weightime between trunc(sysdate)-7 and trunc(sysdate) group by to_char(weightime,'yyyy/mm/dd'),orgname having orgname=#{xzqh} order by time")
	public List<GetCcljWeight> getWeightByXzqh(@Param("xzqh")String xzqh);
//	获取区级当日24小时统计数据
	@Select("select trunc(to_number(to_char(weightime, 'hh24')) / 2) as  times,round(sum(neatweight)/1000) as weight from CCLJCZ where weightime > trunc(sysdate) and orgname=#{xzqh} group by trunc(to_number(to_char(weightime, 'hh24')) / 2) order by  times")
	public List<GetCcljWeight> getWeightOrgnameByXzqh(@Param("xzqh")String xzqh);

//	获得市级用户今天餐厨垃圾处理总量
	@Select({"<script>",
        "SELECT sum(t.neatweight)/1000 sum FROM CCLJCZ t",
        "WHERE t.weightime>=trunc(sysdate) ",
        "<when test='xzqh!=null'>",
        "AND orgname = #{xzqh}",
        "</when>",
        "</script>"})
	public Double getWeight_sum(@Param("xzqh")String xzqh);
	
	//获得生活垃圾各厂实时进场量
	@Select("select sum(neatweight)/1000 totalweight,depname from CCLJCZ t where  t.weightime>=trunc(sysdate) group by depname")
	public List<Ccljcz> getSumByFac();
}
