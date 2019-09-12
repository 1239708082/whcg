package com.ltsk.whcg.utils;

import io.vertx.ext.web.handler.sockjs.BridgeEventType;
import org.slf4j.Logger;

public class PushEnum {
    public static void judge(Logger log,BridgeEventType type){
        switch (type) {
            case SOCKET_CREATED:
                log.info("a socket is created");
                break;
            case SOCKET_CLOSED:
                log.info("a socket is closed");
                break;
            case PUBLISH:
                log.info("a message is delivered from the client to the server");
                break;
            case SEND:
                log.info("a message is sent from the client to the server");
                break;
            case RECEIVE:
                log.info("a message is delivered from the server to the client");
                break;
            case REGISTER:
                log.info("a client registers a handler");
                break;
            case UNREGISTER:
                log.info("a client unregisters a handler");
                break;
            default:
                break;
        }
    }
}
