package com.demo.springboot.config;

import org.springframework.context.annotation.Configuration;

/**
 * _@Author: jianghj
 * _@Date: 2019.11.16 016 15:41
 * _@Desc: 配置类
 */
@Configuration
//@ImportResource("classpath: bean.xml")
public class CustomConfig {

	/**
	 *  @ ConfigurationProperties + @ Bean
	 * 从全局配置文件中，为 person 组件进行属性注入
	 * 适用于：组件 person 不是自定义的时候
	 */
	//@Bean("person")
	//@ConfigurationProperties(prefix = "person")
	//public Person getPerson() {
	//	return new Person();
	//}
}
