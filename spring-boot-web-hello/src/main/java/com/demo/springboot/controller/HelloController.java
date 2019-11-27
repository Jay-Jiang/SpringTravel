package com.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author - Jianghj
 * @since - 2019-11-25 11:44
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/say")
	public String sayHello(Model model){
		model.addAttribute("helloMsg","Hello, Springboot , my name is Thymeleaf.");
		return "hello";
	}
}
