package com.spring.shop.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shop.dto.GalleryDto;
import com.spring.shop.dto.GalleryResponseDto;
import com.spring.shop.dto.SearchDto;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	// 갤러리 게시판 페이지
	@RequestMapping("/gallery/gallery")
	public String galleryBoardPage(Model model) {
		model.addAttribute("content", "gallery/gallery.jsp");
		
		return "home";
	}
	
	// 갤러리 게시판 리스트 (ajax)
	@RequestMapping(value = "/gallery/getGalleryList", method = RequestMethod.GET)
	@ResponseBody
	public GalleryResponseDto getGalleryList(SearchDto searchDto) {
		return galleryService.galleryList(searchDto);
	}

	// 갤러리 게시판 글 작성 페이지
	@RequestMapping(value="/gallery/writePage", method=RequestMethod.GET)
	public String galleryWritePage(Model model) {
		model.addAttribute("content", "gallery/writePage.jsp");
		
		return "home";
	}
	
	// 갤러리 게시판 상세 페이지
	@RequestMapping(value="/gallery/detailPage", method=RequestMethod.GET)
	public String galleryDetailPage(Model model, int gi_no) {
		GalleryDto pageData = galleryService.detailPage(gi_no);
		
		model.addAttribute("galleryInfo", pageData);
		model.addAttribute("content", "gallery/detailPage.jsp");
		return "home";
	}
	
	// 갤러리 게시판 글작성 실행
	@RequestMapping(value="/galleryWriteAction", method=RequestMethod.POST)
	public String writeAction(Model model, GalleryDto galleryDto, SearchDto searchDto) {
		int result = galleryService.writeAction(galleryDto);
		
		if(result == 1) {
			model.addAttribute("list", galleryService.galleryList(searchDto));
			model.addAttribute("MSG", "갤러리 게시판 글 작성이 완료 되었습니다.");
			model.addAttribute("content", "gallery/gallery.jsp");
		}
		return "home";
	}
	
	// 갤러리 게시판 수정페이지
	@RequestMapping(value="/gallery/modifyPage", method=RequestMethod.GET)
	public String galleryModifyPage(Model model, int gi_no) {
		GalleryDto pageData = galleryService.detailPage(gi_no);
		
		model.addAttribute("galleryInfo", pageData);
		model.addAttribute("content", "gallery/modifyPage.jsp");
		return "home";
	}
	
	// 갤러리 게시판 수정페이지 수정 실행
	@RequestMapping(value="/galleryModifyAction", method=RequestMethod.POST)
	public String modifyAction(Model model, GalleryDto galleryDto, SearchDto searchDto) {
		int result = galleryService.modifyAction(galleryDto);
		
		if(result == 1) {
			model.addAttribute("list", galleryService.galleryList(searchDto));
			model.addAttribute("MSG", "갤러리 게시판 글 작성이 완료 되었습니다.");
			model.addAttribute("content", "gallery/gallery.jsp");
		}
		return "home";
	}
}
