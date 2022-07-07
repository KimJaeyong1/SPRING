package com.spring.shop.dto;

public class GalleryDetailResponseDto {
	private GalleryDto galleryDto;
	private AttachDto attachDto;
	
	public GalleryDto getBoardDto() {
		return galleryDto;
	}
	public void setBoardDto(GalleryDto galleryDto) {
		this.galleryDto = galleryDto;
	}
	public AttachDto getAttachDto() {
		return attachDto;
	}
	public void setAttachDto(AttachDto attachDto) {
		this.attachDto = attachDto;
	}
	
	public GalleryDetailResponseDto() {
		// TODO Auto-generated constructor stub
	}
	
	public GalleryDetailResponseDto(GalleryDto galleryDto, AttachDto attachDto) {
		super();
		this.galleryDto = galleryDto;
		this.attachDto = attachDto;
	}
	
	public static final GalleryDetailResponseDto create(GalleryDto galleryDto, AttachDto attachDto) {
		return new GalleryDetailResponseDto(galleryDto, attachDto);
	}
}
