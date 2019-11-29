package com.demo.springboot.entities;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author - Jianghj
 * @since - 2019-11-29 16:34
 * 自定义错误属性：重写获取错误属性信息的方法，实现自定义错误信息
 * 注意：自定义错误属性需要注入到容器中，才会生效，会替换 springboot 默认的错误属性类
 */
// @Component
public class MyErrorAttributes extends DefaultErrorAttributes {

	/**
	 *@author - Jhjing
	 *@since - 2019.11.29
	 * 重写获取错误信息的方法，添加自定义的属性
	 * 可以自定义响应的所有参数
	 */
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);

		//从 request 域中，获取异常处理时封装的参数
		Map<String, Object> exts = (Map<String, Object>)webRequest.getAttribute("exts", 0);
		map.put("exts", exts);

		// 自定义错误信息
		map.put("company", "springboot 2.2.3");
		map.put("author", "Jhjing");
		map.put("from", "MyErrorAttributes");
		return map;
	}
}
