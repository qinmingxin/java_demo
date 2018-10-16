package com.qmx.springboot.demo.pojo.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Data
@Table(name = "t_users")
public class UserDto implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -2363807344529762113L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;

	private String password;
	
	private String mobile;
	
	private String gender;
	
//	@Column(name="creation_date") jpa自动解析驼峰为下划线
	@CreatedDate
	private String creationDate;
	
//	@Column(name="last_update_date")
	@LastModifiedDate
	private String lastUpdateDate;

}
