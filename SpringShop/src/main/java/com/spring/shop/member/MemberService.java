package com.spring.shop.member;

public interface MemberService {
	// 회원등록
	int join(MemberDto memberDto);
	
	// 로그인
	MemberDto login(MemberDto memberDto);
	
	// 회원정보 수정
	int update(MemberDto memberDto);
	
	//회원 탈퇴
	int delete(String mi_id);
}
