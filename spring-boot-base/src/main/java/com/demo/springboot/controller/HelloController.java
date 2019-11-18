package com.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * _@Author: jianghj
 * _@Date: 2019.11.15 015 14:41
 * _@Desc: hello world
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(value = "/say", method = RequestMethod.GET)
	public String sayHello(){
		return "<h1>Hello Spring Boot</h1>";
	}

}
