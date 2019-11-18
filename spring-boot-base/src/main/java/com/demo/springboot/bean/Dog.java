package com.demo.springboot.bean;

/**
 * _@Author: jianghj
 * _@Date: 2019.11.16 016 10:33
 * _@Desc:
 */
public class Dog {
	private String name;
	private Integer age;

	@Override
	public String toString() {
		return "Dog{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
