package com.ltsk.whcg.controller;/**
 * Created by Administrator on 2019-1-4.
 */

import com.ltsk.whcg.entity.User;
import com.ltsk.whcg.postuser.mapper.AnnotationMapper;
import com.ltsk.whcg.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: whcg
 * @description: 测试用
 * @author: zt
 * @create: 2019-01-04 15:22
 **/
@RestController
public class MyControllerTest {
    @Autowired
    private AnnotationService annotationService;

    @RequestMapping("test")
    public Object test1(String username,String password){
        boolean sign = annotationService.changePassword(username,password);
        return  sign;
    }
}
