package com.demo.springboot.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author - Jianghj
 * @since - 2019-12-16 11:08
 * 自定义实现 ApplicationContextInitializer 接口，实现IOC 初始化定制
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("HelloApplicationContextInitializer initialize...");
	}
}
