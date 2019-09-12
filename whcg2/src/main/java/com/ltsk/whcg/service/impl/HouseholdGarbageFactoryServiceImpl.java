package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.service.HouseholdGarbageFactoryService;
import com.ltsk.whcg.utils.DateTime;
import com.ltsk.whcg.utils.ExcelUtil;
import com.ltsk.whcg.utils.PositionUtil;
import com.ltsk.whcg.utils.ResultUtils;

import lombok.extern.slf4j.Slf4j;

import com.ltsk.whcg.base.mapper.HouseholdGarbageFactoryMapper;
import com.ltsk.whcg.entity.Czjl;
import com.ltsk.whcg.entity.Czjl_excel;
import com.ltsk.whcg.entity.GarbageNow;
import com.ltsk.whcg.entity.GetCcljWeight;
import com.ltsk.whcg.entity.Gfczzd;
import com.ltsk.whcg.entity.Gps;
import com.ltsk.whcg.entity.LastWeekSHLJ;
import com.ltsk.whcg.listener.XZQHListener;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HouseholdGarbageFactoryServiceImpl implements HouseholdGarbageFactoryService {

	@Autowired
	private HouseholdGarbageFactoryMapper householdGarbageFactoryMapper;

	@Override
	public List<Gfczzd> getAll(String xzqhname) {
		String string_xzqh = XZQHListener.XZQHMap.get(xzqhname);
		try {
			if ("全市".equals(string_xzqh)) {
				string_xzqh = null;
			}
			List<Gfczzd> all = householdGarbageFactoryMapper.getAll(string_xzqh);
			if(all.size()<1)
				return new ArrayList<>();
//			for (Gfczzd gfczzd : all) {
//				Gps xy84 = PositionUtil.gcj_To_Gps84(Double.parseDouble(gfczzd.getLatitudedone()+""), Double.parseDouble(gfczzd.getLongitudedone()+""));
//				gfczzd.setLatitudedone(xy84.getWgLat());
//				gfczzd.setLongitudedone(xy84.getWgLon());
//			}
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("生活垃圾处理厂信息查询失败!!");
			return new ArrayList<>();
		}
	}

	@Override
	public List<List<LastWeekSHLJ>> getLastWeek(String xzqh) {

		List<List<LastWeekSHLJ>> days = new ArrayList<>();
		try {
			if ("420100000000".equals(xzqh) || "420101000000".equals(xzqh)) {

				List<LastWeekSHLJ> day = householdGarbageFactoryMapper.getLastWeek();

				List<String> nameList = new ArrayList<>();
				for (LastWeekSHLJ lastWeekSHLJ : day) {
					lastWeekSHLJ.setDay(lastWeekSHLJ.getDay().substring(5));

					if (!nameList.contains(lastWeekSHLJ.getHandleunit())) {
						nameList.add(lastWeekSHLJ.getHandleunit());
					}
				}

				for (String namelist : nameList) {
					List<LastWeekSHLJ> day1 = new ArrayList<>();
					List<LastWeekSHLJ> result = new ArrayList<>();
					// 将所有厂分开成一个厂一个LIST
					for (LastWeekSHLJ lastWeekSHLJ : day) {
						if (lastWeekSHLJ.getHandleunit().equals(namelist)) {
							day1.add(lastWeekSHLJ);
						}
					}
					// 7天内有的时间没数据,通过日期来判断,没有的补0
					for (int i = 7; i >= 1; i--) {
						LastWeekSHLJ lw = new LastWeekSHLJ();
						lw.setDay(DateTime.getPastDate(i));
						lw.setNetweight("0.00");
						lw.setHandleunit(namelist);
						result.add(lw);
					}
					for (LastWeekSHLJ res : result) {
						for (LastWeekSHLJ old : day1) {
							if (res.getDay().equals(old.getDay())) {
								res.setHandleunit(old.getHandleunit());
								res.setNetweight(old.getNetweight());
							}
						}
					}

					days.add(result);

				}

				return days;
			} else {

				if ("420120000000".equals(xzqh)) {
					xzqh = "东湖风景区";
				} else if ("420119000000".equals(xzqh)) {
					xzqh = "东湖开发区";
				} else if ("420118000000".equals(xzqh)) {
					xzqh = "武汉开发区";
				} else {
					xzqh = XZQHListener.XZQHMap.get(xzqh);
					if (xzqh == null || "".equals(xzqh)) {
						return new ArrayList<>();
					}
				}
				List<LastWeekSHLJ> xzqhDate = householdGarbageFactoryMapper.getLastWeekByXzqh(xzqh);
				
				if(xzqhDate==null||xzqhDate.size()<1){
					return days;
				}
				for (LastWeekSHLJ lastWeekSHLJ : xzqhDate) {
					lastWeekSHLJ.setDay(lastWeekSHLJ.getDay().substring(5));
				}
				// 结果集
				List<LastWeekSHLJ> result = new ArrayList<>();
				// 创建最近7天的空数据,初始化赋值
				for (int i = 7; i >= 1; i--) {
					LastWeekSHLJ lw = new LastWeekSHLJ();
					lw.setDay(DateTime.getPastDate(i));
					lw.setNetweight("0.00");
					lw.setHandleunit(xzqhDate.get(0).getHandleunit());
					result.add(lw);
				}
				// 讲查出来的数据和结果集做比较然后
				for (LastWeekSHLJ res : result) {
					for (LastWeekSHLJ old : xzqhDate) {
						if (res.getDay().equals(old.getDay())) {
							res.setNetweight(old.getNetweight());
						}
					}
				}
				days.add(result);
				return days;
			}
		} catch (Exception e) {
			log.error("生活垃圾处理厂前七日信息查询失败!!");
			e.printStackTrace();
			return new ArrayList<>();

		}

	}

	// 获得生活垃圾处理厂实时信息
	@Override
	public List<GarbageNow> getNowGarbage(String xzqh) {
		try {
			if ("420100000000".equals(xzqh)) {

				List<GarbageNow> list = householdGarbageFactoryMapper.getPresentGarbage();
				return list;
			} else {
				if ("420120000000".equals(xzqh)) {
					xzqh = "东湖风景区";
				} else if ("420119000000".equals(xzqh)) {
					xzqh = "东湖开发区";
				} else if ("420118000000".equals(xzqh)) {
					xzqh = "武汉开发区";
				} else {
					xzqh = XZQHListener.XZQHMap.get(xzqh);
				}

				List<GarbageNow> result = new ArrayList<>();
				List<GarbageNow> list = householdGarbageFactoryMapper.getPerByXzqh(xzqh);
				if (list.size() < 1) {
					return new ArrayList<GarbageNow>();
				}
				for (int i = 0; i < 12; i++) {
					GarbageNow gn = new GarbageNow();
					gn.setXzqh(i * 2 + "~" + (i + 1) * 2);
					gn.setWeigh(0.0 + "");
					result.add(gn);
				}
				for (int j = 0; j < list.size(); j++) {// 8
					list.get(j).setTime(j * 2 + "~" + (j + 1) * 2);
				}
				for (int i = 0; i < result.size(); i++) {// 12
					for (int j = 0; j < list.size(); j++) {// 8
						if (result.get(i).getXzqh().equals(list.get(j).getTime())) {
							result.get(i).setWeigh(list.get(j).getWeigh());
						}
					}
				}
				return result;
			}
		} catch (Exception e) {
			log.error("生活垃圾处理厂实时信息查询失败!!");
			e.printStackTrace();
			return new ArrayList<>();

		}

	}

	// 查询今日垃圾总量
	@Override
	public Object getSumGarbage(String xzqh) {

		xzqh = XZQHListener.XZQHMap.get(xzqh);
		try {
			if ("全市".equals(xzqh)) {
				xzqh = null;
			}
			return householdGarbageFactoryMapper.getSumGarbage(xzqh);
		} catch (Exception e) {
			log.error("生活垃圾处理厂信息查询失败!!");
			return null;
		}
	}

	@Override
	public HSSFWorkbook getCzjl_tj(String startTime,String endTime,String handleunit,String xzqh) {
		try {
			String tltle =title(startTime, endTime, handleunit, xzqh);
			if(handleunit.equals("全部"))
				handleunit=null;
			if(xzqh.equals("全市"))
				xzqh=null;
			//获得上个月同期时间
			String time_last = DateTime.time_last(startTime, endTime, -1);
			String startTime_last=time_last.split(",")[0];
			String endTime_last=time_last.split(",")[1];
			HSSFWorkbook book=new HSSFWorkbook();
			List<Czjl_excel> czjl_tj = householdGarbageFactoryMapper.getCzjl_tj(startTime,endTime,handleunit,xzqh,startTime_last,endTime_last);
			if(czjl_tj.size()<1)
				return new HSSFWorkbook();
			String[] title = {"行政区", "运输单位", "车牌号","车数","垃圾量（吨）","同期上月垃圾量（吨）","同比上月" };
			int mus=100;
			int total=czjl_tj.size();
			int page=total/mus;
			HSSFSheet sheet=null;
			for (int i = 0; i < page+1; i++) {
				HSSFCellStyle hssfCellStyle = book.createCellStyle();
				hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
				HSSFFont font = book.createFont();
				font.setFontName("黑体");
				font.setFontHeightInPoints((short) 12);
				hssfCellStyle.setFont(font);
				sheet=book.createSheet("第"+(i+1)+"页");
				HSSFRow row =sheet.createRow(1);
				HSSFRow row0 = sheet.createRow(0);
				HSSFCell cell = row0.createCell(0);
				cell.setCellValue(tltle);
				cell.setCellStyle(hssfCellStyle);
				
				int headInt=0;
				for (String t : title) {
			        row.createCell(headInt++).setCellValue(t);
			      }
				int num =i*mus;
				int index=0;
				int rowInt=2;
				for (int m = num; m < czjl_tj.size(); m++) {
			        if (index == mus) {// 判断index == mus的时候跳出当前for循环
			          break;
			        }
					row = sheet.createRow(rowInt++); // 创建行
					Czjl_excel map = czjl_tj.get(m);
					row.createCell(0).setCellValue(map.getArea());
					row.createCell(1).setCellValue(map.getTransportunit());
					row.createCell(2).setCellValue(map.getCarno());
					row.createCell(3).setCellValue(map.getCount());
					row.createCell(4).setCellValue(map.getSum());
					row.createCell(5).setCellValue(map.getLastsum()==null?0:map.getLastsum());
					row.createCell(6).setCellValue(map.getResult()==null?0:map.getResult());
					index++;
				}
//				合并单元格
				sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
				ExcelUtil.excel(sheet, 0);
				ExcelUtil.excel(sheet, 1);
			}
			return book;
		} catch (Exception e) {
			log.error("导出垃圾量统计表失败");
			return new HSSFWorkbook();
		}
	}
	
	@Override
	public List<Map<String, Object>> getCzjl_tj_list(String startTime, String endTime, String handleunit,
			String xzqh,Integer pageNo,Integer totalCount) {
		try {
			String time_last = DateTime.time_last(startTime, endTime, -1);
			if("全部".equals(handleunit))
				handleunit=null;
			if("全市".equals(xzqh))
				xzqh=null;
			List<Czjl_excel> czjl_tj = householdGarbageFactoryMapper.getCzjlGroupByPage(startTime, endTime, handleunit, xzqh, time_last.split(",")[0], time_last.split(",")[1],(pageNo-1)*totalCount, pageNo*totalCount+1);
//			System.out.println("总="+czjl_tj);
			if(czjl_tj.size()<1)
				return new ArrayList<>();
			List<Map<String, Object>> list=new ArrayList<>();
			Map<String, List<Czjl_excel>> collect = czjl_tj.stream().collect(Collectors.groupingBy(Czjl_excel::getArea,LinkedHashMap::new,Collectors.toList()));
//			System.out.println("collect="+collect.toString());
			Set<String> string = collect.keySet();
			for (String area : string) {
//				System.out.println("区="+area.toString());
				Map<String, Object> map=new HashMap<>();
				map.put("area", area);
//				Map<String, List<Czjl_excel>> collect1 = collect.get(area).stream().collect(Collectors.groupingBy(Czjl_excel::getTransportunit));
				Map<String, List<Czjl_excel>> collect1 = collect.get(area).stream().collect(Collectors.groupingBy(Czjl_excel::getTransportunit,LinkedHashMap::new,Collectors.toList()));
				Set<String> keySet = collect1.keySet();
				List<Map<String, Object>> list1=new ArrayList<>();
				for (String transportunit : keySet) {
//					System.out.println("单位="+transportunit.toString());
					Map<String, Object> map1=new HashMap<>();
					map1.put("content", collect1.get(transportunit));
					map1.put("transportunit", transportunit);
					map1.put("transportunit_count", collect1.get(transportunit).size());
					list1.add(map1);
				}
				map.put("area_count", collect.get(area).size());
				map.put("value", list1);
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			log.error("获得预览报表数据失败");
			return new ArrayList<>();
		}
	}
	@Override
	public String title(String startTime, String endTime, String handleunit,String xzqh){
		try {
			String time=startTime.split("/")[1]+"月"+startTime.split("/")[2]+"日~"+endTime.split("/")[1]+"月"+endTime.split("/")[2]+"日";
			String title=xzqh+handleunit+startTime.split("/")[0]+"年"+startTime.split("/")[1]+"月垃圾量统计表("+time+")";
			if(xzqh.equals("全市")&&handleunit.equals("全部"))
				title="武汉市"+startTime.split("/")[0]+"年"+startTime.split("/")[1]+"月垃圾量统计表("+time+")";
			if(!xzqh.equals("全市")&&handleunit.equals("全部"))
				title=xzqh+startTime.split("/")[0]+"年"+startTime.split("/")[1]+"月垃圾量统计表("+time+")";
			if(xzqh.equals("全市")&&!handleunit.equals("全部"))
				title="武汉市"+handleunit+startTime.split("/")[0]+"年"+startTime.split("/")[1]+"月垃圾量统计表("+time+")";
			return title;
		} catch (Exception e) {
			log.error("获得垃圾量报表标题失败");
			return "" ;
		}
		
	}

	@Override
	public Integer count(String startTime, String endTime, String handleunit, String xzqh) {
		try {
			if("全部".equals(handleunit))
				handleunit=null;
			if("全市".equals(xzqh))
				xzqh=null;
			Integer count = householdGarbageFactoryMapper.count(startTime, endTime, handleunit, xzqh);
			return count;
		} catch (Exception e) {
			log.error("获得总条数失败");
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<String> area() {
		try {
			Collection<String> values = XZQHListener.XZQHMap.values();
			List<String> result=new ArrayList<>();
			result.add("全市");
			Object[] v=values.toArray();
			for (int i = 0; i < v.length; i++) {
				if(("东湖生态旅游风景区管委会").equals(v[i])){
					result.add("东湖风景区");
					continue;
				}
				if("武汉东湖新技术开发区".equals(v[i])){
					result.add("东湖开发区");
					continue;
				}
				if("武汉经济技术开发区".equals(v[i])){
					result.add("武汉开发区");
					continue;
				}
				result.add(v[i]+"");
			}
			return result;
		} catch (Exception e) {
			log.error("获得行政区划失败！！");
			return new ArrayList<>();
		}
	}

	@Override
	public List<String> handleunit(String startTime, String endTime, String handleunit, String xzqh) {
		try {
			List<String> handleunit_list = householdGarbageFactoryMapper.handleunit();
			handleunit_list.add(0, "全部");
			return handleunit_list;
		} catch (Exception e) {
			log.error("获得处置单位失败！！");
			return new ArrayList<>();
		}
		
	}
}
