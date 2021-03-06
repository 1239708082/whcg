package com.ltsk.whcg.interceptor;

import io.vertx.core.json.JsonObject;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

/**
 * @program: supervise
 * @description: 自定义拦截器
 * @author: Mr.Wang
 * @create: 2019-01-07 16:02
 **/
//@Component
public class MyInterceptor implements HandlerInterceptor{

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String id = request.getSession().getId();
        String token = request.getHeader("token");
        String token2 = "";
        if(token != null && !"".equals(token)) {
             token2 = redisTemplate.opsForValue().get(token);
        }
    	HttpSession session = request.getSession();
    	JSONObject userInfo = (JSONObject)session.getAttribute("user");
    	
        String requestURI = request.getRequestURI();
        String url1 = "/exportDaily";
        String url2 = "excel_tj";
        String url3 = "/getAllByArea";
        String url4 = "/exportByArea";
        String url5 = "/changeXy";
        if(requestURI.contains(url1)||requestURI.endsWith(url2)||requestURI.contains(url3)||
        		requestURI.endsWith(url4)||requestURI.endsWith(url5)){
        	return true;
        }
        if (userInfo != null ||(token2!=null&!"".equals(token2))) {
            return true;
        } else {
            JsonObject result = new JsonObject();
            response.setContentType("text/html;utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            result.put("success",false);
            result.put("msg", "请先登录后再操作！！");
            out.println(result);
            out.flush();
            out.close();
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
