package com.qmx.springboot.demo.exception;

import lombok.Data;

@Data
public class InternalServerErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3777891959532883398L;

	private String message ;
	public InternalServerErrorException() {
		this("internal server error");
	}
	
	public InternalServerErrorException(String message) {
		super(message);
		this.message=message;
	}
}
