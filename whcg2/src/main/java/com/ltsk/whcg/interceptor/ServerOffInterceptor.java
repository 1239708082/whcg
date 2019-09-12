package com.ltsk.whcg.interceptor;

import com.ltsk.whcg.service.ServerService;
import io.vertx.core.json.JsonObject;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/*
 * 服务开关拦截器
 * */
@Component
public class ServerOffInterceptor implements HandlerInterceptor {

    @Autowired
    private ServerService serverService;
    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader("token");
        JSONObject user = null;
        String username="";
        if (token != null && !"".equals(token)) {
            user = JSONObject.fromObject(redisTemplate.opsForValue().get(token));
            username=user.get("username").toString();
        }
        String servername = httpServletRequest.getServletPath().replace("/", "");
        if ("admin".equals(username)) {
            return true;
        }
        String off = serverService.getOff(servername);
        if ("1".equals(off)) {
            JsonObject result = new JsonObject();
            httpServletResponse.setContentType("text/html;utf-8");
            httpServletResponse.setCharacterEncoding("utf-8");
            PrintWriter out = httpServletResponse.getWriter();
            result.put("success", false);
            result.put("data", "该服务已被暂停");
            out.println(result);
            out.flush();
            out.close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
