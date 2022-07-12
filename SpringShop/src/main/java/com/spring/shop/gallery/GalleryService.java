package com.spring.shop.gallery;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.shop.dto.AttachDto;
import com.spring.shop.dto.GalleryDetailResponseDto;
import com.spring.shop.dto.GalleryDto;
import com.spring.shop.dto.GalleryResponseDto;
import com.spring.shop.dto.SearchDto;

public interface GalleryService {

	// 갤러리 게시판 글 리스트
	GalleryResponseDto galleryList(SearchDto searchDto);

	// 갤러리 게시판 글 작성 실행
	int writeAction(HttpServletRequest req, GalleryDto galleryDto, AttachDto attachDto) throws IOException;
	
	// 갤러리 게시판 상세 페이지
	GalleryDto detailPage(int gi_no);
	
	// 갤러리 게시판 글 수정 실행
	GalleryDetailResponseDto modifyAction(HttpServletRequest req, GalleryDto galleryDto, AttachDto attachDto);
	
	// 갤러리 게시판 글 삭제 실행
	int deleteAction(GalleryDto galleryDto);
	
	// 갤러리 게시판 파일 정보
	AttachDto detailFile(int gi_no);
	
	// 갤러리 게시판 파일 삭제 실행
	int fileDeleteAction(HttpServletRequest req, AttachDto attachDto, int gi_no);

	List<GalleryDto> maingalleryList();
}
