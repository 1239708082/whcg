package com.ltsk.whcg.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ltsk.whcg.entity.Role;
import com.ltsk.whcg.entity.RoleIdByName;
import com.ltsk.whcg.postuser.mapper.AnnotationMapper;
import com.ltsk.whcg.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsk.whcg.entity.User;
import com.ltsk.whcg.service.UserService;
import com.ltsk.whcg.zhjg.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AnnotationMapper annotationMapper;

	@Override
	public User findByName(String username) {
		try{
			return userMapper.findByName(username);
		}catch(Exception e){
			e.printStackTrace();
			 log.error("登录信息核实失败！！");
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		try{
			String userId = MakeUUID.getUUID();
			user.setUserid(userId);
			String username = user.getUsername();
			user.setUsername(username);
			String jiami=java.net.URLEncoder.encode(user.getPassword(), "utf-8");
			String password_jiami = Des.toHexString(Des.encrypt(jiami, "WHCGNETA")).toUpperCase();
			user.setPassword(password_jiami);
			if("420100000000".equals(user.getXzqh())){
				user.setType("1");
			}else{
				user.setType("2");
			}
			user.setInsert_time(DateTime.getCurrentTime());
			String roleIds = user.getRoleId(); //角色id
			String[] roles = roleIds.split(",");
			boolean fig = false;
			if(userMapper.addUser(user)>0){
				/*
				* 赋该用户权限,多个权限
				* */
				try {
					for (String roleId:roles
							) {
						String insertUserRoleSql = "INSERT INTO SYS_USER_ROLE (id,userid,roleid) VALUES ('"+ getUuid()+"','"+userId+"','"+roleId+"')";
						int insertRole = userMapper.putUserIsRole(insertUserRoleSql);
					}
					return true;
				}catch (Exception e){
					e.printStackTrace();
					return false;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			log.error("注册用户失败！！");
			 return false;
		}
		return false;
	}

	@Override
	public boolean updatePwd(String newPassword,String username,String update_time) {
		try {
			String jiami=java.net.URLEncoder.encode(newPassword, "utf-8");
			String password_jiami = Des.toHexString(Des.encrypt(jiami, "WHCGNETA")).toUpperCase();
			return userMapper.updatePwd(password_jiami, username,update_time)>0;
		} catch (Exception e) {
			 log.error("修改用户密码失败！！");
		}
		return false;
	}

	@Override
	public List<String> getRoleName(String userid) {
		try {
			return userMapper.getRoleName(userid);
		} catch (Exception e) {
			log.error("获取角色名称失败！！");
			return new ArrayList<>();
		}
	}


	@Override
	public Result getRoleIdbyName() {
		try {
			List<RoleIdByName> roles = userMapper.getRoleIdByName();
			return ResultUtils.success(roles);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("获取角色名称失败！！");
			return ResultUtils.error("获取失败");
		}
	}
	/**
	 * 同步删除两个系统的用户
	 * */
	public Result deleteUser(String username){
		String sql_xtbz = "delete person where username='"+username+"'";
		String sql_zhcg = "delete SYS_USER where username='"+username+"'";
		try {
			boolean zhcg_status = userMapper.deleteUserInfo(sql_zhcg)>0;
			boolean xtbz_status = annotationMapper.deleteUserInfo(sql_xtbz)>0;
			if (zhcg_status && xtbz_status){
				ResultUtils.success("注销完成");
			}else if(!zhcg_status && xtbz_status){
				ResultUtils.success("城管用户注销失败");
			}else if(zhcg_status && !xtbz_status){
				ResultUtils.success("数据采集用户注销失败");
			}else {
				return ResultUtils.error("注销失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			return ResultUtils.error("注销失败");
		}
		return ResultUtils.error("注销失败");
	}

	public String getUuid(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
}
