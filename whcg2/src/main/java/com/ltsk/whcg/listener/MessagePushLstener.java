package com.ltsk.whcg.listener;

import com.ltsk.whcg.dataPushFactory.IndexPushVerticle;
import com.ltsk.whcg.utils.PushEnum;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class MessagePushLstener implements ServletContextListener {

	public static Vertx vertx;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		vertx = Vertx.vertx();
		Router router = Router.router(vertx);
		SockJSHandlerOptions options = new SockJSHandlerOptions().setHeartbeatInterval(60000);
		SockJSHandler sockJSHandler = SockJSHandler.create(vertx, options);
		BridgeOptions bridgeOptions = new BridgeOptions();
		Map<String, String> xzqhMap = XZQHListener.XZQHMap;
		Set<String> xzqhs = xzqhMap.keySet();
		for (String xzqh : xzqhs) {
			bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("sanitationl_" + xzqh));
			bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("municipal_" + xzqh));
//			bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("law_" + xzqh));
		}
		router.route("/Eventbus/*").handler(sockJSHandler.bridge(bridgeOptions, event -> {
			PushEnum.judge(log, event.type());
			event.complete(true);
		}));
		router.route().handler(StaticHandler.create());
		HttpServer server = vertx.createHttpServer();
		server.requestHandler(router::accept).listen(18087, res -> {
			if (res.succeeded()) {
				log.info("主页推送服务成功开始！");
			} else {
				log.info("主页推送服务开启失败！");
			}
		});
		vertx.deployVerticle(IndexPushVerticle.class.getName());
		vertx.sharedData().getLocalMap("index").put("index", 0);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
