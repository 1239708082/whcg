package com.ltsk.whcg.base.mapper;

import com.ltsk.whcg.entity.Bridge;
import com.ltsk.whcg.entity.BridgeVideo;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BridgeMapper {

    @Select("SELECT * from bridge")
    
	
    public List<Bridge> getAll();
    
    @Select("SELECT gdxy,bridgeid,bridgename,ip from bridgevedio where gdxy is not null")
    
	
    public List<BridgeVideo> getVideo();

}

