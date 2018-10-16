package com.qmx.springboot.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qmx.springboot.demo.pojo.ResultBean;
import com.qmx.springboot.demo.pojo.dto.UserDto;
import com.qmx.springboot.demo.service.IUserService;

import io.swagger.annotations.Api;

@RestController
@Api("用户管理")
@RequestMapping("/qmx/user")
public class UserController extends AbstractControllerBase {
	  
	@Autowired
	private IUserService userService;
	
	@PostMapping("") 
	public ResultBean<UserDto> addUser(
			@RequestBody  UserDto userDto){
		userService.addUser(userDto);
		return new ResultBean<>(userDto);
	}
	
	
	 
	
}
