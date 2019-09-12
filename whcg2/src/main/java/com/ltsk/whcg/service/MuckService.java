package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.Muck;

import java.util.List;

public interface MuckService {

    List<Muck> getAll(String xzqh);
    Integer get_sum(String xzqh);
    List<Double []> getTrace(String vehicleno);
}
