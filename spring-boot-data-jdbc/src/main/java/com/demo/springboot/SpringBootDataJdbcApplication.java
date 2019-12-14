package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @MapperScan("com.demo.springboot.mapper")
@SpringBootApplication
public class SpringBootDataJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJdbcApplication.class, args);
	}

}
