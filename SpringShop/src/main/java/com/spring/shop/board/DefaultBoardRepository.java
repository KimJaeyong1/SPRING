package com.spring.shop.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shop.dto.AttachDto;
import com.spring.shop.dto.BoardDto;
import com.spring.shop.dto.SearchDto;

@Repository
public class DefaultBoardRepository implements BoardRepository {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardDto> list(SearchDto searchDto) {
		return sqlSession.getMapper(BoardMapper.class).boardList(searchDto);
	}
	
	@Override
	public int getTotalCnt(SearchDto searchDto) {
		return sqlSession.getMapper(BoardMapper.class).getTotalCnt(searchDto);
	}
	
	@Override
	public int write(BoardDto boardDto) {
		return sqlSession.getMapper(BoardMapper.class).write(boardDto);
	}
	
	@Override
	public int upload(AttachDto attachDto) {
		return sqlSession.getMapper(BoardMapper.class).upload(attachDto);
	}
	
	@Override
	public BoardDto getPage(int bi_no) {
		return sqlSession.getMapper(BoardMapper.class).getPage(bi_no);
	}
	
	@Override
	public int modify(BoardDto boardDto) {
		return sqlSession.getMapper(BoardMapper.class).modify(boardDto);
	}
	
	@Override
	public int remove(BoardDto boardDto) {
		return sqlSession.getMapper(BoardMapper.class).remove(boardDto);
	}
	
	@Override
	public void hit(int bi_no) {
		sqlSession.getMapper(BoardMapper.class).hit(bi_no);
	}
	
	@Override
	public AttachDto fileInfo(int bi_no) {
		return sqlSession.getMapper(BoardMapper.class).fileInfo(bi_no);
	}
	
	@Override
	public int deleteFile(int bi_no) {
		return sqlSession.getMapper(BoardMapper.class).deleteFile(bi_no);
	}
	
	@Override
	public int modifyFile(int board_id) {
		return sqlSession.getMapper(BoardMapper.class).modifyFile(board_id);
	}

	@Override
	public List<BoardDto> mainBoardList() {
		return sqlSession.getMapper(BoardMapper.class).mainBoardList();
	}
}
