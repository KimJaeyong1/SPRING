package com.shenwoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/login/*")
@Log4j
public class LoginController {

	@GetMapping("login")
	public void getLogin() {
		
		log.info("로그인 페이지");
		
	}
	
	@GetMapping("join")
	public void getJoin() {
		
		log.info("회원가입 페이지");
		
	}
}
