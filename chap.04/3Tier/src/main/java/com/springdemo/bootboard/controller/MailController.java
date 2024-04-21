package com.springdemo.bootboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.bootboard.security.SpringBoardUserDetails;
import com.springdemo.bootboard.security.SpringBoardUserDetailsService;
import com.springdemo.bootboard.service.MailService;
import com.springdemo.bootboard.vo.MailVO;

@Controller
@RequestMapping("/mail")
public class MailController {

	@Autowired
	@Qualifier("mailService")
	MailService mailService;
	
	@GetMapping("/list")
	public String showMailList(Model model, Authentication auth) {
		
		SpringBoardUserDetails details = (SpringBoardUserDetails) auth.getPrincipal();
		List<MailVO> mails = mailService.findReceivedMailByUserName(details.getUsername());
		if (mails != null) model.addAttribute("receivedMails", mails);
		
		return "mail/list";
	}
	
	@GetMapping("/detail")
	public String showDetail(Model model, int mailIdx) {
		
		MailVO mail = mailService.findMailByMailIdx(mailIdx);
		model.addAttribute("mail", mail);
		
		return "modules/modals :: mail-detail-modal";
	}
	
	@GetMapping("/delete/{mailIdx}")
	public String deleteMail(@PathVariable("mailIdx") int mailIdx) {
		mailService.deleteMailByMailIdx(mailIdx);
		
		return "";
	}
	
	@GetMapping("/write")
	public String showWriteForm() {
		return "mail/write";
	}
	
	@PostMapping("/write")
	public String writeMail(MailVO mail) {
		if (mail == null) return "";
		mailService.writeMailByUserName(mail);
		
		return "mail/list";
	}
	
	
}
