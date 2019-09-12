package com.ltsk.whcg.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.sun.org.apache.regexp.internal.REUtil;
//时间工具
public class DateTime{
	  public static String getUuid() {
	        return UUID.randomUUID().toString().replaceAll("-", "");
	    }
	// 获得本周一0点时间  
    public static String getTimesWeekmorning() {  
    	SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
    	Calendar c = Calendar.getInstance();
    	int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
    	if (day_of_week == 0)
    	day_of_week = 7;
    	c.add(Calendar.DATE, -day_of_week + 1);
    	return format.format(c.getTime());
    }  

    // 获得本周5点时间  
    public static String getTimesWeeknight() {  
    	  Calendar cal = Calendar.getInstance();  
          cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
          cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);  
      	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
      	String format = sd.format(cal.getTime());
          return format;  
    }  
    // 获得本月第一天0点时间  
    public static String getTimesMonthmorning() {  
        Calendar cal = Calendar.getInstance();  
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));  
    	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
      	String format = sd.format(cal.getTime());
          return format;    
    }  
    
    /**
     * 获取本年的第一天
     * @return String
     * **/
    public static String getYearStart(){
        return new SimpleDateFormat("yyyy").format(new Date())+"-01-01";
    }

public static String getNowTime()
{
	Date date=new Date();
	SimpleDateFormat sd=new SimpleDateFormat("yyyy年MM月dd日 ");
	String currentTime=sd.format(date);
	return currentTime;
}
public static String getTodayTime()
{
	Date date=new Date();
	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
	String currentTime=sd.format(date);
	return currentTime;
}

public static String getTableTime()
{
	Date date=new Date();
	SimpleDateFormat sd=new SimpleDateFormat("yyyy_MM_dd");
	String currentTime=sd.format(date);
	return currentTime;
}


	public static String getCurrentTime()
	{
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String currentTime=sd.format(date);
		return currentTime;
	}

	public static String getYearMonth()
	{
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy_MM");
		String currentTime=sd.format(date);
		return currentTime;
	}
	
	public static String getYear(Date date)
	{
		SimpleDateFormat sd=new SimpleDateFormat("yyyy");
		String year=sd.format(date);
		return year;
	}
	
	public static String getMonth(Date date)
	{
		SimpleDateFormat sd=new SimpleDateFormat("MM");
		String month=sd.format(date);
		return month;
	}
	
	public static String getDay(Date date)
	{
		SimpleDateFormat sd=new SimpleDateFormat("dd");
		String day=sd.format(date);
		return day;
	}
	
	public static String getPast24Time(String dateStirng)
	{
		SimpleDateFormat sd=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date past24date=new Date();
		try
		{
			past24date=new Date(sd.parse(dateStirng).getTime()-24*3600*1000);
		}catch(ParseException ex)
		{
			ex.printStackTrace();
		}
		String past24String=sd.format(past24date);
		return past24String;
	}
	
	public static String getNoonNightTime(String dateStirng)
	{
		String dateNoonString=dateStirng.split(" ")[0]+" 00:00:00";
		return dateNoonString;
	}
	
	/*判断是否包含整月,返回包含的月份格式为2017_01;2017_02*/

	public static String haveMonth(Date startDate,Date endDate){
		String result="";
		Calendar cl=Calendar.getInstance();
		cl.setTime(startDate);
		Calendar e_cl=Calendar.getInstance();
		e_cl.setTime(endDate);
		int e_year=e_cl.get(Calendar.YEAR);
		int e_month=e_cl.get(Calendar.MONTH)+1;
		int temp_year=cl.get(Calendar.YEAR);
		int temp_month=cl.get(Calendar.MONTH)+1;
		if(temp_month==e_month&&temp_year==e_year){
			result=String.valueOf(temp_year)+"_"+((temp_month<10)?"0"+String.valueOf(temp_month):String.valueOf(temp_month));
			return result;
		}
		while(temp_year!=e_year||temp_month!=e_month){
			if(temp_year>=2004){
				result=result+String.valueOf(temp_year)+"_"+((temp_month<10)?"0"+String.valueOf(temp_month):String.valueOf(temp_month))+";";
			}
			cl.add(Calendar.MONTH, 1);
			temp_year=cl.get(Calendar.YEAR);
			temp_month=cl.get(Calendar.MONTH)+1;
		}
		if(temp_year>=2004){
			result=result+String.valueOf(temp_year)+"_"+((temp_month<10)?"0"+String.valueOf(temp_month):String.valueOf(temp_month))+";";
		}
		if(result.contains(";")){
			result=result.substring(0,result.length()-1);
		}
		return result;
	}

	public static String timeStr(int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -num);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String dd = "";
		if (day < 10) {
			dd = "0"+calendar.get(Calendar.DAY_OF_MONTH);
		}else{
			dd = ""+calendar.get(Calendar.DAY_OF_MONTH);
		}
		return calendar.get(Calendar.YEAR) + "_" + (calendar.get(Calendar.MONTH) + 1) + "_" + dd;
	}
	public static String timeStr2(int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -num);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int mm = calendar.get(Calendar.MONTH);
		String month = mm + 1 + "";
		if (mm < 10) {
			month = "0"+month;
		}
		String dd = "";
		if (day < 10) {
			dd = "0"+calendar.get(Calendar.DAY_OF_MONTH);
		}else{
			dd = ""+calendar.get(Calendar.DAY_OF_MONTH);
		}
		return month + "/" + dd;
	}
	
	
	/** 
	    * 获取过去第几天的日期 
	    * 
		*/

	public static String getPastDate(int past) { 
		Calendar calendar = Calendar.getInstance();  
	       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
	       Date today = calendar.getTime();  
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	       String result = format.format(today);   
	       result=result.substring(5);
	       return result;
	}
	public static String[] getPast7Dates() { 
		   Calendar calendar = Calendar.getInstance();  
	       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 7);  
	       Date today = calendar.getTime();  
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	       String start = format.format(today);   
//	       start=result.substring(0,7);
			Calendar calendar1 = Calendar.getInstance();  
			calendar1.set(Calendar.DAY_OF_YEAR, calendar1.get(Calendar.DAY_OF_YEAR));
	       Date end = calendar1.getTime();
	       String endDate = format.format(end);
	       
	       return new String[]{start,endDate};
	}
	//获得上个月同期时间
	public static String time_last(String startTime,String endTime,int mon){
		String startTime_last = null;
		String endTime_last=null;
		if(startTime!=null||endTime!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	        Calendar c = Calendar.getInstance();
	        try {
				c.setTime(format.parse(startTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        c.add(Calendar.MONTH, mon);
			startTime_last=format.format(c.getTime());
			Calendar c1 = Calendar.getInstance();
	        try {
				c1.setTime(format.parse(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        c1.add(Calendar.MONTH, mon);
			endTime_last=format.format(c1.getTime());
		}
		return startTime_last+","+endTime_last;
	}
}