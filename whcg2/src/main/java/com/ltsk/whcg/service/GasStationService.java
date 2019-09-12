package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.Gasstation;

import java.util.List;

public interface GasStationService {

    List<Gasstation> getAll(String type, String xzqh);
    Integer getSum(String type);

}
