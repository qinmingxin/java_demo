package com.qmx.springboot.demo.aspect;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qmx.springboot.demo.enumerate.ResultEnum;
import com.qmx.springboot.demo.exception.NoPermissionException;
import com.qmx.springboot.demo.exception.ParamException;
import com.qmx.springboot.demo.exception.UnauthorizedException;
import com.qmx.springboot.demo.pojo.ResultBean;

@RestControllerAdvice
public class WebControllerAdvice {
	
	@ExceptionHandler
	public ResultBean errorHandler(Exception ex) {
		ResultBean result =new ResultBean();
		if(ex instanceof NoPermissionException) {
			result.setCode(ResultEnum.NO_PERMISSION.code);
		}else if(ex instanceof ParamException) {
			result.setCode(ResultEnum.PARAM_ERROR.code);
		}else if(ex instanceof UnauthorizedException) {
			result.setCode(ResultEnum.UNAUTHORIZED.code);
		}else {
			result.setCode(ResultEnum.INTERNAL_SERVER_ERROR.code);
		}
		result.setMsg(ex.getMessage());
		return result;
	}

}
