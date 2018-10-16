package com.qmx.springboot.demo.exception;

import lombok.Data;

@Data
public class ParamException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3777891959532883398L;

	private String message ;
	public ParamException() {
		this("param error");
	}
	
	public ParamException(String message) {
		super(message);
		this.message=message;
	}
}
