package com.spring.shop.member;

public interface MemberRepository {
	int join(MemberDto memberDto);
	
	MemberDto login(MemberDto memberDto);

	int update(MemberDto memberDto);

	int delete(String mi_id);
}
