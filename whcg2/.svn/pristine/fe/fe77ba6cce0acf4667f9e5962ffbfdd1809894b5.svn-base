package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.KitchenWasteFactoryService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Ccljc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 餐厨垃圾厂
 */
@RestController
public class KitchenWasteFactoryController {

    @Autowired
    private KitchenWasteFactoryService kitchenWasteFactoryService;

    @RequestMapping("/kitchenWasteFactory")
    public Result getAll(){
        return ResultUtils.success(kitchenWasteFactoryService.getAll());

    }
}
