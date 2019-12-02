package com.demo.springboot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author - Jianghj
 * @since - 2019-12-02 14:45
 * 自定义 Servlet
 */
@Slf4j
public class MyServlet extends HttpServlet {

	//处理 get 请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	//处理 post 请求
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("=== this is my servlet ===");
		// 可以从 HttpServletRequest 获取请求信息，包括请求头、cookie 等
		// 可以利用 HttpServletResponse 设置响应信息，包括直接响应一个页面（需要手动拼串）
		resp.getWriter().print("hello world...");
	}
}
