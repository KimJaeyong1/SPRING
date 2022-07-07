package com.spring.shop.gallery;

import com.spring.shop.dto.GalleryDto;
import com.spring.shop.dto.GalleryResponseDto;
import com.spring.shop.dto.SearchDto;

public interface GalleryService {

	GalleryResponseDto galleryList(SearchDto searchDto);

	int writeAction(GalleryDto galleryDto);
	
	GalleryDto detailPage(int gi_no);

	int modifyAction(GalleryDto galleryDto);

}
