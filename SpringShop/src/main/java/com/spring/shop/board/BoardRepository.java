package com.spring.shop.board;

import java.util.List;

import com.spring.shop.dto.AttachDto;
import com.spring.shop.dto.BoardDto;
import com.spring.shop.dto.SearchDto;

public interface BoardRepository {

	List<BoardDto> list(SearchDto searchDto);

	int write(BoardDto boardDto);

	BoardDto getPage(int bi_no);

	int modify(BoardDto boardDto);

	int remove(BoardDto boardDto);

	void hit(int bi_no);

	int getTotalCnt(SearchDto searchDto);

	int upload(AttachDto attachDto);

	AttachDto fileInfo(int bi_no);

	int deleteFile(int bi_no);

	int modifyFile(int board_id);
}
