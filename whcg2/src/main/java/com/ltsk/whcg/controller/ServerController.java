package com.ltsk.whcg.controller;

import com.ltsk.whcg.entity.User;
import com.ltsk.whcg.service.ServerService;
import com.ltsk.whcg.utils.Result;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/*
 * zd
 * 服务管理数据资源管理
 *2019/6/25
 * */
@RestController
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping("/serverRegister")
    public Result serverRegister(String serverName, HttpSession session) {
        JSONObject user = (JSONObject) session.getAttribute("user");
        String username = user.get("username").toString();
        return serverService.register(serverName, username);
    }

    @GetMapping("/serverSh")
    public Result serverSh(String state, String id) {
        return serverService.sh(state, id);
    }

    @GetMapping("/findServerSh")
    public Result serverSh() {
        return serverService.findSh();
    }

    //  虚拟化列表
    @GetMapping("/getServerList")
    public Result getServerList(HttpSession session) {
        JSONObject user = (JSONObject) session.getAttribute("user");
        String username = user.get("username").toString();
        return serverService.getServerList(username);
    }

    /*
     * 服务开启或暂停
     * disjunctor:（0：开启，1：暂停）
     * */
    @GetMapping("/isOff")
    public Result isOff(String disjunctor,String serverName) {
        return serverService.isOff(disjunctor,serverName);
    }

    @GetMapping("/getAllServer")
    public Result getAllServer(){
        return serverService.getAllServer();
    }
}
