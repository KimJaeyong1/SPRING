package com.spring.shop.gallery;

import java.util.List;

import com.spring.shop.dto.GalleryDto;
import com.spring.shop.dto.SearchDto;

public interface GalleryMapper {

	List<GalleryDto> galleryList(SearchDto searchDto);

	GalleryDto detailPage(int gi_no);

	int writeAction(GalleryDto galleryDto);

	int modifyAction(GalleryDto galleryDto);
	
	int getGalleryTotalCnt(SearchDto searchDto);
}
