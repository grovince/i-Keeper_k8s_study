package com.springdemo.bootboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springdemo.bootboard.mapper.MemberMapper;

import lombok.Data;

@Data
public class SpringBoardUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SpringBoardUserDetails details = new SpringBoardUserDetails();
		details.setMember(memberMapper.selectMemberByEmail(username));
		
		if (details.getMember() == null) return null;
		else return details;
	}

}
