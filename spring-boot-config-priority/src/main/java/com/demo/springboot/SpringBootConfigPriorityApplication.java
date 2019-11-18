package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *_@功能描述:  测试SpringBoot 中全局配置文件，加载的优先级
 *_@author: jhjing
 *_@date: 2019.11.18 018
 * _@param:null
 *_@return:
 */
@SpringBootApplication
public class SpringBootConfigPriorityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigPriorityApplication.class, args);
	}

}
