package com.spring.shop.dto;

public class BoardDetailResponseDto {
	private BoardDto boardDto;
	private AttachDto attachDto;
	
	public BoardDto getBoardDto() {
		return boardDto;
	}
	public void setBoardDto(BoardDto boardDto) {
		this.boardDto = boardDto;
	}
	public AttachDto getAttachDto() {
		return attachDto;
	}
	public void setAttachDto(AttachDto attachDto) {
		this.attachDto = attachDto;
	}
	
	public BoardDetailResponseDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardDetailResponseDto(BoardDto boardDto, AttachDto attachDto) {
		super();
		this.boardDto = boardDto;
		this.attachDto = attachDto;
	}
	
	public static final BoardDetailResponseDto create(BoardDto boardDto, AttachDto attachDto) {
		return new BoardDetailResponseDto(boardDto, attachDto);
	}
}
