package com.springdemo.bootboard.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberRoleVO implements Serializable {

	private String userName;
	private String roleName;
	
}
