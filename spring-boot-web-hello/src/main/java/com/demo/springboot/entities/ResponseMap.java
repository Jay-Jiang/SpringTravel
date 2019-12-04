package com.demo.springboot.entities;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author - Jianghj
 * @since - 2019-12-04 13:52
 */
public class ResponseMap {
	private Integer respCode;
	private String respMsg;
	private Map<String, Object> attributes;

	private ResponseMap(){}

	/**
	 * 封装请求成功的响应
	 */
	public static ResponseMap success(String respMsg){
		ResponseMap responseMap = new ResponseMap();
		responseMap.setAttributes(new HashMap<>());
		responseMap.setRespCode(0);
		responseMap.setRespMsg(StringUtils.isEmpty(respMsg)?"请求处理成功":respMsg);
		return responseMap;
	}

	public static ResponseMap success(){
		return success(null);
	}

	/**
	 * 封装请求失败的响应
	 */
	public static ResponseMap fail(String respMsg){
		ResponseMap responseMap = new ResponseMap();
		responseMap.setAttributes(new HashMap<>());
		responseMap.setRespCode(-100);
		responseMap.setRespMsg(StringUtils.isEmpty(respMsg)?"请求处理失败":respMsg);
		return responseMap;
	}

	public static ResponseMap fail(){
		return fail(null);
	}

	/**
	 * 添加自定义的响应参数
	 * @param key 参数键
	 * @param value 参数值
	 */
	public ResponseMap addAttribute(String key, Object value){
		this.getAttributes().put(key, value);
		return this;
	}

	public Integer getRespCode() {
		return respCode;
	}

	private void setRespCode(Integer respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	private void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	private void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
}
