package com.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author - Jianghj
 * @since - 2019-11-27 14:44
 * 登录控制器
 */
@Controller
@RequestMapping("/user")
public class LoginController {

	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						HttpSession session, HttpServletRequest request) {

		if (!StringUtils.isEmpty(username) && "000000".equals(password)) {
			session.setAttribute("loginUser", username);
			//登录成功，跳转 dashboard 页面
			//但是为了防止表单重复提交，需要进行重定向，重定向时不会再经过视图解析器
			//无法使用 return "redirect:dashboard";
			//无法使用 return "redirect:/templates/dashboard.html"; 因为项目无法直接访问到模版文件，会报404
			//需要在自定义的视图解析器中，配置 main 路径，然后重定向到 main 路径上，跳转 dashboard 页面（或是写个中间的 HandlerMethod 跳转）
			return "redirect:/main";
		}

		request.setAttribute("msg", "用户名或密码错误！");
		return "login";
	}

}
