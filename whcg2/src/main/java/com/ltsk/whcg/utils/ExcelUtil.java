package com.ltsk.whcg.utils;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static XSSFWorkbook getXSSFWorkbook(String sheetName,String []title,String [][]values, XSSFWorkbook wb){
		 if(wb == null){
	            wb = new XSSFWorkbook();
	        }

	        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
	        XSSFSheet sheet = wb.createSheet(sheetName);

	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
	        XSSFRow row = sheet.createRow(0);

	        // 第四步，创建单元格，并设置值表头 设置表头居中
	        XSSFCellStyle style = wb.createCellStyle();
//	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

	        //声明列对象
	        XSSFCell cell = null;

	        //创建标题
	        for(int i=0;i<title.length;i++){
	            cell = row.createCell(i);
	            cell.setCellValue(title[i]);
	            cell.setCellStyle(style);
	        }
	        

	        //创建内容
	        for(int i=0;i<values.length;i++){
	            row = sheet.createRow(i + 1);
	            for(int j=0;j<values[i].length;j++){
	                //将内容按顺序赋给对应的列对象
	                row.createCell(j).setCellValue(values[i][j]);
	            }
	        }
		return wb;
	}
//	合并同列下相同内容的行 cell：列
	public static void excel(HSSFSheet sheet,int cell){
		int start=1;
		for (int j = 0; j < sheet.getLastRowNum()-1; j++) {
			String value = sheet.getRow(j+1).getCell(cell).getStringCellValue();
			String value2=sheet.getRow(j+2).getCell(cell).getStringCellValue();
			if(!value.equals(value2)){
				if(start!=j+1)
				sheet.addMergedRegion(new CellRangeAddress(start,j+1,cell,cell));
				start=j+2;
			}
			if(value.equals(sheet.getRow(sheet.getLastRowNum()).getCell(cell).getStringCellValue())){
				if(start!=sheet.getLastRowNum())
				sheet.addMergedRegion(new CellRangeAddress(start,sheet.getLastRowNum(),cell,cell));
				break;
			}
		}
	}

}
