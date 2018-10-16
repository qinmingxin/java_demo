package com.qmx.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qmx.springboot.demo.pojo.dto.UserDto;

@Repository
public interface IUserDao extends JpaRepository<UserDto, Long>{
	
	 
	@Query("select count(id) from UserDto u where u.username = :username")
	int countByName(@Param("username") String name);

}
