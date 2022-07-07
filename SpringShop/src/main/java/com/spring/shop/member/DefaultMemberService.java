package com.spring.shop.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultMemberService implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public int join(MemberDto memberDto) {
		return memberRepository.join(memberDto);
	}
	
	@Override
	public MemberDto login(MemberDto memberDto) {
		return memberRepository.login(memberDto);
	}
	
	@Override
	public int update(MemberDto memberDto) {
		return memberRepository.update(memberDto);
	}
	
	@Override
	public int delete(String mi_id) {
		return memberRepository.delete(mi_id);
	}
}
