package com.ltsk.whcg.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ltsk.whcg.entity.ServerStatistics;
import com.ltsk.whcg.service.ServiceManagementService;
import com.ltsk.whcg.zhjg.mapper.ServiceManageMapper;

@Component
public class ServiceRecordInterceptor implements HandlerInterceptor {

	@Autowired
	private ServiceManagementService serviceManagementService;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		 如果该请求处理器为方法处理器（controller类的方法）
		if (handler instanceof HandlerMethod) {
//			HandlerMethod hm=(HandlerMethod)handler;	
			HttpSession session = request.getSession();
			serviceManagementService.serviceInterceptor(request,session);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	 
}
