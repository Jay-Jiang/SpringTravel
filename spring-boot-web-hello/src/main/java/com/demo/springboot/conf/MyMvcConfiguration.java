package com.demo.springboot.conf;

import com.demo.springboot.component.MyHandlerInterceptor;
import com.demo.springboot.component.MyLocaleResolver;
import com.demo.springboot.entities.MyErrorController;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author - Jianghj
 * @since - 2019-11-26 15:49
 * 自定义 SpringMVC 的扩展配置
 */
@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//浏览器发送 /hello 请求来到 success 视图页面
		registry.addViewController("/success").setViewName("success");
	}

	/**
	 * @return 自定义 springmvc 项目首页映射规则
	 * 测试多个自定义 SpringMVC 配置类，会同时生效
	 * @author - Jhjing
	 * @since - 2019.11.26 026
	 */
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				//定义首页面的跳转规则
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				//定义登录成功之后的重定向规则
				registry.addViewController("/main").setViewName("dashboard");
			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				//拦截任意级别的所有路径，但排除首页和登录，进行session 的登录校验
				//springboot 虽然已经做好了静态资源映射，但是自定义拦截器仍然会影响静态资源
				registry.addInterceptor(new MyHandlerInterceptor())
						.addPathPatterns("/user/**", "/curd/**", "/main", "/emps/**", "/emp/**")
						.excludePathPatterns("/user/login");
				//.addPathPatterns("/**");
				//.excludePathPatterns("/","/index","/index.html","/user/login","/webjars/**","/asserts/**");
				//.excludePathPatterns("/","/index","/index.html","/user/login"); //会拦截静态资源，导致页面无法正常加载
			}
		};
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.11.29 029
	 * 注入自定义错误处理，并从容器中获取构造参数
	 */
	@Bean
	public ErrorController myErrorController(ErrorAttributes errorAttributes
			, ServerProperties serverProperties, List<ErrorViewResolver> errorViewResolvers) {

		return new MyErrorController(errorAttributes, serverProperties.getError(), errorViewResolvers);
	}

}
