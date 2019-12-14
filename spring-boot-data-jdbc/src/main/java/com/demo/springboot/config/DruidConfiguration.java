package com.demo.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author - Jianghj
 * @since - 2019-12-10 15:57
 * 手动创建 Druid 数据源，并绑定 Druid 配置属性
 */
@Configuration
public class DruidConfiguration {

	/**
	 * 注入 Druid 数据源
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}

	/**
	 * 配置 Druid 监控
	 * 添加监控的 Servlet ，拦截所有 /druid 请求
	 */
	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
		//设置监控的相关参数
		HashMap<String, String> map = new HashMap<>();
		map.put("loginUsername", "admin");
		map.put("loginPassword", "000000");
		// 当value为空时，默认允许所有ip访问
		map.put("allow", "");
		// 拒绝指定ip访问
		map.put("deny", "192.168.218.27");
		// 将初始化参数，注入目标 Servlet 中
		bean.setInitParameters(map);
		return bean;
	}

	/**
	 * 配置 Druid 监控
	 * 添加监控的 Filter ，拦截所有web 请求
	 */
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new WebStatFilter());
		//初始化参数
		HashMap<String, String> map = new HashMap<>();
		//排除静态资源和后台管理请求
		map.put("exclusions", "*.js,*.css,*.html,/druid/*");
		//设置拦截路径
		registrationBean.setInitParameters(map);
		List<String> list = new ArrayList<>();
		//拦截所有请求
		list.add("/*");
		registrationBean.setUrlPatterns(list);
		return registrationBean;
	}


}
