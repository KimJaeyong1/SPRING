package com.spring.shop.gallery;

import java.util.List;

import com.spring.shop.dto.AttachDto;
import com.spring.shop.dto.GalleryDto;
import com.spring.shop.dto.SearchDto;

public interface GalleryMapper {

	List<GalleryDto> galleryList(SearchDto searchDto);

	GalleryDto detailPage(int gi_no);

	int writeAction(GalleryDto galleryDto);

	int modifyAction(GalleryDto galleryDto);
	
	int getGalleryTotalCnt(SearchDto searchDto);

	int deleteAction(GalleryDto galleryDto);

	int uploadAction(AttachDto attachDto);

	AttachDto detailFile(int gi_no);

	int fileDeleteAction(int gi_no);

	AttachDto galleryFileInfo(AttachDto attachDto);

	AttachDto fileList();

	List<GalleryDto> maingalleryList();
}
