package com.qmx.springboot.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmx.springboot.demo.dao.IUserDao;
import com.qmx.springboot.demo.exception.ParamException;
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

}
