package com.ltsk.whcg.controller;


import com.ltsk.whcg.service.GasCompanyService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Gascompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 燃气企业
 */
@RestController
public class GasCompanyController {

    @Autowired
    private GasCompanyService gasCompanyService;

    @RequestMapping("gasCompany")
    public Result getAll(@RequestParam(value="xzqh") String xzqh){
        return ResultUtils.success(gasCompanyService.getAll(xzqh));
    }
}
