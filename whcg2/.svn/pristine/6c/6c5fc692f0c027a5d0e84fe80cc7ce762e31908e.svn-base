package com.ltsk.whcg.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ltsk.whcg.service.UploadFileService;
import com.ltsk.whcg.utils.Result;


@RestController
public class UploadFileController {
	
	@Autowired
	private UploadFileService uploadService;
	
	/**
	 * 上传文件 转换存储
	 * @param file
	 * @return
	 */
    @RequestMapping("/uploadFile")
    public Result uploadFile(@RequestParam("fileName") MultipartFile file){

    	
    	
        return uploadService.upload(file);
    }
    
    /**
     * 84转高德。84转百度  84转墨卡托。。
     * 
     * EXCEL上传批量转换
     */
    @RequestMapping("/changeXy")
    public Result changeXy(@RequestParam("fileName") MultipartFile file,@RequestParam("type") String type){

        return uploadService.change(file,type);
    }
}
