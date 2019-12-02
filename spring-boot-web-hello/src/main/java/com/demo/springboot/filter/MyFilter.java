package com.demo.springboot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author - Jianghj
 * @since - 2019-12-02 14:58
 * 自定义 Java Servlet Filter
 */
@Slf4j
public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		log.info("==== this is my filter ====");
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {

	}
}
