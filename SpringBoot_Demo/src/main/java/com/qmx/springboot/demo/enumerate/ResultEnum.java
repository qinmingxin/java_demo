package com.qmx.springboot.demo.enumerate;


public enum ResultEnum {
	
	SUCCESS(200),//成功
	BAD_REQUEST(400),//参数错误
    UNAUTHORIZED(401),//未认证（签名错误）
    NO_PERMISSION(403),//无权限
    INTERNAL_SERVER_ERROR(500),//服务器内部错误
	PARAM_ERROR(101);

	
	
	private ResultEnum(int code) {
		this.code = code;
	}

	public  int code;
	
	


	
		
}
