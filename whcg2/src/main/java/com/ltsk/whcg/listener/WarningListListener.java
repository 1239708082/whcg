package com.ltsk.whcg.listener;

import java.util.ArrayList;
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

import com.ltsk.whcg.entity.GasWarningList;
import com.ltsk.whcg.entity.WarningArea;
import com.ltsk.whcg.service.BridgeDefectRecordService;
import com.ltsk.whcg.service.WarningListService;

import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class WarningListListener implements ServletContextListener {
	@Autowired
	private WarningListService wlService;

	public static List<GasWarningList> warningList = new ArrayList<>();
	
/**
 * 由于警告指数统计请求过慢,所以把数据拿到内存里,优化用户体验.
 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext())
				.getAutowireCapableBeanFactory().autowireBean(this);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		executor.execute(() -> {
			while (true) {
				try {
					warningList = wlService.getWarning("420100000000");
					log.info("警告指数统计更新成功！！");
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