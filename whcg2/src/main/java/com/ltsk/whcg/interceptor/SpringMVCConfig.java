package com.ltsk.whcg.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * springboot 配置springmvc
 *
 * @author www
 */
@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

//	@Autowired
//	private MyInterceptor myInterceptor;

    @Autowired
    private ServiceRecordInterceptor ServiceRecordInterceptor;
    @Autowired
    private ServerOffInterceptor serveroffInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//		registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/toLogin","/checkLogin","/error","/getAllTablename","/getDataByTablename","/changeXy");
        registry.addInterceptor(ServiceRecordInterceptor).addPathPatterns("/**").excludePathPatterns("/toLogin", "/checkLogin", "/error");
        registry.addInterceptor(serveroffInterceptor).addPathPatterns("/**").excludePathPatterns("/toLogin", "/checkLogin", "/error");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*registry.addResourceHandler("/Style/**").addResourceLocations("/Style/");
		registry.addResourceHandler("/Images/**").addResourceLocations("/Images/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");*/
    }
}
