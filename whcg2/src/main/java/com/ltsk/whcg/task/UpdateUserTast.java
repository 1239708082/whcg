package com.ltsk.whcg.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ltsk.whcg.entity.User;
import com.ltsk.whcg.service.AnnotationService;
import com.ltsk.whcg.service.UserService;
import com.ltsk.whcg.utils.MD5;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
@Slf4j
public class UpdateUserTast {

	@Autowired
	private UserService userService ;
	@Autowired
	private AnnotationService annotationService;

//	@Scheduled(cron="0 30 6 * * ? ")  每天早上6点更新.
    @Scheduled(fixedRate=60000) //每隔两分钟更新
    public void myTask(){
		// 1.  拿到用户。
    	Long st = System.currentTimeMillis();
		JSONArray cgUser = getCgUser();

		//2。 用户名相同的不管，没有的添加用户。
		List<User> users = new ArrayList<>();
		for (int i = 0; i < cgUser.size(); i++) {
			User user = new User();
			JSONObject ob = cgUser.getJSONObject(i);
			user.setMail(ob.getString("mail"));
			user.setIdCard(ob.getString("idCard"));
			user.setRealName(ob.getString("username"));
			user.setUsername(ob.getString("loginUid"));
			user.setDeptCode(ob.getString("deptcode"));
			user.setHeadShip(ob.getString("headship"));
			user.setPassword(ob.getString("password"));
			user.setMobile(ob.getString("mobile"));
			user.setXzqh("420100000000");
			user.setRoleId("3_role,1_role,2_role,7_role,8_role");
			users.add(user);
		}

		int sum = 0;
		for (User user : users) {
			User findByName = userService.findByName(user.getUsername());

			if (findByName == null) {
	            boolean addUser = userService.addUser(user);
	            if (addUser) {
	                annotationService.register(user.getUsername(), "123456");
	            }
	            sum++;
	        }else{
				// TODO Auto-generated
	        	//用户存在的话 .可以更新密码等..
	        }

		}
		Long et = System.currentTimeMillis();

		log.info("用户更新成功，本次添加用户"+ sum +"人..耗时 :" + (et-st)/1000+"秒");
    }
	public void updateUser(JSONArray cgUser){

		List<User> users = new ArrayList<>();
		for (int i = 0; i < cgUser.size(); i++) {
			User user = new User();
			JSONObject ob = cgUser.getJSONObject(i);
			user.setMail(ob.getString("mail"));
			user.setIdCard(ob.getString("idCard"));
			user.setRealName(ob.getString("username"));
			user.setUsername(ob.getString("loginUid"));
			user.setDeptCode(ob.getString("deptcode"));
			user.setHeadShip(ob.getString("headship"));
			user.setPassword(ob.getString("password"));
			user.setMobile(ob.getString("mobile"));
			user.setXzqh("420100000000");
			user.setRoleId("3_role,1_role,2_role,7_role,8_role");
			users.add(user);
		}


		for (User user : users) {
			User findByName = userService.findByName(user.getUsername());

			if (findByName == null) {
	            boolean addUser = userService.addUser(user);
	            if (addUser) {
	                annotationService.register(user.getUsername(), "123456");
	            }
	        }else{
				// TODO Auto-generated
	        	//用户存在的话 .可以更新密码等..

	        }

		}

	}

	/**
	 * 得到最新的城管用户信息
	 * @return
	 */

	 public JSONArray getCgUser() {
	        CloseableHttpClient closeableHttpClient = null;
	        JSONArray result = new JSONArray();
	        try {
	            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
	            closeableHttpClient = httpClientBuilder.build();
//	            String path = "http://10.34.5.26:8080/idm/jsoninterface/deptmentManager/getAllDept.do";
	            //部门信息
//	            String path = "http://10.19.0.19:8080/idm/jsoninterface/deptmentManager/getAllDept.do";
	            String path = "http://10.19.0.19:8080/idm/jsoninterface/userManager/getAllUser.do";
	            HttpPost httpPost = new HttpPost(path);

	        	String timestamp=String.valueOf(System.currentTimeMillis());
	            httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
	            httpPost.addHeader("token", getToken(timestamp, "user1", "A722C63DB8EC8625AF6CF71CB8C2D939"));
	            httpPost.addHeader("username", "user1");
	            httpPost.addHeader("timestamp",timestamp);
	            JSONObject jsonObject = new JSONObject();
	            jsonObject.put("role", "wiz_supervise_v1");
	            HttpEntity params = new StringEntity(jsonObject.toString(), "UTF-8");
	            httpPost.setEntity(params);
	            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
	                    .setConnectionRequestTimeout(5000).setSocketTimeout(5000).build();
	            httpPost.setConfig(requestConfig);
	            HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
	            HttpEntity entity = httpResponse.getEntity();
	            JSONArray object = new JSONArray();
	            if (entity != null) {
	                String str = EntityUtils.toString(entity);
	                JSONObject fromObject = JSONObject.fromObject(str);
	                if (fromObject != null) {
	                   object = fromObject.getJSONArray("result");
	                   System.out.println(object.size());
	                }
	            }
	            return object;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            try { // 关闭流并释放资源
	                if (closeableHttpClient != null) {
	                    closeableHttpClient.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }


	    private static String getToken(String timeStamp, String jsonUser, String loginCode) {

			String temp = loginCode + jsonUser + timeStamp;
			MD5 md5 = new MD5();
			String token = md5.encrypt(temp);

			return token;
		}


}
