package com.spring.shop.gallery;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shop.dto.GalleryDto;
import com.spring.shop.dto.SearchDto;

@Repository
public class DefaultGalleryRepository implements GalleryRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<GalleryDto> galleryList(SearchDto searchDto) {
		return sqlSession.getMapper(GalleryMapper.class).galleryList(searchDto);
	}

	@Override
	public GalleryDto detailPage(int gi_no) {
		return sqlSession.getMapper(GalleryMapper.class).detailPage(gi_no);
	}
	
	@Override
	public int writeAction(GalleryDto galleryDto) {
		return sqlSession.getMapper(GalleryMapper.class).writeAction(galleryDto);
	}
	
	@Override
	public int modifyAction(GalleryDto galleryDto) {
		return sqlSession.getMapper(GalleryMapper.class).modifyAction(galleryDto);
	}
	
	@Override
	public int getGalleryTotalCnt(SearchDto searchDto) {
		return sqlSession.getMapper(GalleryMapper.class).getGalleryTotalCnt(searchDto);
	}
}
