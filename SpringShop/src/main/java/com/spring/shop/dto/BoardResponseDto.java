package com.spring.shop.dto;

import java.util.List;

public class BoardResponseDto {
	private List<BoardDto> list;
	private SearchDto searchDto;

	public List<BoardDto> getList() {
		return list;
	}

	public void setList(List<BoardDto> list) {
		this.list = list;
	}

	public SearchDto getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}

	public BoardResponseDto(List<BoardDto> list, SearchDto searchDto) {
		super();
		this.list = list;
		this.searchDto = searchDto;
	}
	
	public static BoardResponseDto create(List<BoardDto> list, SearchDto searchDto) {
		return new BoardResponseDto(list, searchDto);
	}
}

