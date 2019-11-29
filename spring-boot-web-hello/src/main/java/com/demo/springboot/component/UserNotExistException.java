package com.demo.springboot.component;

/**
 * @author - Jianghj
 * @since - 2019-11-29 15:07
 * 自定义异常
 */
public class UserNotExistException extends RuntimeException {

	public UserNotExistException() {
		super("当前用户不存在！");
	}

	public UserNotExistException(String message) {
		super(message);
	}
}
