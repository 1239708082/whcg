package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.Gascompany;

import java.util.List;

public interface GasCompanyService {

	List<Gascompany> getAll(String xzqh);
	Integer getSum();
}
