package com.ltsk.whcg.listener;

import com.ltsk.whcg.dataPushFactory.LawPushVerticle;
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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
@Slf4j
public class LawPushLstener implements ServletContextListener {

    public static Vertx vertx;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        vertx = Vertx.vertx();
        Router router = Router.router(vertx);
        SockJSHandlerOptions options = new SockJSHandlerOptions().setHeartbeatInterval(60000);
        SockJSHandler sockJSHandler = SockJSHandler.create(vertx, options);
        BridgeOptions bridgeOptions = new BridgeOptions();
        bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("law"));
        router.route("/Eventbus/*").handler(sockJSHandler.bridge(bridgeOptions, event -> {
            PushEnum.judge(log, event.type());
            event.complete(true);
        }));
        router.route().handler(StaticHandler.create());
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(router::accept).listen(18084, res -> {
            if (res.succeeded()) {
                log.info("执法推送服务成功开始！");
            } else {
                log.info("执法推送服务开启失败！");
            }
        });
        vertx.deployVerticle(LawPushVerticle.class.getName());
        vertx.sharedData().getLocalMap("law").put("law", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
