package com.springdemo.bootboard.service;

import com.springdemo.bootboard.vo.MemberVO;

public interface MemberService {

	void registerMember(MemberVO member);
	void loginMember(MemberVO member) ;

}
