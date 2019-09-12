package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.KitchenWasteCarService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.Ccsyc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 餐厨垃圾车
 */
@RestController
public class KitchenWasteCarController {

    @Autowired
    private KitchenWasteCarService kitchenWasteCarService;

    @RequestMapping("/kitchenWasteCar")
    public Result getAll(@RequestParam(value="xzqh",defaultValue="420100000000")String xzqh){
        return ResultUtils.success( kitchenWasteCarService.getAll(xzqh),null,kitchenWasteCarService.get_sum(xzqh));
    }
}
