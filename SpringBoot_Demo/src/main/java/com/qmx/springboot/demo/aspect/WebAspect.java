package com.qmx.springboot.demo.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

@Aspect
public class WebAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(WebAspect.class);

	@Pointcut("execution (* com.qmx.springboot.demo.pojo.ResultBean com.qmx.springboot.demo.*.conroller.*(..))")
	public void WebAspectPonintCut() {
	};

	@Around("WebAspectPonintCut()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

		Object args[] = joinPoint.getArgs();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		// join arguments.
		logger.info("{}.{} : 请求参数:{} ", method.getDeclaringClass().getName(), method.getName(),
				args);
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long timeConsuming = System.currentTimeMillis() - start;
		logger.info("调用结束--> 返回值:{} 耗时:{}ms", JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue),
				timeConsuming);
		return result;
	}

}
