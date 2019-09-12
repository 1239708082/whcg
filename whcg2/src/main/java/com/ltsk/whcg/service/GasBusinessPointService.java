package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.Gasbusinesspoint;

import java.util.List;

public interface GasBusinessPointService {
    List<Gasbusinesspoint> getAll(String xzqh);
    Integer getSum();
}
