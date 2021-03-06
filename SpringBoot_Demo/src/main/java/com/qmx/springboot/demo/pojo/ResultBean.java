package com.qmx.springboot.demo.pojo;


import com.qmx.springboot.demo.enumerate.ResultEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultBean<T> { 

	@ApiModelProperty("请求消息")
	private String msg;

	@ApiModelProperty("返回Code")
	private int code;

	@ApiModelProperty("返回数据")
	private T data; 
	
	private boolean success;

	public ResultBean(T data) {
		this("SUCCESS", ResultEnum.SUCCESS.code, data,true);
	}
	
	public ResultBean() {
	}
	public ResultBean(String msg, int code, T data,boolean success) {
		super();
		this.msg = msg;
		this.code = code;
		this.data = data;
		this.success=success;
	}

}
