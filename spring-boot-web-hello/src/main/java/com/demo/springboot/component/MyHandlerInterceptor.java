package com.demo.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author - Jianghj
 * @since - 2019-11-27 15:37
 * 自定义拦截器：进行登录校验
 */
public class MyHandlerInterceptor implements HandlerInterceptor {

	final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 进行登录校验
	 *
	 * @param request  请求
	 * @param response 响应
	 * @param handler  处理器
	 * @author - Jhjing
	 * @since - 2019.11.27 027
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("loginUser");
		if (user != null) {
			logger.info("[success]--访问路径是：[{}]", request.getRequestURI());
			return true;
		}
		//跳转到首页
		request.setAttribute("msg", "没有操作权限，请先登录！");
		request.getRequestDispatcher("/index").forward(request, response);
		//重定向到首页，没办法携带参数
		//response.sendRedirect(request.getContextPath() + "/index");
		logger.info("[fail]--访问路径是：[{}]", request.getRequestURI());
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
