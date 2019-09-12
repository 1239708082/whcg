package com.ltsk.whcg.controller;

import com.ltsk.whcg.service.BridgeDefectRecordService;
import com.ltsk.whcg.service.WarningListService;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.entity.BridgeDefectRecord;
import com.ltsk.whcg.entity.WarningList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 市政主题初始化
 */
@RestController
public class MunicipalController {

    @Autowired
    private BridgeDefectRecordService bridgeDefectRecordService;

    @Autowired
    private WarningListService warningListService;

    @RequestMapping("municipal")
    public Result init() {
            List result = new ArrayList();
            List<BridgeDefectRecord> site = bridgeDefectRecordService.getAll();
            site.forEach(e -> {
                Map<String,Object> obj = new HashMap<>();
                obj.put("barriertype", "3");
                obj.put("eventType", "桥梁");
                obj.put("warningType", "桥梁损坏");
                obj.put("id", e.getKeyid());
                obj.put("bridgeName", e.getBridgename());
                obj.put("departmentName", e.getDepartmentname());
                obj.put("path", e.getPath());
                obj.put("name", e.getRecorddescription());
                obj.put("updatetime", e.getCreatedtime() + "");
                result.add(obj);
            });

            List<WarningList> unload = warningListService.getAll();
            unload.forEach(e -> {
                Map<String, Object> obj = new HashMap<>();
                obj.put("barriertype", "4");
                obj.put("eventType", "燃气");
                obj.put("warningType", "设备异常");
                obj.put("id", e.getW_id());
                obj.put("updatetime", e.getOccurdate() + "");
                obj.put("recoveryDate", e.getRecoverydate() + "");
                obj.put("name",
                        e.getWarningcontent());
                obj.put("areaname", e.getAreaname());
                obj.put("departname", e.getDepartname());
                result.add(obj);
            });
            return ResultUtils.success(result);

    }
}

