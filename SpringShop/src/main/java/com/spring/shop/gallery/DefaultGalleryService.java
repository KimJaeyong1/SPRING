package com.spring.shop.gallery;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.common.FileService;
import com.spring.shop.dto.AttachDto;
import com.spring.shop.dto.GalleryDetailResponseDto;
import com.spring.shop.dto.GalleryDto;
import com.spring.shop.dto.GalleryResponseDto;
import com.spring.shop.dto.SearchDto;

@Service
public class DefaultGalleryService implements GalleryService {

	@Autowired
	private GalleryRepository galleryRepository;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager; 
	
	// 갤러리 게시판 페이징 관련 로직
	@Override
	public GalleryResponseDto galleryList(SearchDto searchDto) {
		int totalCnt = galleryRepository.getGalleryTotalCnt(searchDto);
		
		float limit = ((searchDto.getCurPage() - 1) * searchDto.getPagePerCnt()) + searchDto.getPagePerCnt();
		float offset = (searchDto.getCurPage() - 1) * searchDto.getPagePerCnt();
		
		searchDto.setTotalCnt(totalCnt);
		searchDto.setLimit(limit);
		searchDto.setOffset(offset);
		
		List<GalleryDto> list = galleryRepository.galleryList(searchDto);
		
		return GalleryResponseDto.create(list, searchDto);
	}
	
	// 갤러리 게시판 글 작성 + 파일 업로드
	@Override
	public int writeAction(HttpServletRequest req, GalleryDto galleryDto, AttachDto attachDto) throws IOException {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		try {
			galleryRepository.writeAction(galleryDto);
			
			attachDto = fileService.singleFileUpload(req, attachDto, galleryDto.getGi_no(), "GALLERY");
			
			galleryRepository.uploadAction(attachDto);
			
			platformTransactionManager.commit(status);
			
			return 1;
		} catch (Exception e) {
			System.out.println("글 등록 실패");
			platformTransactionManager.rollback(status);
			File file = new File(req.getSession().getServletContext().getRealPath("resources/file/")+attachDto.getSaved_file_name());
			file.delete();
			return 0;
		}
	}
	
	@Override
	public GalleryDto detailPage(int gi_no) {
		return galleryRepository.detailPage(gi_no);
	}
	
	// 갤러리 게시판 글 수정 실행
	@Override
	public GalleryDetailResponseDto modifyAction(HttpServletRequest req, GalleryDto galleryDto, AttachDto attachDto) {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		try {
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
			MultipartFile file = mr.getFile("file");
			
			if(!file.isEmpty()) {
				galleryRepository.fileDeleteAction(galleryDto.getGi_no());
				attachDto = fileService.singleFileUpload(req, attachDto, galleryDto.getGi_no(), "GALLERY");
				
				galleryRepository.uploadAction(attachDto);
			}
			
			galleryRepository.modifyAction(galleryDto);
			galleryDto = galleryRepository.detailPage(galleryDto.getGi_no());
			attachDto = galleryRepository.detailFile(galleryDto.getGi_no());
			
			platformTransactionManager.commit(status);
			return GalleryDetailResponseDto.create(galleryDto, attachDto);
		} catch (Exception e) {
			e.printStackTrace();
			platformTransactionManager.rollback(status);
			File file = new File(req.getSession().getServletContext().getRealPath("resources/file/")+attachDto.getSaved_file_name());
			file.delete();
			return null;
		}
	}
	
	@Override
	public int deleteAction(GalleryDto galleryDto) {
		return galleryRepository.deleteAction(galleryDto);
	}
	
	@Override
	public AttachDto detailFile(int gi_no) {
		return galleryRepository.detailFile(gi_no);
	}
	
	// 갤러리 게시판 파일 삭제 실행
	@Override
	public int fileDeleteAction(HttpServletRequest req, AttachDto attachDto, int gi_no) {
		AttachDto fileInfo = galleryRepository.detailFile(gi_no);
		
		File file = new File(req.getSession().getServletContext().getRealPath("resources/file/")+fileInfo.getSaved_file_name());
		
		if(file != null) {
			file.delete();
			galleryRepository.fileDeleteAction(gi_no);
		}
		return 1; 
	}
	
	@Override
	public List<GalleryDto> maingalleryList() {
		return galleryRepository.maingalleryList();
	}
}
