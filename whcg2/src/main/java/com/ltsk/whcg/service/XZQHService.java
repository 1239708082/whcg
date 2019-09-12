package com.ltsk.whcg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ltsk.whcg.entity.XZQH;

public interface XZQHService {
	public List<XZQH> getAll();
	public String getXzqhName(String no);
}
