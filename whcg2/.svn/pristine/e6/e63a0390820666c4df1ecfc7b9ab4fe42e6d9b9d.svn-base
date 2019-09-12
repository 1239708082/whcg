package com.ltsk.whcg.dataPushFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltsk.whcg.listener.IndexListener;
import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.service.impl.IndexServiceImpl;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.LocalMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class IndexPushVerticle extends AbstractVerticle {

	public static HashMap<String, Object> sanMap = new HashMap<>();
	public static HashMap<String, Object> munMap = new HashMap<>();
	@Autowired
	private IndexServiceImpl indexService;

	SimpleDateFormat tdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	SimpleDateFormat udf = new SimpleDateFormat("yyyy/MM/dd");
	private long stime;
	private long etime;

	@Override
	public void start() {
		vertx.setPeriodic(60000, id -> {
			LocalMap<String, Integer> index = vertx.sharedData().getLocalMap("index");
			// 0表示没有worker在工作
			if (index.get("index") == 0) {
				vertx.executeBlocking(future -> {
					try {
						vertx.sharedData().getLocalMap("index").put("index", 1);
						stime = Calendar.getInstance().getTime().getTime() / 1000;
						JsonObject jo = new JsonObject();
//						Map<String, List<Object>> si = IndexListener.INDEX_S;
//						Map<String, List<Object>> mi = IndexListener.INDEX_M;
//						for (String s : si.keySet()) {
//							// array对应List
//							JsonArray js = new JsonArray(si.get(s));
//							// object 对应Map，把array分别put进去
//							jo.put(s, js);
//						}
//						for (String s : mi.keySet()) {
//							// array对应List
//							JsonArray js = new JsonArray(mi.get(s));
//							// object 对应Map，把array分别put进去
//							jo.put(s, js);
//
//						}
//						System.out.println("VERXICLE里的JOSON数据 :"+jo.toString());
						future.complete(jo);
					} catch (Exception e) {
						e.printStackTrace();
						future.fail(e);
					}
				}, res -> {
					if (res.succeeded()) {
//						JsonObject result = (JsonObject) res.result();
						JsonObject result = new JsonObject();
						Map<String, String> xzqhMap = XZQHListener.XZQHMap;
						Map<String, List<Object>> si = IndexListener.INDEX_S;
						Map<String, List<Object>> mi = IndexListener.INDEX_M;
						if(si!=null&&xzqhMap!=null){
							for (String s : si.keySet()) {
								// array对应List
								JsonArray js = new JsonArray(si.get(s));
								// object 对应Map，把array分别put进去
								result.put(s, js);
							}
							for (String xzqh : xzqhMap.keySet()) {
								// 发布所有区的各个主题的推送
								String key = "sanitationl_" + xzqh;
								if(result.containsKey(key)){
								JsonArray js = result.getJsonArray(key);
	//
									if (sanMap.get(key) == null) {
										sanMap.put(key, js);
										vertx.eventBus().publish(key, js);
	
									} else if (!sanMap.get(key).equals(js)) {
										sanMap.put(key, js);
										vertx.eventBus().publish(key, js);

									}
								}else{

								}
						}
						if(mi!=null){
							for (String s : mi.keySet()) {
								// array对应List
								JsonArray js = new JsonArray(mi.get(s));
								// object 对应Map，把array分别put进去
								result.put(s, js);
							}
						}
						
						// 推送内容
						}
						for (String xzqh : xzqhMap.keySet()) {
							// 发布所有区的各个主题的推送
							String key = "municipal_" + xzqh;
							if(result.containsKey(key)){
								JsonArray js = result.getJsonArray(key);
								if (munMap.get(key) == null) {
									munMap.put(key, js);
									vertx.eventBus().publish(key, js);

								} else if (!munMap.get(key).equals(js)) {
									munMap.put(key, js);
									vertx.eventBus().publish(key, js);
								}
							}else{
							}
						
						}

						etime = Calendar.getInstance().getTime().getTime() / 1000;
						log.info(tdf.format(Calendar.getInstance().getTime()) + "  首页数据推送完毕    耗时    " + (etime - stime)
								+ "  秒   !");
						vertx.sharedData().getLocalMap("index").put("index", 0);
					}
					if (res.failed()) {
						vertx.sharedData().getLocalMap("index").put("index", 0);
						log.info(tdf.format(Calendar.getInstance().getTime()) + "  首页数据推送失败    耗时    " + (etime - stime)
								+ "  秒   !");
					}
				});
			}
		});
	}
}