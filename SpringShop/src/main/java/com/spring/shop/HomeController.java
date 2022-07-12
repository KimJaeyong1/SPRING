package com.spring.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.shop.board.BoardService;
import com.spring.shop.dto.BoardDto;
import com.spring.shop.dto.GalleryDto;
import com.spring.shop.gallery.GalleryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<BoardDto> board = boardService.mainBoardList();
		List<GalleryDto> gallery = galleryService.maingalleryList();
		
		model.addAttribute("boardList", board);
		model.addAttribute("galleryList", gallery);
		model.addAttribute("content", "main.jsp");
		
		return "home";
	}
}
