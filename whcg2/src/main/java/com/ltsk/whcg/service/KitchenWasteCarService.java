package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.Ccsyc;

import java.util.List;

public interface KitchenWasteCarService {

    List<Ccsyc> getAll(String xzqh);

    Integer get_sum(String xzqh);
}
