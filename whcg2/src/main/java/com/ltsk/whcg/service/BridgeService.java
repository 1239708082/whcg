package com.ltsk.whcg.service;

import com.ltsk.whcg.entity.Bridge;
import com.ltsk.whcg.entity.BridgeVideo;

import java.util.List;

public interface BridgeService {
    List<Bridge> getAll( );

	List<BridgeVideo> getVideo();
}
