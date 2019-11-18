package com.demo.springboot.test;

import com.demo.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * _@Author: jianghj
 * _@Date: 2019.11.16 016 10:46
 * _@Desc: springboot 读取配置信息测试
 *
 *  @SpringBootTest： 是启动整个项目，进行单元测试
 *  @ContextConfiguration: 用于拆分单元测试，避免加载完整个项目，才能运行单个测试。
 *   	-classes：指定 @Test 测试需要的依赖环境即可。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = {Person.class, Dog.class})
public class ConfigTest {

	@Autowired
	Person person;

	@Test
	public void testPersonConfig() {
		System.out.println(person.toString());
	}

}
