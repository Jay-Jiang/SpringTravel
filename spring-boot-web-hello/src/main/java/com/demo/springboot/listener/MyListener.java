package com.demo.springboot.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author - Jianghj
 * @since - 2019-12-02 15:04
 * 自定义 Servlet Listener
 */
@Slf4j
public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("==== this is my listener ====");
		log.info("==== application started  ====");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("==== application stopped  ====");
	}
}
