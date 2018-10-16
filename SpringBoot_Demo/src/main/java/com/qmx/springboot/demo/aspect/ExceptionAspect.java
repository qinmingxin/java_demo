package com.qmx.springboot.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect//改用ControllerAdvice
public class ExceptionAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

	@Pointcut("execution (* com.qmx.springboot.demo.pojo.ResultBean com.qmx.springboot.demo.*.conroller.*(..))")
	public void exceptionPointCut() {
	};
	
	
}
