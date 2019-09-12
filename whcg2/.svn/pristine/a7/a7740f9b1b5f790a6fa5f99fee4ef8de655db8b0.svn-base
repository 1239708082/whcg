package com.ltsk.whcg.controller;

import com.ltsk.whcg.entity.Czjl_excel;
import com.ltsk.whcg.listener.XZQHListener;
import com.ltsk.whcg.service.HouseholdGarbageFactoryService;
import com.ltsk.whcg.utils.ExcelUtil;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * 生活垃圾厂
 */
@RestController
public class HouseholdGarbageFactoryController {

	@Autowired
	private HouseholdGarbageFactoryService householdGarbageFactoryService;

	@RequestMapping("/householdGarbageFactory")
	public Result getAll(@RequestParam(value = "xzqh", defaultValue = "420100000000") String xzqh) {
		return ResultUtils.success(householdGarbageFactoryService.getAll(xzqh));
	}

	@RequestMapping("/excel_tj")
	public Result getCzjlExcel_tj(HttpServletResponse response, String startTime, String endTime, String handleunit,
			String xzqh) {
		HSSFWorkbook wb = householdGarbageFactoryService.getCzjl_tj(startTime, endTime, handleunit, xzqh);
		if(wb==null)
			return ResultUtils.error("无数据");
		String fileName="Devices_tj.xls";
		try {
			fileName = new String(fileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setContentType("application/octet-stream;charset=ISO8859-1");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		try {
			response.flushBuffer();
			wb.write(response.getOutputStream());
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResultUtils.success();
	}

	@RequestMapping("/excel_tj_preview")
	public Result getExcel_tj_preview(String startTime, String endTime, String handleunit, String xzqh,Integer pageNo,Integer totalCount) {
		List<Map<String, Object>> czjl_tj_list = householdGarbageFactoryService.getCzjl_tj_list(startTime, endTime,
				handleunit, xzqh,pageNo,totalCount);
		Integer count=householdGarbageFactoryService.count(startTime, endTime, handleunit, xzqh);
		List<String> area = householdGarbageFactoryService.area();
		List<String> handleunit2 = householdGarbageFactoryService.handleunit(startTime, endTime, handleunit, xzqh);
		return ResultUtils.success(czjl_tj_list,householdGarbageFactoryService.title(startTime, endTime, handleunit, xzqh),count,area,handleunit2);
	}
}
