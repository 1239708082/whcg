package com.ltsk.whcg.listener;

import com.ltsk.whcg.service.FumeUnitService;
import com.ltsk.whcg.service.GetCcljWeightService;
import com.ltsk.whcg.service.HouseholdGarbageFactoryService;
import com.ltsk.whcg.service.SuspicSiteUnloadService;
import com.ltsk.whcg.entity.GarbageNow;
import com.ltsk.whcg.entity.GetCcljWeight;
import com.ltsk.whcg.entity.LampBlack;
import com.ltsk.whcg.entity.LastWeekSHLJ;
import com.ltsk.whcg.entity.Suspicsiteunload;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@WebListener
@Slf4j
@Order(2)
public class SanitationlListener implements ServletContextListener {
	@Autowired
	private SuspicSiteUnloadService suspicSiteUnloadService;
	@Autowired
	private HouseholdGarbageFactoryService garbageFactoryService;
	@Autowired
	private FumeUnitService fumeUnitService;
	@Autowired
	private GetCcljWeightService getCcljWeightService;

	public static JsonObject SUSPIC = new JsonObject();

	public static JsonObject GARBAGEWEEK = new JsonObject();// 生活垃圾前七天产生量

	public static JsonObject PREGARBAGE = new JsonObject();// 生活垃圾各区实时处理量

	public static JsonObject PRETAMPBLACK = new JsonObject();// 各区实时油烟报警信息


	public static JsonObject CCLJWEIGHT_WEEK = new JsonObject();// 市级及区级餐厨垃圾一周处理量
	public static JsonObject CCLJWEIGHT_NOW = new JsonObject();// 市级及区级餐厨垃圾实时处理量

	public SanitationlListener() {

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext())
				.getAutowireCapableBeanFactory().autowireBean(this);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		executor.execute(() -> {
			while (true) {
				try {
					Map<String, String> xzqhmap = XZQHListener.XZQHMap;
					JsonObject suspic = new JsonObject();
					for (String s : xzqhmap.keySet()) {
						String xzqh = xzqhmap.get(s);
						if ("420100000000".equals(s)) {
							xzqh = "";
						}
						JsonArray result = new JsonArray();
						List<Suspicsiteunload> site = suspicSiteUnloadService.getAllByType("1", xzqh);
						site.forEach(e -> {
							JsonObject obj = new JsonObject();
							obj.put("eventType", "工地");
							obj.put("warningType", "可疑工地");
							obj.put("id", e.getId());
							obj.put("gdx", e.getGdx());
							obj.put("gdy", e.getGdy());
							obj.put("name", e.getName());
							obj.put("updatetime", e.getUpdatetime() + "");
							result.add(obj);
						});

						List<Suspicsiteunload> unload = suspicSiteUnloadService.getAllByType("2", xzqh);
						unload.forEach(e -> {
							JsonObject obj = new JsonObject();
							obj.put("eventType", "消纳点");
							obj.put("warningType", "可疑消纳点");
							obj.put("id", e.getId());
							obj.put("gdx", e.getGdx());
							obj.put("gdy", e.getGdy());
							obj.put("name", e.getName());
							obj.put("updatetime", e.getUpdatetime() + "");
							result.add(obj);
						});
						suspic.put("suspic_" + s, result);
					}
					SanitationlListener.SUSPIC = suspic;

					// 前7天生活垃圾总理分站点查询
					for (String s : xzqhmap.keySet()) {
						List<List<LastWeekSHLJ>> lastWeek = garbageFactoryService.getLastWeek(s);
						JsonArray j11 = new JsonArray();
						if(lastWeek==null||lastWeek.size()<1){
							SanitationlListener.GARBAGEWEEK.put("garbageweek_" + s, j11);

						}else{
							for (int i = 0; i < lastWeek.size(); i++) {
								List<LastWeekSHLJ> inside = lastWeek.get(i);
								JsonArray j1 = new JsonArray();
								for (int j = 0; j < inside.size(); j++) {
									JsonObject obj = new JsonObject();
									LastWeekSHLJ bean = inside.get(j);
									obj.put("day", bean.getDay());
									obj.put("handleunit", bean.getHandleunit());
									obj.put("netweight", bean.getNetweight());
									j1.add(obj);
								}
								j11.add(j1);
							}
							}
						SanitationlListener.GARBAGEWEEK.put("garbageweek_" + s, j11);
					}
					// 获得生活垃圾处理厂实时信息
					for (String s : xzqhmap.keySet()) {
						if ("420100000000".equals(s)) {
							List<GarbageNow> list = garbageFactoryService.getNowGarbage(s);
							JsonArray json14 = new JsonArray();
							list.forEach(e -> {
								JsonObject obj = new JsonObject();
								obj.put("xzqh", e.getXzqh());
								obj.put("weigh", e.getWeigh());
								json14.add(obj);
							});
							SanitationlListener.PREGARBAGE.put("pregarbage_" + s, json14);
						} else {
							List<GarbageNow> list = garbageFactoryService.getNowGarbage(s);
							JsonArray json14 = new JsonArray();
							list.forEach(e -> {
								JsonObject obj = new JsonObject();
								// 这里为了方便前端显示，将time设置为xzqh
								obj.put("xzqh", e.getXzqh());
								obj.put("weigh", e.getWeigh());
								json14.add(obj);
							});
							SanitationlListener.PREGARBAGE.put("pregarbage_" + s, json14);
						}
					}

					// 实时油烟报警信息
					for (String s : xzqhmap.keySet()) {
						List<LampBlack> lamp = fumeUnitService.getTampblack(s);
						JsonArray json12 = new JsonArray();
						lamp.forEach(e -> {
							JsonObject obj = new JsonObject();
							obj.put("id", e.getId());
							obj.put("warningType", e.getWarningType());
							obj.put("alarmtime", e.getAlarmtime());
							obj.put("alarmtype", e.getAlarmtype());
							obj.put("alarmvalue", e.getAlarmvalue());
							obj.put("hotelname", e.getHotelname());
							json12.add(obj);
						});
						SanitationlListener.PRETAMPBLACK.put("pretampblack_" + s, json12);
					}

					// 重构一周餐厨垃圾数据
					Set<String> xzqh = xzqhmap.keySet();
					for (String xzqh_str : xzqh) {
						List<List<Map<String, Object>>> weightWeek = getCcljWeightService.getWeightWeek(xzqh_str);
						JsonArray jay = new JsonArray();
						for (List<Map<String, Object>> list : weightWeek) {
							JsonArray jay1 = new JsonArray();
							for (Map<String, Object> list2 : list) {
								JsonObject jot = new JsonObject();
								jot.put("time", list2.get("time"));
								jot.put("weight", list2.get("weight"));
								jot.put("depname", list2.get("depname"));
								jay1.add(jot);
							}
							jay.add(jay1);
						}
						CCLJWEIGHT_WEEK.put("ccljweightweek_" + xzqh_str, jay);
					}
					// 重构实时餐厨垃圾
					for (String xzqh_str : xzqh) {
						List<Map<String, Object>> weightNow = getCcljWeightService.getWeightNow(xzqh_str);
						JsonArray jsonarray = new JsonArray();
						for (Map<String, Object> list : weightNow) {
							JsonObject job = new JsonObject();
							job.put("key", list.get("key"));
							job.put("weight", list.get("weight"));
							jsonarray.add(job);
						}
						CCLJWEIGHT_NOW.put("ccljweightnow_" + xzqh_str, jsonarray);
					}
					

					log.info("环卫推送初始化查询助手太累了，休息30秒钟！");
					Thread.sleep(30000);
				} catch (Exception e) {
					log.error("环卫推送初始化查询失败!" + e.getMessage());
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
