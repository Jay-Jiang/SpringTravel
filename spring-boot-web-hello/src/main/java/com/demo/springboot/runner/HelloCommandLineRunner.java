package com.demo.springboot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author - Jianghj
 * @since - 2019-12-16 10:57
 * 自定义实现 CommandLineRunner 接口，在应用启动成功后，完成指定补充功能
 * 注意：需要注入容器中 -- callRunners()
 */

@Component
public class HelloCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HelloCommandLineRunner is running" + Arrays.toString(args));
	}
}
