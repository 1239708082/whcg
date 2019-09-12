package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.SiteService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 工地
 */
@RestController
public class SiteController {

    @Autowired
    private SiteService siteService;

    @RequestMapping("/site")
    public Result getAll(){
        return ResultUtils.success(siteService.getAll());
    }
}
