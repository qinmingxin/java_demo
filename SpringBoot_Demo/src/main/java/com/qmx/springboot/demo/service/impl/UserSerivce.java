package com.qmx.springboot.demo.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmx.springboot.demo.common.JWTUtils;
import com.qmx.springboot.demo.dao.IUserDao;
import com.qmx.springboot.demo.exception.ParamException;
import com.qmx.springboot.demo.pojo.JWTSubject;
import com.qmx.springboot.demo.pojo.dto.UserDto;
import com.qmx.springboot.demo.service.IUserService;

@Service
public class UserSerivce implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public void addUser(UserDto userDto)   {
		String username = userDto.getUsername();
		int countByName = countByName(username);
		if(countByName>0) {
			throw new ParamException("用户名重复");
		}
		userDao.save(userDto);
	}
	
	public int countByName(String name) {
		int count = userDao.countByName(name);
		return count;
	}

	@Override
	public String login(UserDto userDto) {
		String jwtToken = null;
		String username = userDto.getUsername();
		String password = userDto.getPassword();
		if(isLogin(username,password)) {
			JWTSubject jwtSubject = new JWTSubject(username);
			 jwtToken = JWTUtils.createJWT(UUID.randomUUID().toString(), "qmx", 
					JWTUtils.generalSubject(jwtSubject), 1*60*1000);
		}
		return jwtToken;
		
		
	}

	private boolean isLogin(String username,String password) {
	
		UserDto findByUsernameAndPassword = userDao.findByUsernameAndPassword(username,password);
		return findByUsernameAndPassword!=null;
	}

}
