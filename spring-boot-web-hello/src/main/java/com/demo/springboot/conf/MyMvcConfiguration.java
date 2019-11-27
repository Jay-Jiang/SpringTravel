package com.demo.springboot.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author - Jianghj
 * @since - 2019-11-26 15:49
 * 自定义 SpringMVC 的扩展配置
 */
@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//浏览器发送 /hello 请求来到 success 视图页面
        registry.addViewController("/success").setViewName("success");
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.11.26 026
	 *@return
	 * 自定义 springmvc 项目首页映射规则
	 * 测试多个自定义 SpringMVC 配置会同时生效
	 */
	@Bean
	public WebMvcConfigurer webMvcConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
			}
		};
	}

}
