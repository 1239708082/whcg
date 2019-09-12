package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.service.TrashService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

/**
 * 垃圾桶
 */
@RestController
public class TrashCanController {

	 @Autowired
	    private TrashService trashService;
	
	 @RequestMapping("trashCan")
	    public Result getAll(@RequestParam(value="xzqh") String xzqh){
	        return ResultUtils.success(trashService.getNewTrash(xzqh));
	    }
	
}
