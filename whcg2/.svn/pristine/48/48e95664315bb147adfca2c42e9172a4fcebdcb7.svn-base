package com.ltsk.whcg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsk.whcg.entity.Menu;
import com.ltsk.whcg.service.TreeService;
import com.ltsk.whcg.zhjg.mapper.TreeMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TreeServiceImpl implements TreeService{
	@Autowired
	private TreeMapper treeMapper;
	
	@Override
	public List<String> getRoleName() {
		return treeMapper.getRoleName();
	}

	@Override
	public List<Menu> getMenuName() {
		return treeMapper.getMenuName();
	}
	
}
