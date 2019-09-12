package com.ltsk.whcg.listener;

import com.ltsk.whcg.dataPushFactory.SanitationlPushVerticle;
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

import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.Map;
import java.util.Set;

@WebListener
@Slf4j
public class SanitationlPushLstener implements ServletContextListener {

    public static Vertx vertx;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext())
        .getAutowireCapableBeanFactory().autowireBean(this);
        vertx = Vertx.vertx();
        Router router = Router.router(vertx);
        SockJSHandlerOptions options = new SockJSHandlerOptions().setHeartbeatInterval(60000);
        SockJSHandler sockJSHandler = SockJSHandler.create(vertx, options);
        BridgeOptions bridgeOptions = new BridgeOptions();
        Map<String, String> xzqhMap = XZQHListener.XZQHMap;
        Set<String> xzqhs = xzqhMap.keySet();
        for (String xzqh : xzqhs) {
            //可疑工地、消纳点
            bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("suspic_"+xzqh));
            //生活垃圾前七天处理量
            bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("garbageweek_" + xzqh));
            //生活垃圾各区实时进场量
            bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("pregarbage_" + xzqh));
            //餐饮油烟报警
            bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("pretampblack_" + xzqh));
            //餐厨垃圾前七天处理量
            bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("ccljweightweek_" + xzqh));
            //餐厨垃圾各区实时进场量
            bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress("ccljweightnow_" + xzqh));
        }


        router.route("/Eventbus/*").handler(sockJSHandler.bridge(bridgeOptions, event -> {
            PushEnum.judge(log, event.type());
            event.complete(true);
        }));
        router.route().handler(StaticHandler.create());
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(router::accept).listen(18086, res -> {
            if (res.succeeded()) {
                log.info("环卫推送服务成功开始！");
            } else {
                log.info("环卫推送服务开启失败！");
            }
        });
        vertx.deployVerticle(SanitationlPushVerticle.class.getName());
        vertx.sharedData().getLocalMap("sanitationl").put("sanitationl", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
