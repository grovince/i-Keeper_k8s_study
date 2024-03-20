package com.springdemo.bootboard.service;

import java.util.List;

import com.springdemo.bootboard.vo.MailVO;

public interface MailService {

	List<MailVO> findReceivedMailByUserName(String userName);
	MailVO findMailByMailIdx(int mailIdx); 
	void deleteMailByMailIdx(int mailIdx);
	void writeMailByUserName(MailVO mail);
	
}
