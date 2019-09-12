package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.SuspicSiteUnloadService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Suspicsiteunload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 1为可疑工地、2为消纳点
 */
@RestController
public class SuspicSiteUnloadController {

    @Autowired
    private SuspicSiteUnloadService suspicSiteUnloadService;

    @RequestMapping("/suspicsiteunload/{type}/{xzqh}")
    public Result getByType(@PathVariable(value = "type") String type, @PathVariable(value = "xzqh") String xzqh){
        return ResultUtils.success(suspicSiteUnloadService.getAllByType(type, xzqh));
    }
}
