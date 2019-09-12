package com.ltsk.whcg.listener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ltsk.whcg.service.IndexService;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebListener
@Slf4j
@Order(2)
public class IndexListener implements ServletContextListener {
    @Autowired
    private IndexService indexService;

    public static Map<String,List<Object> > INDEX_S= new HashMap<>();
    public static Map<String,List<Object> > INDEX_M= new HashMap<>();
//    public static Map<String,List<Object> > INDEX_L= new HashMap<>();
//    public static JsonObject INDEX_S = new JsonObject();
//    public static JsonObject INDEX_M = new JsonObject();
//    public static JsonObject INDEX_L = new JsonObject();

    public IndexListener() {
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
                    	Map<String, String> xzqhmap = XZQHListener.XZQHMap;
                    	
                    	
//                		List<Object> list1 = indexService.getSanitationl("420100000000");
//                		List<Object> list2 = indexService.getSanitationl("420102000000");
//
//                		INDEX_S.put("sanitationl_420100000000", list1);
//                		INDEX_S.put("sanitationl_420102000000", list2);
                    	for (String s : xzqhmap.keySet()) {
                    		List<Object> list1 = indexService.getSanitationl(s);
                    		INDEX_S.put("sanitationl_"+s, list1);
						}
                    	
                    	for (String s : xzqhmap.keySet()) {
                    		List<Object> list2 = indexService.getMunicipal(s);

                    		INDEX_M.put("municipal_"+s, list2);
						}
//                    	for (String s : xzqhmap.keySet()) {
//                    		List<Object> list2 = indexService.getLaw(s);
//                    		INDEX_L.put("law_"+s, list2);
//						}
                    	
                        log.info("首页推送请求初始化查询组手太累了，休息30秒钟！");
                        Thread.sleep(30000);
                    } catch (Exception e) {
                        log.error("首页推送请求初始化查询失败！"+e.getMessage());
                    	try {
    						Thread.sleep(30000);
    					} catch (Exception e1) {
    						e1.printStackTrace();
    					}
                        e.printStackTrace();
                        continue;
                    }
                }
           });
       }
    }

