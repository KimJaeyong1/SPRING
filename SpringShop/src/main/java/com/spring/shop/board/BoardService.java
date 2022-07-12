package com.spring.shop.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.shop.dto.AttachDto;
import com.spring.shop.dto.BoardDetailResponseDto;
import com.spring.shop.dto.BoardDto;
import com.spring.shop.dto.BoardResponseDto;
import com.spring.shop.dto.SearchDto;

public interface BoardService {
	
	BoardResponseDto list(SearchDto searchDto);
	 
	int write(BoardDto boardDto, HttpServletRequest req, AttachDto attachDto) throws IOException;

	BoardDto getPage(int bi_no);

	BoardDetailResponseDto modify(BoardDto boardDto, HttpServletRequest req, AttachDto attachDto) throws IOException;

	int remove(BoardDto boardDto);

	void hit(int bi_no);

	List<BoardDto> mainBoardList();

	AttachDto fileInfo(int bi_no);
}
