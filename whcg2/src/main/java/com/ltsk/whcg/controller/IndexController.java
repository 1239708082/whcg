package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.IndexService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.listener.IndexListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页数据初始化
 */
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("indexSanitationl")
    //环卫
    public Result indexSanitationl(@RequestParam(value="xzqh")String xzqh){
        if(IndexListener.INDEX_S == null|| IndexListener.INDEX_S.size()==0){
            return ResultUtils.success(indexService.getSanitationl(xzqh));
        }
        return ResultUtils.success( IndexListener.INDEX_S.get("sanitationl_"+xzqh));
    }
    
    @RequestMapping("indexMunicipal")
    //市政
    public Result indexMunicipal(@RequestParam(value="xzqh")String xzqh){
        if(IndexListener.INDEX_M == null|| IndexListener.INDEX_M.size()==0){
            return ResultUtils.success(indexService.getMunicipal(xzqh));
        }
        return ResultUtils.success( IndexListener.INDEX_M.get("municipal_"+xzqh));
    }
    
//    @RequestMapping("indexLaw")
//    //执法
//    public Result indexLaw(@RequestParam(value="xzqh")String xzqh){
//        if(IndexListener.INDEX_L == null|| IndexListener.INDEX_L.size()==0){
//            return ResultUtils.success(indexService.getLaw(xzqh));
//        }
//        return ResultUtils.success( IndexListener.INDEX_L.get("law_"+xzqh));
//    }
}
