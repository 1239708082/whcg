package com.ltsk.whcg.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ltsk.whcg.entity.ServerStatistics;
import com.ltsk.whcg.zhjg.mapper.ServerMapper;
import com.ltsk.whcg.zhjg.mapper.ServiceManageMapper;

@Component
@Slf4j
public class ServerStatisticsTask {
	
	@Autowired
	private ServiceManageMapper serviceManageMapper;
//  添加推送访问记录
    @Scheduled(fixedRate=60000)
	public void mytask() {
    	ServerStatistics serverStatistics = new ServerStatistics();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());//获取当前时间
    	serverStatistics.setTime(date);
    	serverStatistics.setName("warningData_xzqh");
    	serverStatistics.setUsertype("全市");
    	serverStatistics.setServertype("1");
		serviceManageMapper.addServerStatistics(serverStatistics);
	}

	@Scheduled(fixedRate=24*60*60*1000)
	public void deleteServerStatistics(){
    	try {
			Integer integer = serviceManageMapper.deleteServerStatistics();
			log.info("过时的服务访问记录清理完毕，共清理"+integer+"条记录");
		}catch (Exception e){
    		log.error("过时的服务访问记录清理失败了");
		}
	}
}
