package com.ltsk.whcg.listener;

import java.util.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ltsk.whcg.entity.XZQH;
import com.ltsk.whcg.service.XZQHService;

import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
@Component
@Order(1)
public class XZQHListener implements ServletContextListener {
	
	@Autowired
	private XZQHService xzqhService;

	public static Map<String, String> XZQHMap = new LinkedHashMap<>();

	 static{
	        XZQHMap.put("420100000000","全市");
	        XZQHMap.put("420102000000","江岸区");
	        XZQHMap.put("420103000000","江汉区");
	        XZQHMap.put("420104000000","硚口区");
	        XZQHMap.put("420105000000","汉阳区");
	        XZQHMap.put("420106000000","武昌区");
	        XZQHMap.put("420107000000","青山区");
	        XZQHMap.put("420118000000","武汉经济技术开发区");
	        XZQHMap.put("420111000000","洪山区");
	        XZQHMap.put("420112000000","东西湖区");
	        XZQHMap.put("420114000000","蔡甸区");
	        XZQHMap.put("420115000000","江夏区");
	        XZQHMap.put("420116000000","黄陂区");
	        XZQHMap.put("420117000000","新洲区");
	        XZQHMap.put("420119000000","武汉东湖新技术开发区");
	        XZQHMap.put("420113000000","汉南区");
	        XZQHMap.put("420120000000","东湖生态旅游风景区管委会");
	    }
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext())
				.getAutowireCapableBeanFactory().autowireBean(this);
		try {
//			List<XZQH> all = xzqhService.getAll();
//			for (int i = 0; i < all.size(); i++) {
//				XZQHMap.put(all.get(i).getNo(), all.get(i).getName());
//			}
			log.info("行政区划初始化成功！！");
		} catch (Exception e) {
			log.error("行政区划初始化失败!" + e.getMessage());
		}
	}

}
