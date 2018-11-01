package com.qmx.springboot.demo.pojo.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import io.swagger.annotations.ApiModelProperty;
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
	
	@ApiModelProperty("用户名")
	@NotEmpty
	private String username;
	
	@ApiModelProperty("密码")
	private String password;
	
	@ApiModelProperty("手机号")
	private String mobile;
	
	@ApiModelProperty("性别 1男 2女  0默认")
	private String gender;
	
//	@Column(name="creation_date") jpa自动解析驼峰为下划线
	@CreatedDate
	private String creationDate;
	
//	@Column(name="last_update_date")
	@LastModifiedDate
	private String lastUpdateDate;

}
