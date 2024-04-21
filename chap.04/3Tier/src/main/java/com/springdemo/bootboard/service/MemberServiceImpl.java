package com.springdemo.bootboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.bootboard.mapper.MemberMapper;
import com.springdemo.bootboard.vo.MemberRoleVO;
import com.springdemo.bootboard.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void registerMember(MemberVO member) {
		
		memberMapper.insertMember(member);
		
		MemberRoleVO role = new MemberRoleVO();
		role.setUserName(member.getUserName());
		role.setRoleName("MEMBER");
		memberMapper.insertMemberRole(role);
	}

	@Override
	public void loginMember(MemberVO member) {
		memberMapper.getMember(member);

	}


}
