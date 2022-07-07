package com.spring.shop.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultMemberRepository implements MemberRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int join(MemberDto memberDto) {
		return sqlSession.getMapper(MemberMapper.class).join(memberDto);
	}

	@Override
	public MemberDto login(MemberDto memberDto) {
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}
	
	@Override
	public int update(MemberDto memberDto) {
		return sqlSession.getMapper(MemberMapper.class).update(memberDto);
	}
	
	@Override
	public int delete(String mi_id) {
		return sqlSession.getMapper(MemberMapper.class).delete(mi_id);
	}
}
