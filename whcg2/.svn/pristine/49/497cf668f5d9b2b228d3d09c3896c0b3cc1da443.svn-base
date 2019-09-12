package com.ltsk.whcg.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ltsk.whcg.service.BridgeDefectRecordService;

import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
@Order(2)
public class BridgeDefectListener implements ServletContextListener {
	@Autowired
	private BridgeDefectRecordService bdrs;

	public static Map<String, List<Map<String, Object>>> bridgeDefectNumMap = new HashMap<>();

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext())
				.getAutowireCapableBeanFactory().autowireBean(this);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		executor.execute(() -> {
			while (true) {
				try {//bridgeDefectNumGroupStatus
					List<Map<String, Object>> bridgeDefectNumGroupStatus = bdrs.getBridgeDefectNumGroupStatus();
					List<Map<String, Object>> bridgeDefectNumGroupUnit = bdrs.getBridgeDefectNumGroupUnit();
					bridgeDefectNumMap.put("bridgeDefectNumGroupStatus", bridgeDefectNumGroupStatus);
					bridgeDefectNumMap.put("bridgeDefectNumGroupUnit", bridgeDefectNumGroupUnit);
					log.info("桥梁病害数更新成功！！");
					Thread.sleep(30000);
				} catch (Exception e) {
					log.error("桥梁病害数更新失败！！");
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

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
