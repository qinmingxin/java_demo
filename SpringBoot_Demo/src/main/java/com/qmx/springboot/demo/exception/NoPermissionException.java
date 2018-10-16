package com.qmx.springboot.demo.exception;

import lombok.Data;

@Data
public class NoPermissionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3777891959532883398L;

	private String message ;
	public NoPermissionException() {
		this("no permission");
	}
	
	public NoPermissionException(String message) {
		super(message);
		this.message=message;
	}
}
