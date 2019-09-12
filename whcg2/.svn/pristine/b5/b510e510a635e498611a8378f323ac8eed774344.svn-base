package com.ltsk.whcg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.entity.Server;
import com.ltsk.whcg.service.ServiceManagementService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.zhjg.mapper.ServiceManageMapper;

import net.sf.json.JSONObject;

@RestController
public class ServiceManagementController {
    @Autowired
    private ServiceManageMapper mapper;
    @Autowired
    private ServiceManagementService serviceManagementService;
    @Autowired
    private StringRedisTemplate template;

    //	查询当前用户未注册服务信息
    @RequestMapping("servicename")
    public Result listServiceName(HttpSession session) {
        String user = template.opsForValue().get(session.getId());
        JSONObject fromObject = JSONObject.fromObject(user);
        String username = (String) fromObject.get("username");
        List<Server> list = mapper.getserverName(username);
        for (int i = 0; i < list.size(); i++) {
            Server server = list.get(i);
            server.setId(i + 1 + "");
            list.set(i, server);
        }
        Result success = ResultUtils.success(list);
        return success;
    }


    //  查询所有服务使用频次统计情况(时间段)
    @RequestMapping("servicestatistics")
    public Result listUseServiceStatistics() {
        List<String> serverCountSelrvice = serviceManagementService.getServerCountSelrvice();
        Result success = ResultUtils.success(serverCountSelrvice);
        return success;
    }

    //	服务类型
    @RequestMapping("servicestatistics1")
    public Result listUseServiceStatistics1() {
        List<Map<String, Integer>> list = serviceManagementService.getServerCountByServerType();
        Result success = ResultUtils.success(list);
        return success;
    }

    //	行政区划
    @RequestMapping("servicestatistics2")
    public Result listUseServiceStatistics2() {
        List<Map<String, Integer>> list = serviceManagementService.getServerCountByUserType();
        Result success = ResultUtils.success(list);
        return success;
    }
}
