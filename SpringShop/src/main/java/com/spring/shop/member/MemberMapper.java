package com.spring.shop.member;

public interface MemberMapper {
	int join(MemberDto memberDto);
	
	MemberDto login(MemberDto memberDto);

	int update(MemberDto memberDto);

	int delete(String mi_id);
}
