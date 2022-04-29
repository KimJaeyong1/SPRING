package com.shenwoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenwoo.domain.BoardVO;
import com.shenwoo.domain.Criteria;
import com.shenwoo.mapper.BoardMapper;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	// 게시판 글 목록
	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}
	
	// 게시판 글 목록(페이징 적용)
	@Override
	public List<BoardVO> getListPaging(Criteria cri) {
		
		return mapper.getListPaging(cri);
	}
	
	// 게시판 특정 글 조회
	@Override
	public BoardVO getPage(int bno) {
		
		return mapper.getPage(bno);
	}
	
	// 게시판 글 총 갯수
    @Override
    public int getTotal(Criteria cri) {
        
    	return mapper.getTotal(cri);
    }
	
	// 게시판 글 등록
	@Override
	public void register(BoardVO board) {
		
		mapper.register(board);
	}
	
	// 게시판 글 수정
	@Override
    public int modify(BoardVO board) {
        
        return mapper.modify(board);
    }
	
	// 게시판 글 삭제
	@Override
	public int delete(int bno) {
		
		return mapper.delete(bno);
	}


}
