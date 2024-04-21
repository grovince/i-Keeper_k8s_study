package com.springdemo.bootboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.bootboard.service.MemberService;
import com.springdemo.bootboard.vo.MemberVO;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	@Qualifier("memberService")
	MemberService memberService;
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "account/login";
	}

	@PostMapping("/login")
	public String login(MemberVO member) {
		memberService.loginMember(member);
		return "redirect:/home" ;
	}
	
	@GetMapping("/register")
	public String showRegisterForm() {
		return "account/register";
	}
	
	@PostMapping("/register")
	public String register(MemberVO member) {
		memberService.registerMember(member);	
		return "home";
	}
	
	@GetMapping("/mypage")
	public String showMypage() {
		return "account/mypage";
	}
}
