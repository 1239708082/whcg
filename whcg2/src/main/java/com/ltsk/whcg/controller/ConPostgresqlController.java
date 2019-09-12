package com.ltsk.whcg.controller;

import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr Wang
 * @date: 2019/6/29
 * @time: 11:42
 */

@RestController
public class ConPostgresqlController {

    @RequestMapping("/getAllTablename")
    public Result getAllTablename(String url,String username,String password,String name){
        Connection SCIdbconn = null;
        try {
            Class.forName("org.postgresql.Driver");
            url = "jdbc:postgresql://"+url;
            SCIdbconn = DriverManager.getConnection(url+"/"+name, username, password);
            System.out.println(SCIdbconn);
            String sql = "SELECT   tablename   FROM   pg_tables  WHERE   tablename   NOT   LIKE   'pg%'  AND tablename NOT LIKE 'sql_%' ORDER   BY   tablename";
            PreparedStatement st = SCIdbconn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            List<String> tablename = new ArrayList<>();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    tablename.add(rs.getString(i));
                }
            }
            rs.close();
            st.close();
            SCIdbconn.close();
        return ResultUtils.success(tablename);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error("连接失败！");
        } finally {
            try {
                SCIdbconn.close();
            } catch (Exception e) {

            }

        }
    }
    @RequestMapping("/getDataByTablename")
    public Result getDataByTablename(String url,String username,String password,String name,String tableName){
        Connection SCIdbconn = null;
        PreparedStatement st = null;
        PreparedStatement stData = null;
        ResultSet rs = null;
        ResultSet rsData = null;
        try {
            Class.forName("org.postgresql.Driver");
            SCIdbconn = DriverManager.getConnection(url+"/"+name, username, password);
            String sql = "SELECT a.attname as name FROM pg_class as c,pg_attribute as a where c.relname = '"+tableName.toLowerCase()+"' and a.attrelid = c.oid and a.attnum>0";
            st = SCIdbconn.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            List<String> title = new ArrayList  <>();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    title.add(rs.getString(i));
                }
            }
            String sqlData = "SELECT * FROM "+tableName.toLowerCase();
            stData = SCIdbconn.prepareStatement(sqlData);
            try{
            rsData = stData.executeQuery();
            }catch(Exception e){
                e.printStackTrace();
                return ResultUtils.success(new ArrayList<>());
            }
            ResultSetMetaData rsmdData = rsData.getMetaData();
            int column = rsmdData.getColumnCount();
            List<List<String>> data = new ArrayList<>();
            data.add(title);
            while (rsData.next()) {
                List<String> objects = new ArrayList<>();
                for (int i = 1; i <= column; i++) {
                    String cname = rsData.getString(i);
                    objects.add(cname==null?"":cname);
                }
                data.add(objects);
            }
            return ResultUtils.success(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error("连接失败！");
        } finally {
            try {
                rs.close();
                st.close();
                rsData.close();
                stData.close();
                SCIdbconn.close();
            } catch (Exception e) {
            }
        }
    }
}