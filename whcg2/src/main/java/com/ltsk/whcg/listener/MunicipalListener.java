package com.ltsk.whcg.listener;


import com.ltsk.whcg.service.BridgeDefectRecordService;
import com.ltsk.whcg.service.WarningListService;
import com.ltsk.whcg.entity.GasWarningList;
import com.ltsk.whcg.entity.StationDetail;
import com.ltsk.whcg.entity.WarningArea;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;


@WebListener
@Slf4j
@Order(2)
public class MunicipalListener implements ServletContextListener {
    @Autowired
    private BridgeDefectRecordService bridgeDefectRecordService;

    @Autowired
    private WarningListService warningListService;
    

    public static JsonObject totalData = new JsonObject();
   
    public static JsonObject warningData = new JsonObject();//各区警告指数统计
    public static JsonObject areaData = new JsonObject();//桥梁病害数处理状态
    public static JsonObject bridgeData = new JsonObject();//桥梁病害数

    public MunicipalListener() {
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
                	//这个桥梁病害处理状态不用分区,所以放在循环外得到
                	List<Map<String, Object>> list3 = BridgeDefectListener.bridgeDefectNumMap.get("bridgeDefectNumGroupStatus");
                	
                	try {
                    	Map<String, String> xzqhmap = XZQHListener.XZQHMap;
                    	for (String s : xzqhmap.keySet()) {
                    		
                    		if("420100000000".equals(s)||"420101000000".equals(s)){
                    			//市级各区警告指数图标
                    			JsonArray json1 = new JsonArray();
                    			List<GasWarningList> list= warningListService.getWarning(s);
                         		for (GasWarningList gas : list) {
                        			JsonObject obj = new JsonObject();
                        			obj.put("xzqh", gas.getXzqh());
                        			obj.put("todayDate", gas.getTodayDate());
                        			obj.put("yesterdayDate", gas.getYesterdayDate());
                        			json1.add(obj);
    							}
                         		warningData.put("warningData_"+s,json1);
                    		}else {
                    			//区级各区警告指数图标
                    			JsonArray json1 = new JsonArray();
                    			List<WarningArea> list =(List<WarningArea>) warningListService.getWarnByXzqh(s);
                    			 for (WarningArea gas : list) {
                    					JsonObject obj = new JsonObject();
                            			obj.put("time", gas.getTime());
                            			obj.put("num", gas.getNum());
                            			json1.add(obj);
								}
                    			 warningData.put("warningData_"+s, json1);
                    		}
                    		
                    		//今日站点情况汇总
                    		Map<String,List<StationDetail>> map = warningListService.getEqDevice(s);
                    			JsonObject jo = new JsonObject();
                    			JsonArray json5 = new JsonArray();
								List<StationDetail> list = map.get("today");
                    			for (StationDetail sta : list) {
                    				JsonObject obj = new JsonObject();
                        			obj.put("title", sta.getTitle());
                        			obj.put("num", sta.getNum());
                        			json5.add(obj);
								}
                    			jo.put("today", json5);
                    			
                    			JsonArray json2 = new JsonArray();
								List<StationDetail> list2 = map.get("week");
                    			for (StationDetail sta : list2) {
                    				JsonObject obj = new JsonObject();
                        			obj.put("title", sta.getTitle());
                        			obj.put("num", sta.getNum());
                        			json2.add(obj);
								}
                    			jo.put("week", json2);
                    			totalData.put("totalData_"+s, jo);
                    			
                    			//桥梁病害数处理情况
                    			JsonArray json3 = new JsonArray();
                    			if(list3!=null){
                    				for (Map<String, Object> map2 : list3) {
                    					JsonObject obj = new JsonObject();
                    					obj.put("STATE", map2.get("STATE"));
                    					obj.put("NUM", map2.get("NUM")+"");
                    					json3.add(obj);
                    				}
                    			}
                    			
                    			areaData.put("areaData_"+s, json3);
                    			
                    			//桥梁病害数
                    			JsonArray json4 = new JsonArray();
                    			List<Map<String, Object>> list4 = bridgeDefectRecordService.getBridgeDefectSumGroupName(s);
                    			
                    			for (Map<String, Object> map2 : list4) {
                					JsonObject obj = new JsonObject();
                					obj.put("BridgeName",map2.get("BridgeName"));
                					obj.put("sum", map2.get("sum"));
                					json4.add(obj);
							}
                    			bridgeData.put("bridgeData_"+s, json4);
							}
                    	
                        log.info("市政推送初始化查询助手太累了，休息30秒钟！");
                        Thread.sleep(30000);
                    } catch (Exception e) {
                        log.error("市政推送初始化查询失败!"+e.getMessage());
                        e.printStackTrace();
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

