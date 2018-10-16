package com.qmx.springboot.demo.exception;

import lombok.Data;

@Data
public class UnauthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3777891959532883398L;

	private String message ;
	public UnauthorizedException() {
		this("unauthorized");
	}
	
	public UnauthorizedException(String message) {
		super(message);
		this.message=message;
	}
}
