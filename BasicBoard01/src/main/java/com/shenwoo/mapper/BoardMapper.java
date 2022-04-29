package com.shenwoo.mapper;

import java.util.List;

import com.shenwoo.domain.BoardVO;
import com.shenwoo.domain.Criteria;

public interface BoardMapper {
	
	// 게시판 글 등록
	public void enroll(BoardVO board);
	
	// 게시판 글 목록
	public List<BoardVO> getList();
	
    // 게시판 글 목록(페이징 적용)
    public List<BoardVO> getListPaging(Criteria cri);
	
	// 게시물 글 조회
	public BoardVO getPage(int bno);
	
	// 게시판 글 수정
	public int modify(BoardVO board);
	
	// 게시판 글 삭제
    public int delete(int bno);
    
    // 게시판 글 총 갯수
    public int getTotal(Criteria cri);
}
