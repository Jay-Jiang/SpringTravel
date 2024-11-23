package com.demo.springboot.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author - Jianghj
 * @since - 2019-12-16 11:06
 * 自定义实现 SpringApplicationRunListener 接口，干涉进应用启动的各个阶段
 */
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

	/**
	 * 必须拥有的构造方法，否则反射实例化会失败- java.lang.NoSuchMethodException
	 */
	public HelloSpringApplicationRunListener(SpringApplication application, String[] args) { }

	@Override
	public void starting(ConfigurableBootstrapContext bootstrapContext) {
		System.out.println("应用正在启动 starting...");
	}

	@Override
	public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
		System.out.println("准备应用配置环境 environmentPrepared...");
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("应用准备完成 contextPrepared...");
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		System.out.println("应用初始化完成 contextLoaded...");
	}

	@Override
	public void started(ConfigurableApplicationContext context) {
		System.out.println("应用启动完成 started...");
	}

	@Override
	public void running(ConfigurableApplicationContext context) {
		System.out.println("应用正在运行 running...");
	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		System.out.println("应用启动失败 failed...");
	}
}
