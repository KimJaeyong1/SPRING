package com.spring.shop.gallery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.dto.GalleryDto;
import com.spring.shop.dto.GalleryResponseDto;
import com.spring.shop.dto.SearchDto;

@Service
public class DefaultGalleryService implements GalleryService {

	@Autowired
	private GalleryRepository galleryRepository;
	
	@Override
	public GalleryResponseDto galleryList(SearchDto searchDto) {
		int totalCnt = galleryRepository.getGalleryTotalCnt(searchDto);
		System.out.println(totalCnt);
		
		float limit = ((searchDto.getCurPage() - 1) * searchDto.getPagePerCnt()) + searchDto.getPagePerCnt();
		float offset = (searchDto.getCurPage() - 1) * searchDto.getPagePerCnt();
		
		searchDto.setTotalCnt(totalCnt);
		searchDto.setLimit(limit);
		searchDto.setOffset(offset);
		
		List<GalleryDto> list = galleryRepository.galleryList(searchDto);
		
		return GalleryResponseDto.create(list, searchDto);
	}
	
	@Override
	public GalleryDto detailPage(int gi_no) {
		return galleryRepository.detailPage(gi_no);
	}
	
	@Override
	public int writeAction(GalleryDto galleryDto) {
		return galleryRepository.writeAction(galleryDto);
	}
	
	@Override
	public int modifyAction(GalleryDto galleryDto) {
		return galleryRepository.modifyAction(galleryDto);
	}
}
