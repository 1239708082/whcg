package com.ltsk.whcg.service.impl;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ltsk.whcg.entity.User;
import com.ltsk.whcg.service.AnnotationService;
import com.ltsk.whcg.service.UserService;
import com.ltsk.whcg.utils.ResultUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ltsk.whcg.base.mapper.GasSupplyCenterMapper;
import com.ltsk.whcg.entity.GasSite;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {
    @Autowired
    private GasSupplyCenterMapper gasSupplyCenterMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private AnnotationService annotationService;

    @Test
    public void t1() {
//		List<GasSite> all = gasSupplyCenterMapper.getAll(null);
//		System.out.println(all.size());
//		for (GasSite gasSite : all) {
//			String xy = gasSite.getXy();
//			String gdx=xy.split(",")[0];
//			String gdy=xy.split(",")[1];
//			Integer result = gasSupplyCenterMapper.update(gdx,gdy,gasSite.getGasid()+"");
//		}
        try {
            for (int i = 1; i <= 100; i++) {
                User user = new User();
                user.setXzqh("420100000000");
                user.setUsername("test" + i);
                user.setRoleId("1_role,2_role,3_role,7_role");
                User findByName = userService.findByName(user.getUsername());
                boolean flag = !annotationService.isUser(user.getUsername());
                // //flag为true
                if (findByName == null) {
                    boolean addUser = userService.addUser(user);
                    if (addUser) {
                        annotationService.register(user.getUsername(), "123456");
                        // //协同标注用户同步注册
                        System.out.println(user.getUsername() + "注册成功");
                    } else {
                        System.out.println(user.getUsername() + "注册失败");
                        throw new Exception("事务回滚");
                    }
                } else {
                    System.out.println(user.getUsername() + "已注册");
                }
            }
        } catch (Exception e) {
            System.out.println("报错");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println("test");
    }
}
