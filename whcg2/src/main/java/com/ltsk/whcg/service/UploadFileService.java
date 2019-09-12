package com.ltsk.whcg.service;

import org.springframework.web.multipart.MultipartFile;

import com.ltsk.whcg.utils.Result;

public interface UploadFileService {

	Result upload(MultipartFile file) ;

	Result change(MultipartFile file, String type);

}
