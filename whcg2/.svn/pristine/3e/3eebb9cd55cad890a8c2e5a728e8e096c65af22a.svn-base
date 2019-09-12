package com.ltsk.whcg.listener;


import com.ltsk.whcg.service.BuildingService;
import com.ltsk.whcg.service.NoiseService;
import com.ltsk.whcg.entity.NoiseAndBuilding;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;


//@WebListener
@Slf4j
public class LawListener implements ServletContextListener {
    @Autowired
    private NoiseService noiseService;

    @Autowired
    private BuildingService buildingService;

    //TODO  There will autowire StringRedisTeamplate.
    //@Autowired
    //private StringRedisTemplate redisTemplate;

    public static List<Map<String,Object>> lawInit = new ArrayList<>();

    public LawListener() {
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0)  {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)  {
        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext())
                .getAutowireCapableBeanFactory().autowireBean(this);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    	executor.execute(()-> {
                while (true) {
                    try {
                        List<Map<String, Object>> result = new ArrayList<>();
                        List<NoiseAndBuilding> noise = noiseService.getAllNoise("420100000000");
                        noise.forEach(e->{
                            HashMap<String, Object> obj = new HashMap<>();
                            obj.put("id", e.getComplaint_id());
                            obj.put("name", e.getTitle());
                            obj.put("barriertype", 5);
                            obj.put("updatetime", e.getComplaint_time() + "");
                            obj.put("eventType", "执法");
                            obj.put("warningType", "施工扰民");
                            result.add(obj);
                            });

                        List<NoiseAndBuilding> buildings = buildingService.getAllBuilding("420100000000");
                        buildings.forEach(e -> {
                            HashMap<String, Object> obj = new HashMap<>();
                            obj.put("id",e.getComplaint_id());
                            obj.put("name", e.getTitle());
                            obj.put("barriertype", 6);
                            obj.put("updatetime", e.getComplaint_time()+"");
                            obj.put("eventType", "执法");
                            obj.put("warningType", "私搭乱建");
                            result.add(obj);
                        });
                        //TODO There will add data to redis.
                        //redisTemplate.opsForValue().set("law",result.toString(),7200,TimeUnit.SECONDS);
                        LawListener.lawInit = result;
                        log.info("执法推送初始化查询助手太累了，休息30秒钟！");
                        Thread.sleep(30000);
                    } catch (Exception e) {
                        log.error("执法推送初始化查询失败!"+e.getMessage());
                    	try {
    						Thread.sleep(30000);
    					} catch (Exception e1) {
    						e1.printStackTrace();
    					}
                        continue;
                    }
                }
           });
       }
    }

