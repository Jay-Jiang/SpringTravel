package com.demo.springboot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author - Jianghj
 * @since - 2019-12-16 10:53
 * 自定义实现 ApplicationRunner 接口，在应用启动成功后，完成指定补充功能
 * 注意：需要注入容器中 -- callRunners()
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("HelloApplicationRunner is running" + Arrays.toString(args.getSourceArgs()));
	}
}
