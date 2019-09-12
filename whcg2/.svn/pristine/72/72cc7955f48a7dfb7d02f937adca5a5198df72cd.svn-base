package com.ltsk.whcg.zhjg.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.ltsk.whcg.entity.Server;
import com.ltsk.whcg.entity.ServerStatistics;
import com.ltsk.whcg.entity.User;

@Mapper
@Repository
public interface ServiceManageMapper {

	@Select("select * from ZHJGINFO.SYS_SERVER where chinesename is not null")
	List<Server> listAllServiceName();
	
	@Insert("insert into ZHJGINFO.SYS_SERVER_STATISTICS values(#{servertype},#{name},to_date(#{time},'yyyy-mm-dd hh24:mi:ss'),#{usertype})")
	Integer addServerStatistics(ServerStatistics serverStatistics);
	
	@Select("select type from ZHJGINFO.SYS_SERVER where name=#{name}")
	String getServerType(@Param("name") String name);
	
	@Select("Select count(*) from ZHJGINFO.SYS_SERVER_STATISTICS where time BETWEEN "
			+ "to_date(#{starttime},'yyyy-mm-dd hh24:mi:ss') and "
			+ "to_date(#{endtime},'yyyy-mm-dd hh24:mi:ss') ")
	Integer getAllServerCount(@Param("starttime") String starttime, @Param("endtime") String endtime);

	@Select("Select servertype,count(servertype) as count from ZHJGINFO.SYS_SERVER_STATISTICS where time BETWEEN "
			+ " to_date(#{starttime},'yyyy-mm-dd hh24:mi:ss') and"
			+ " to_date(#{endtime},'yyyy-mm-dd hh24:mi:ss')"
			+ " group by servertype")
	List<Map<String,Integer>> getServerCountByServerType(@Param("starttime") String starttime, @Param("endtime") String endtime);
	
	@Select("Select usertype,count(usertype) as count from ZHJGINFO.SYS_SERVER_STATISTICS where time BETWEEN"
			+ " to_date(#{starttime},'yyyy-mm-dd hh24:mi:ss') and"
			+ " to_date(#{endtime},'yyyy-mm-dd hh24:mi:ss') and usertype is not null "
			+ " group by usertype order by count desc")
	List<Map<String, Integer>> getServerCountByUsertype(@Param("starttime") String starttime, @Param("endtime") String endtime);
	
	
	@Select("select * from SYS_SERVER s where s.name not in(select fwname from SYS_SERVER_PROCESS p where p.username=#{username} and p.state in(0,2))"
			+ "and s.chinesename is not null"
			+ " order by id")
	List<Server> getserverName(@Param("username") String username);

	@Delete("delete from ZHJGINFO.SYS_SERVER_STATISTICS t where t.time<trunc(sysdate)-7")
	Integer deleteServerStatistics();
	
//	@Insert("insert into MUCK.ZFRY values(#{zfry.id},#{zfry.realname},#{zfry.phone},#{zfry.deptname},#{zfry.js},#{zfry.lat},#{zfry.lon},#{zfry.scsj},#{zfry.sczh},#{zfry.tenflag},#{zfry.jgbm})")
//	Integer addZfry(@Param("zfry")Zfry zfry);
//	
//	@Insert("insert into MUCK.RQGD values(#{rqgd.id},#{rqgd.keycode},#{rqgd.symcode},#{rqgd.feature},#{rqgd.appendage},#{rqgd.roadname},#{rqgd.ownerunit},#{rqgd.x},#{rqgd.y})")
//	Integer addRqgd(@Param("rqgd")Rqgd rqgd);
	
}
