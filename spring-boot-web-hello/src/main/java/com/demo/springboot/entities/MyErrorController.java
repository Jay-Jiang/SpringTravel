package com.demo.springboot.entities;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author - Jianghj
 * @since - 2019-11-29 15:52
 * 自定义实现异常处理，替换 spring boot 默认的异常处理类
 * 注意：自定义异常处理类，生效的前提是：注入到容器中
 */

public class MyErrorController extends BasicErrorController implements ErrorController {


	public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
		super(errorAttributes, errorProperties);
	}

	public MyErrorController(ErrorAttributes errorAttributes
			, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
		super(errorAttributes, errorProperties, errorViewResolvers);
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.11.29 029
	 * 重写获取错误信息的方法，添加自定义的属性
	 * 可以自定义响应的所有参数
	 */
	@Override
	protected Map<String, Object> getErrorAttributes(HttpServletRequest request
			, boolean includeStackTrace) {

		Map<String, Object> map = super.getErrorAttributes(request, includeStackTrace);

		//从 request 域中，获取异常处理时封装的参数
		Map<String, Object> exts = (Map<String, Object>)request.getAttribute("exts");
		map.put("exts", exts);

		// 自定义错误信息
		map.put("company", "springboot 2.2.3");
		map.put("author", "Jhjing");
		map.put("from", "MyErrorController");
		return map;
	}
}
