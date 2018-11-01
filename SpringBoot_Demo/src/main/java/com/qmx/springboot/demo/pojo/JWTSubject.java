package com.qmx.springboot.demo.pojo;

import lombok.Data;

/**
 * 作为Subject数据使用。也就是payload中保存的public claims
 * 其中不包含任何敏感数据
 */
@Data
public class JWTSubject {

	private String username;
	
	

	public JWTSubject() {
		super();
	}

	public JWTSubject(String username) {
		super();
		this.username = username;
	}
	
}
