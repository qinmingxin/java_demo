package com.qmx.springboot.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractControllerBase {
	
	@Autowired
	private HttpServletRequest request;
	
	
	public String getCookie() {
		return request.getHeader("Cookie");
	}
}
