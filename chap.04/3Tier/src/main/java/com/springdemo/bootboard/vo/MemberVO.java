package com.springdemo.bootboard.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO implements Serializable {

	private String userName;
	private String passwd;
	private String firstName;
	private String lastName;
	private boolean enabled;
	private Date regdate;
	
	private List<MemberRoleVO> roles;
	
}
