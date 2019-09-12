package com.ltsk.whcg.controller;

import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.service.SuspicSiteUnloadService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Suspicsiteunload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 环卫主题初始化
 */
@RestController
public class SanitationlController {

    @Autowired
    private SuspicSiteUnloadService suspicSiteUnloadService;

    @RequestMapping("sanitationl")
    public Result init(@RequestParam("xzqh") String xzqh) {
        Map<String, String> xzqhMap = XZQHListener.XZQHMap;
        String xzqhName = "";
        if (xzqh != null) {
            xzqhName = xzqhMap.get(xzqh);
        }
        if("420100000000".equals(xzqh)){
            xzqhName = "";
        }
        List result = new ArrayList();
        List<Suspicsiteunload> site = suspicSiteUnloadService.getAllByType("1", xzqhName);
        site.forEach(e -> {
            Map<String, Object> obj = new HashMap<>();
            obj.put("eventType", "工地");
            obj.put("warningType", "可疑工地");
            obj.put("id", e.getId());
            obj.put("gdx", e.getGdx());
            obj.put("gdy", e.getGdy());
            obj.put("name", e.getName());
            obj.put("updatetime", e.getUpdatetime() + "");
            result.add(obj);
        });

        List<Suspicsiteunload> unload = suspicSiteUnloadService.getAllByType("2", xzqhName);
        unload.forEach(e -> {
            Map<String, Object> obj = new HashMap<>();
            obj.put("eventType", "消纳点");
            obj.put("warningType", "可疑消纳点");
            obj.put("id", e.getId());
            obj.put("gdx", e.getGdx());
            obj.put("gdy", e.getGdy());
            obj.put("name", e.getName());
            obj.put("updatetime", e.getUpdatetime() + "");
            result.add(obj);
        });
        return ResultUtils.success(result);

    }
}

