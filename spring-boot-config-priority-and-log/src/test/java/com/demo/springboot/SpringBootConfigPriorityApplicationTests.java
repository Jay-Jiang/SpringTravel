package com.demo.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootConfigPriorityApplicationTests {
	//获取日志记录对象
	final private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {
		String msg = "哈哥锥子";
		logger.info("哈利个哈-{}", msg);
		logger.warn("哈利个哈哈-{}", msg);
		logger.error("哈利个哈哈哈-{}", msg);
	}

}
