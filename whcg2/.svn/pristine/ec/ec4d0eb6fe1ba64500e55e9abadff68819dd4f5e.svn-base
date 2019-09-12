package com.ltsk.whcg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author: Mr Wang
 * @date: 2019/6/12
 * @time: 15:53
 */


@Controller
public class Index2Controller {

    @RequestMapping("/index")
    public String ftlIndex(HttpSession session) {
        Object attribute = session.getAttribute("ssoclientagent.user");
        String username = "";
        if(attribute!=null){
            username = (String) attribute;
        }
        return "redirect:http://10.19.0.11:8888/supervise/#/home?username="+username+"&password=xxxxxx&types=1";
    }

}