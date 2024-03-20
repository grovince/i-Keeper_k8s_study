package com.springdemo.bootboard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.springdemo.bootboard.vo.MemberRoleVO;
import com.springdemo.bootboard.vo.MemberVO;

@Mapper
public interface MemberMapper {

	MemberVO selectMemberByEmail(String username);

	void insertMember(MemberVO member);
	void insertMemberRole(MemberRoleVO role);

	void getMember(MemberVO member) ;
}
