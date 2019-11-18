package com.demo.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * _@Author: jianghj
 * _@Date: 2019.11.16 016 10:31
 * _@Desc: 测试配置文件属性注入
 * @ConfigurationProperties: 告诉 SpringBoot 将本类中的所有属性，和全局配置文件中相关的配置属性进行绑定。
 *  	prefix = “person” ：指明使用全局配置文件中“person”下面的所有属性，与此类的属性进行一一映射。
 *
 * @Component: 将此类注入容器，因为 @ConfigurationProperties 注解是 Spring 容器的功能，其标注的类必须先注入到容器中，才能正常使用。
 */
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = {"classpath:person.properties"})
//@Validated
public class Person {

	//@NotEmpty
	private String lastName;
	//@NotNull
	private Integer age;
	private Boolean marriage;
	private Date birth;

	private Map<String,Object> paramsMap;
	private List<Object> paramsList;
	private Dog dog;

	@Override
	public String toString() {
		return "Person{" +
				"lastName='" + lastName + '\'' +
				", age=" + age +
				", marriage=" + marriage +
				", birth=" + birth +
				", paramsMap=" + paramsMap +
				", paramsList=" + paramsList +
				", dog=" + dog +
				'}';
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getMarriage() {
		return marriage;
	}

	public void setMarriage(Boolean marriage) {
		this.marriage = marriage;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

	public List<Object> getParamsList() {
		return paramsList;
	}

	public void setParamsList(List<Object> paramsList) {
		this.paramsList = paramsList;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
}
