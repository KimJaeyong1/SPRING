package com.spring.shop.dto;

import java.util.List;

public class GalleryResponseDto {
	private List<GalleryDto> list;
	private SearchDto searchDto;

	public GalleryResponseDto() {
		// TODO Auto-generated constructor stub
	}
	
	public GalleryResponseDto(List<GalleryDto> list, SearchDto searchDto) {
		super();
		this.list = list;
		this.searchDto = searchDto;
	}

	public List<GalleryDto> getList() {
		return list;
	}

	public void setList(List<GalleryDto> list) {
		this.list = list;
	}

	public SearchDto getSearchDto() {
		return searchDto;
	}

	public void setSearchDto(SearchDto searchDto) {
		this.searchDto = searchDto;
	}

	public static GalleryResponseDto create(List<GalleryDto> list, SearchDto searchDto) {
		return new GalleryResponseDto(list, searchDto);
	}
}

