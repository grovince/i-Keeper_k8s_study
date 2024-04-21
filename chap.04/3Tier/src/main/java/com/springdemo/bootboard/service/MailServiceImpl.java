package com.springdemo.bootboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springdemo.bootboard.mapper.MailMapper;
import com.springdemo.bootboard.vo.MailVO;

@Service("mailService")
public class MailServiceImpl implements MailService {
	
	@Autowired
	@Qualifier("mailMapper")
	MailMapper mailMapper;

	@Override
	public List<MailVO> findReceivedMailByUserName(String userName) {
		return mailMapper.selectReceivedMailByUserName(userName);
	}

	@Override
	public MailVO findMailByMailIdx(int mailIdx) {
		return mailMapper.selectMailByMailIdx(mailIdx);
	}

	@Override
	public void deleteMailByMailIdx(int mailIdx) {
		mailMapper.deleteMailByMailIdx(mailIdx);
	}

	@Override
	public void writeMailByUserName(MailVO mail) {
		mailMapper.insertMailByUserName(mail);
	}
	
}














