package com.ltsk.whcg.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface ServiceManagementService {

//	使用拦截器记录服务接口访问
	void serviceInterceptor(HttpServletRequest request,HttpSession session);
	
//	查询服务接口访问记录，并统计(时间段)
	List<String> getServerCountSelrvice();
	
	List<Map<String, Integer>> getServerCountByServerType();
	
	List<Map<String, Integer>> getServerCountByUserType();
}
