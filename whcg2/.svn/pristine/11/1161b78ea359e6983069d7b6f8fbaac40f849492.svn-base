package com.ltsk.whcg.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltsk.whcg.entity.ServerStatistics;
import com.ltsk.whcg.service.ServiceManagementService;
import com.ltsk.whcg.zhjg.mapper.ServiceManageMapper;

import io.vertx.core.impl.launcher.commands.StartCommand;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
@Slf4j
@Service
public class ServiceManagementServiceImpl implements ServiceManagementService{
	
	@Autowired
	private ServiceManageMapper mapper;
	@Autowired
	private StringRedisTemplate template;
	
	@Transactional
	@Override
	public void serviceInterceptor(HttpServletRequest request,HttpSession session) {
		
		try {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());//获取当前时间
		ServerStatistics serverStatistics = new ServerStatistics();
		String servername = request.getServletPath().replace("/", "");
		serverStatistics.setName(servername);
		
//		通过服务名查询服务类型
		String serverType = mapper.getServerType(servername);
		if (serverType!=null) {
			serverStatistics.setServertype(serverType);
			serverStatistics.setTime(date);
			String token = request.getHeader("token");			
			if (token==null) {
				serverStatistics.setUsertype("");
			}else {
				String user = template.opsForValue().get(token);
				JSONObject userJson = JSONObject.fromObject(user);
				serverStatistics.setUsertype(userJson.getString("xzqh_str"));
			}
			mapper.addServerStatistics(serverStatistics);
		}
		} catch (Exception e) {
			log.info("服务查询记录添加失败");
		}
	}


	@Override
	public List<String> getServerCountSelrvice() {
		try {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		ArrayList<String> arrayList = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.MINUTE, 59);
		calendar1.set(Calendar.SECOND, 59);
		for (int i = 0; i <24; i++) {
			calendar.set(Calendar.HOUR_OF_DAY, i);
			calendar1.set(Calendar.HOUR_OF_DAY, i);
		    String date = df.format(calendar.getTime());//获取当前时间
		    String date1 = df.format(calendar1.getTime());//获取当前时间
		    Integer allServerCount = mapper.getAllServerCount(date, date1);
		    arrayList.add(allServerCount+"");
		}
		return arrayList;
		
	} catch (Exception e) {
		log.info("服务时间段频次统计查询失败");
		return new ArrayList<>();
	}
	}


	@Override
	public List<Map<String, Integer>> getServerCountByServerType() {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			String starttime=df.format(calendar.getTime());
			
			Calendar calendar1 = Calendar.getInstance();
			calendar1.set(Calendar.HOUR_OF_DAY, 23);
			calendar1.set(Calendar.MINUTE, 59);
			calendar1.set(Calendar.SECOND, 59);
			String endtime=df.format(calendar1.getTime());
			List<Map<String, Integer>> list = mapper.getServerCountByServerType(starttime,endtime);
			return list;
		} catch (Exception e) {
			log.info("服务类型频次统计失败");
			return new ArrayList<>();
		}
		
	}


	@Override
	public List<Map<String, Integer>> getServerCountByUserType() {
	try {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		String starttime=df.format(calendar.getTime());
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.HOUR_OF_DAY, 23);
		calendar1.set(Calendar.MINUTE, 59);
		calendar1.set(Calendar.SECOND, 59);
		String endtime=df.format(calendar1.getTime());
		List<Map<String, Integer>> list = mapper.getServerCountByUsertype(starttime,endtime);
		return list;
	} catch (Exception e) {
		log.info("服务类型频次统计失败");
		return new ArrayList<>();
	}
	}	
}
