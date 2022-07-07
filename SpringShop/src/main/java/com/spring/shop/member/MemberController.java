package com.spring.shop.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// 로그인 페이지
	@RequestMapping("/member/login")
	public String loginPage(Model model) {
		model.addAttribute("content", "member/login.jsp");
		
		return "home";
	}
	
	// 회원가입 페이지
	@RequestMapping("/member/register")
	public String registerPage(Model model) {
		model.addAttribute("content", "member/register.jsp");
		
		return "home";
	}
	
	// 회원정보 페이지
	@RequestMapping("/member/info")
	public String infoPage(Model model, MemberDto memberDto) {
		model.addAttribute("content", "member/info.jsp");
		
		return "home";
	}
	
	// 회원정보 수정페이지
	@RequestMapping("/member/update")
	public String updatePage(Model model) {
		model.addAttribute("content", "member/update.jsp");
		
		return "home";
	}
	
	// 로그인 실행
	@RequestMapping("/login")
	public String memberLogin(Model model, MemberDto memberDto, HttpServletRequest req) {
		MemberDto loginCheck = memberService.login(memberDto);
		
		if(loginCheck != null) {
			req.getSession().setAttribute("member", loginCheck);
			model.addAttribute("MSG", "로그인 성공!");
			model.addAttribute("content", "main.jsp");
		} else {
			model.addAttribute("MSG", "로그인실패");
			model.addAttribute("content", "member/login.jsp");
		}
		
		return "home";
	}
	
	// 로그아웃 실행
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		
		model.addAttribute("content", "main.jsp");
		model.addAttribute("MSG", "로그아웃 되었습니다.");
		return "home";
	}
	
	// 회원가입 실행
	@RequestMapping("/join")
	public String memberJoin(Model model, MemberDto memberDto) {
		int result = memberService.join(memberDto);
		
		if(result == 1) {
			model.addAttribute("MSG", "회원가입 성공");
		}
		
		model.addAttribute("content", "member/login.jsp");
		
		return "home";
	}
	
	// 회원정보 수정
	@RequestMapping("/update")
	public String memberUpdate(Model model, MemberDto memberDto, HttpServletRequest req) {
		int result = memberService.update(memberDto);
		
		if(result == 1) {
			MemberDto loginCheck = memberService.login(memberDto);
			req.getSession().setAttribute("member", loginCheck);
			model.addAttribute("MSG", "회원정보 수정성공");
		}
		
		model.addAttribute("content", "member/info.jsp");
		
		return "home";
	}
	
	// 회원탈퇴
	@RequestMapping("/delete")
	public String memberDelete(Model model, HttpSession session, String mi_id) {
		int result = memberService.delete(mi_id);
		
		if(result == 1) {
			model.addAttribute("MSG", "회원탈퇴 완료");
			session.invalidate();
		}
		
		model.addAttribute("content", "main.jsp");
		
		return "home";
	}
}
