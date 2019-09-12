package com.ltsk.whcg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import com.ltsk.whcg.entity.GarbageNow;
import com.ltsk.whcg.service.KitchenWasteFactoryService;
import com.ltsk.whcg.utils.DateTime;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;

/**
 * 垃圾称重记录统计报表 打印报表服务
 * 
 * @author Administrator
 *
 */
@RestController
public class ExportByAreaController {

	@Autowired
	private KitchenWasteFactoryService kwfService;
	@Autowired
	private RedisTemplate redisTemplate;

	public static String  change(String time) {
		time = time.replaceFirst("-", "年").replaceFirst("-", "月")+"日";
		return  time ;
	}
	@ResponseBody
	@RequestMapping(value = "/getAllByArea")
	public Result getAllByArea(@RequestParam(value = "type") String type) {
		String startTime = "";
		String endTime = "";
		String title = "";
		String titleTime = "";
		switch (type) {
		//日报表
		case "1":
			startTime = DateTime.getTodayTime()+" 00:00:00";
			endTime = DateTime.getCurrentTime();
			titleTime = this.change(DateTime.getTodayTime());
			title = "当日("+titleTime+")垃圾分类统计表";
			break;
			//周报表(周一到周五)
		case "2":
			startTime = DateTime.getTimesWeekmorning()+ "00:00:00";
			endTime = DateTime.getCurrentTime();
			titleTime = this.change(DateTime.getTimesWeekmorning())+"~"+this.change(endTime.replaceAll("/", "-").substring(0, 10));
			title = "本周("+titleTime+")各区垃圾分类统计表";
			break;
			//月报表(1号到现在)
		case "3":
			startTime = DateTime.getTimesMonthmorning()+" 00:00:00";
			endTime = DateTime.getCurrentTime();
			titleTime = DateTime.getCurrentTime().substring(5,7);
			title = "本月("+titleTime+"月)各区垃圾分类统计表";
			break;
			//年报表
		case "4":
			startTime = DateTime.getYearStart()+" 00:00:00";
			endTime = DateTime.getCurrentTime();
			titleTime = DateTime.getCurrentTime().substring(0, 4);
			title = "今年("+titleTime+"年)各区垃圾分类统计表";
			break;
		default:
			startTime = DateTime.getTodayTime()+" 00:00:00";
			endTime = DateTime.getCurrentTime();
			break;
		}
		Map<String, Object> res = new HashMap<>();
			res.put("title1", title);
			redisTemplate.opsForValue().set("shlj_area_title",title);

		List<GarbageNow> list = kwfService.getAllByArea(startTime, endTime);
		Double sum = 0.0;
		
		for (GarbageNow garbageNow : list) {
			
			garbageNow.setWetWeigh("0");
			garbageNow.setTotalWeigh(garbageNow.getWeigh());
			sum+=Double.parseDouble(garbageNow.getWeigh());
		}
		redisTemplate.opsForValue().set("shlj_area_augs", startTime + "," + endTime);
		res.put("list", list);
		res.put("sum", sum);
		return ResultUtils.success(res);

	}

	@ResponseBody
	@RequestMapping(value = "/exportByArea")
	public Result printAllByArea(HttpServletRequest request, HttpServletResponse response) {

		String fileName = "AreaDetails_" + System.currentTimeMillis() + ".xls";
		String aug = (String) redisTemplate.opsForValue().get("shlj_area_augs");
		String startTime = aug.split(",")[0];
		String endTime = aug.split(",")[1];
		List<GarbageNow> totalList = kwfService.getAllByArea(startTime, endTime);
		String title = (String) redisTemplate.opsForValue().get("shlj_area_title");

		try {
			fileName = new String(fileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setContentType("application/octet-stream;charset=ISO8859-1");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		// 这里名字取复杂一点,因为可能有会多报表,避免key值重复
		ExportofYJTJByArea(request, response, title, totalList);
		return ResultUtils.success("下载成功");
	}

	public static void ExportofYJTJByArea(HttpServletRequest request, HttpServletResponse response, String title,
			List<GarbageNow> list) {

		try {
			// OutputStream os = new FileOutputStream(filePath);
			OutputStream os = response.getOutputStream();
			HSSFWorkbook wb = new HSSFWorkbook();
			// count ;//总数
			// 总数量除以每页显示条数等于页数
			HSSFSheet sheet = wb.createSheet("HouseholdWasteDetails");
			sheet.setDefaultColumnWidth(15);
			HSSFRow row1 = sheet.createRow(0);
			HSSFCell cell = row1.createCell(0);
			// 加载单元格样式
			// 1.设置字体
			HSSFFont font = wb.createFont();
			font.setFontName("黑体");
			font.setFontHeightInPoints((short) 12);
			// 2.设置居中
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
			cell.setCellStyle(style);
			cell.setCellValue(title);

			row1.setRowStyle(style);
			// HSSFRow row_two = sheet.createRow(1);
			// HSSFCell cell2 = row_two.createCell(0);

			// 生成第一行
			HSSFRow row_title = sheet.createRow(1);
			// 第四步，创建单元格，并设置值表头 设置表头居中

			// 标题
			CellRangeAddress callRangeAddress31 = new CellRangeAddress(0, 0, 0, 4);// 起始行,结束行,起始列,结束列
			// CellRangeAddress callRangeAddress32 = new CellRangeAddress(1, 1,
			// 0, 3);// 起始行,结束行,起始列,结束列

			sheet.addMergedRegion(callRangeAddress31);
			// sheet.addMergedRegion(callRangeAddress32);

			HSSFCell createCell = row_title.createCell(0);
			createCell.setCellValue("序号");
			HSSFCell createCell2 = row_title.createCell(1);
			createCell2.setCellValue("区域名称");
			HSSFCell createCell3 = row_title.createCell(2);
			createCell3.setCellValue("干垃圾(吨)");
			HSSFCell createCell4 = row_title.createCell(3);
			createCell4.setCellValue("湿垃圾(吨)");
			HSSFCell createCell5 = row_title.createCell(4);
			createCell5.setCellValue("合计(吨)");
			createCell.setCellStyle(style);
			createCell2.setCellStyle(style);
			createCell3.setCellStyle(style);
			createCell4.setCellStyle(style);
			createCell5.setCellStyle(style);
			int k = 0;
			Double total = 0.0;
			for (int i = 0; i < list.size(); i++) {
				// com.alibaba.fastjson.JSONObject bean=
				// jsonArray.getJSONObject(i);
				GarbageNow bean = list.get(i);
				total += Double.parseDouble(bean.getWeigh());
				HSSFRow row = sheet.createRow(k + 2);
				HSSFCell createCell6 = row.createCell(0);
				createCell6.setCellValue(i + 1);
				HSSFCell createCell7 = row.createCell(1);
				createCell7.setCellValue(bean.getXzqh());
				HSSFCell createCell8 = row.createCell(2);
				createCell8.setCellValue(bean.getWeigh());
				HSSFCell createCell9 = row.createCell(3);
				createCell9.setCellValue(0.0);
				HSSFCell createCell10 = row.createCell(4);
				createCell10.setCellValue(bean.getWeigh());
				createCell6.setCellStyle(style);
				createCell7.setCellStyle(style);
				createCell8.setCellStyle(style);
				createCell9.setCellStyle(style);
				createCell10.setCellStyle(style);
				k++;
			}
			HSSFRow row = sheet.createRow(k + 2);
			HSSFCell createCell6 = row.createCell(0);
			createCell6.setCellValue("合计");
			HSSFCell createCell7 = row.createCell(2);
			createCell7.setCellValue(total);
			HSSFCell createCell8 = row.createCell(3);
			createCell8.setCellValue(0);
			HSSFCell createCell9 = row.createCell(4);
			createCell9.setCellValue(total);
			CellRangeAddress callRangeAddress33 = new CellRangeAddress(k + 2, k + 2, 0, 1);// 起始行,结束行,起始列,结束列
			createCell6.setCellStyle(style);
			createCell7.setCellStyle(style);
			createCell8.setCellStyle(style);
			createCell9.setCellStyle(style);
			sheet.addMergedRegion(callRangeAddress33);
			response.flushBuffer();
			wb.write(os);
			wb.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			
		}
	}


}
