package com.ltsk.whcg.listener;


import com.ltsk.whcg.service.KitchenWasteUnitService;
import com.ltsk.whcg.entity.CcljcydwNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


@WebListener
@Slf4j
public class KitchenWasteUnitListener implements ServletContextListener {
    @Autowired
    private KitchenWasteUnitService kitchenWasteUnitService;


    public static List<CcljcydwNew> KitchenWasteUnit = new ArrayList<CcljcydwNew>();

    public KitchenWasteUnitListener() {
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
                        KitchenWasteUnitListener.KitchenWasteUnit = kitchenWasteUnitService.getAll("420100000000");
                        log.info("餐厨垃圾数据更新查询助手太累了，休息30秒钟！");
                        Thread.sleep(30000);
                    } catch (Exception e) {
                        log.error("餐厨垃圾数据更新查询失败!"+e.getMessage());
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

