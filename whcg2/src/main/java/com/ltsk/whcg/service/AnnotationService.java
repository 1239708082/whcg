package com.ltsk.whcg.service;/**
 * Created by Administrator on 2019-1-4.
 */

import com.ltsk.whcg.postuser.mapper.AnnotationMapper;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @program: whcg
 * @description: 用户注册
 * @author: zt
 * @create: 2019-01-04 16:08
 **/
@Service
public class AnnotationService {
    @Autowired
    private AnnotationMapper annotationMapper;

    public Result register(String username,String password){
        try {
            //person表插入
            // INSERT INTO person (id,username,password,mail,userinfo,forbidden,imagepath,teamid,systemid) VALUES ('asdsadsaqwe','zzz','123','','','0','"http://10.8.99.52:8080/tp/1.jpg"','1','2');
            String uuid = getUuid();
            String personSql = "INSERT INTO person (id,username,password,mail,userinfo,forbidden,imagepath,teamid,systemid) VALUES ('"+uuid+"','"+username+"','"+password+"','','','0','http://10.34.4.123:8080/tp/2.jpg','1','2')";
            annotationMapper.personInsert(personSql);
            //role表插入
            String roleSql = "INSERT INTO userrole (userid,roleid,ipid,teamid) VALUES ('"+uuid+"','7','','1')";
            annotationMapper.roleInsert(roleSql);
            //team表插入
            String teamSql = "INSERT INTO userteam (teamid,userid) VALUES ('1','"+uuid+"')";
            annotationMapper.teamInsert(teamSql);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtils.error("注册失败，换个用户名试试");
        }
        return ResultUtils.success();
    }

    /**
     * @param username 判断用户名是否存在
     * @return true存在  false不存在
     * */
    public boolean isUser(String username){
        String usersql = "select count(1) from person where username='"+username+"'";
        int flag = annotationMapper.isUser(usersql);
        if(flag>0){
            return true;
        }else {
            return false;
        }

    }
    /**
     * 协同标注密码修改
     * */
    public boolean changePassword(String username,String newPassword){
        try {
            String sql = "update person set password='"+newPassword+"' where username='"+username+"'";

            int fig = annotationMapper.changePassword(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    /**
     * @param username 根据用户名查询密码 同步登录
     * @return password
     * */
    public Result getPassword(String username){
        try {
            String usersql = "select password from person where username='"+username+"'";
            String password = annotationMapper.getPassword(usersql);
            if(password==null){
                return ResultUtils.error("用户名不存在");
            }
            return ResultUtils.success(password);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtils.error("权限不足");
        }
    }
    public String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
