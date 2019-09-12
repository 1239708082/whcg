package com.ltsk.whcg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsk.whcg.service.CreateRoleService;
import com.ltsk.whcg.zhjg.mapper.RoleMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreateRoleServiceImpl implements CreateRoleService{

	@Autowired
    private RoleMapper roleMapper;
	
	//分别在新的角色表，角色资源表，资源表里添加相应的图片路径title等..
	@Override
	public String  createNewRole(String userid,String roleId,String rolename) {
		
		List<String> oldIds= roleMapper.queryRoleId(userid);
		if(oldIds.contains(roleId)){
			return "您已拥有此权限";
		}else{
			Integer result = roleMapper.createNewRole(roleId, userid);
			
			if(result>0){
				
				return "添加权限成功";
			}else{
				return "添加权限失败";
			}
		}
		
		
	}

	
	
	
}
