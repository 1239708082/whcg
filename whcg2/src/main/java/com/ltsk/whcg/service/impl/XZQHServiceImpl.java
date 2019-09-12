package com.ltsk.whcg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsk.whcg.base.mapper.XZQHMapper;
import com.ltsk.whcg.entity.XZQH;
import com.ltsk.whcg.service.XZQHService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class XZQHServiceImpl implements XZQHService {
	@Autowired
	private XZQHMapper xzqhMapper;

	@Override
	public List<XZQH> getAll() {
		try {
			return xzqhMapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("行政区划查询失败！！");
			return new ArrayList<>();
		}
	}

	@Override
	public String getXzqhName(String no) {
		try {
			return xzqhMapper.getXzqhName(no);
		} catch (Exception e) {
			log.error("根据行政区域编号查询行政区划失败");
			return null;
		}
	}

}
