package com.demo.springboot.controller;

import com.demo.springboot.component.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author - Jianghj
 * @since - 2019-11-29 15:08
 * 自定义异常处理切面，用于处理自定义的异常
 */
@ControllerAdvice
public class MyExceptionHandler {

	/**
	 *@author - Jhjing
	 *@since - 2019.11.29 029
	 * 处理自定义异常，返回 JSON 数据
	 */
	@ExceptionHandler(UserNotExistException.class)
	public String handleException(Exception e, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();

		// 需要重新设置请求的错误代码，否则，转发后会一直是 200
		request.setAttribute("javax.servlet.error.status_code",500);

		//自定义封装参数
		map.put("errorCode", 5001);
		map.put("errorMsg", e.getMessage());
		request.setAttribute("exts", map);

		//转发到 BasicErrorController 进行处理
		return "forward:/error";
	}

}
