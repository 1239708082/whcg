package com.ltsk.whcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltsk.whcg.service.CreateRoleService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

/**
 * 超级管理员
 * 创建新的角色
 * @author Administrator
 *
 */
@RestController
public class CreateRoleController {

	 @Autowired
	    private CreateRoleService createRoleService;

	    @RequestMapping("/createRole")
	    public Result getAll(@RequestParam(value="userid")String userid,@RequestParam(value="type")String type,@RequestParam(value="roleId")String roleId)
	    {
	    	if("0".equals(type)){
	    		return ResultUtils.success(createRoleService.createNewRole(userid,roleId,type));
	    	}else{
	    		return ResultUtils.error("对不起，您权限不够，无法添加角色..");
	    	}
	        
	    }
	
	
	
}
