package com.ltsk.whcg.listener;

import com.ltsk.whcg.entity.Muck;
import com.ltsk.whcg.entity.XZQH;
import com.ltsk.whcg.service.MuckService;
import com.ltsk.whcg.service.XZQHService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@WebListener
@Slf4j
public class MuckListener implements ServletContextListener {

    @Autowired
    private MuckService muckService;

    public static List<Muck> MUCK = new ArrayList<>();
    public static Integer MUCKSUM = new Integer(0);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext())
                .getAutowireCapableBeanFactory().autowireBean(this);
        try {
//            MUCK = muckService.getAll();
//            MUCKSUM = muckService.get_sum();
            log.info("渣土车初始化成功！！");
        } catch (Exception e) {
            log.error("渣土车初始化失败!" + e.getMessage());
        }
    }

}
