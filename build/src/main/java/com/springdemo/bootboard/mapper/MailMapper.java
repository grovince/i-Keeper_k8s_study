package com.springdemo.bootboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springdemo.bootboard.vo.MailVO;

@Mapper
public interface MailMapper {
	
	List<MailVO> selectReceivedMailByUserName(String userName);
	MailVO selectMailByMailIdx(int mailIdx); 
	void deleteMailByMailIdx(int mailIdx);
	void insertMailByUserName(MailVO mail);
	
}
