package com.demo.springboot.conf;

import com.demo.springboot.filter.MyFilter;
import com.demo.springboot.listener.MyListener;
import com.demo.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

/**
 * @author - Jianghj
 * @since - 2019-12-02 13:34
 * Servlet 容器相关的自定义配置
 */
@Configuration
public class MyServerConfiguration {

	/**
	 *@author - Jhjing
	 *@since - 2019.12.2 002
	 * 注入自定义的 HttpServlet 组件
	 */
	@Bean
	public ServletRegistrationBean<HttpServlet> servletRegistrationBean(){
		return new ServletRegistrationBean<HttpServlet>(new MyServlet(), "/servlet");
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.12.2 002
	 * 注入自定义的 Servlet Filter 组件
	 */
	@Bean
	public FilterRegistrationBean<Filter> filterRegistrationBean(){
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new MyFilter());
		ArrayList<String> list = new ArrayList<>();
		list.add("/servlet");
		filterRegistrationBean.setUrlPatterns(list);
		return filterRegistrationBean;
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.12.2 002
	 * 注入自定义的 Servlet Listener 组件
	 */
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> servletListenerRegistrationBean(){
		return new ServletListenerRegistrationBean<ServletContextListener>(new MyListener());
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.12.2 002
	 * 编程实现：自定义 Servlet 容器配置
	 */
	// @Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
		return factory -> factory.setPort(8080);
	}


}
