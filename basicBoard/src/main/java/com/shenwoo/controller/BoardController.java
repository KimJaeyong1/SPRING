package com.shenwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shenwoo.domain.BoardVO;
import com.shenwoo.domain.Criteria;
import com.shenwoo.domain.PageMakerDTO;
import com.shenwoo.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	
	// 게시판 목록 페이지 접속
	
	/*
	 @GetMapping("/list") public void boardListGET(Model model) {
	 
	 log.info("게시판 글 목록 페이지");

	 model.addAttribute("list", service.getList()); }
	 */
	
	// 게시판 목록 페이지 접속(페이징 적용)
    @GetMapping("/list")
    public void boardListGET(Model model, Criteria cri) {
        
        log.info("boardListGET");
        
        model.addAttribute("list", service.getListPaging(cri));
        
        int total = service.getTotal(cri);
        
        PageMakerDTO pageMake = new PageMakerDTO(cri, total);
        
        model.addAttribute("pageMaker", pageMake);
        
    }  
	
	// 게시판 글 등록 페이지 접속
	@GetMapping("/enroll")
	public void boardEnrollGET() {
		
		log.info("게시판 글 등록 페이지");
	}
	
	 // 게시판 글 등록
    @PostMapping("/enroll")
    public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
        
        log.info("BoardVO : " + board);
        
        service.enroll(board);
        
        rttr.addFlashAttribute("result", "enroll success");
        
        return "redirect:/board/list";
    }
    
    // 게시판 글 조회
    @GetMapping("/get")
    public void boardGetPageGET(int bno, Model model, Criteria cri) {
    	
    	log.info("해당 글 조회 페이지");
    	
    	model.addAttribute("pageInfo", service.getPage(bno));
    	
    	model.addAttribute("cri", cri);
    }
    
    // 게시판 글 수정
    @GetMapping("/modify")
    public void boardModifyGET(int bno, Model model, Criteria cri) {
        
        model.addAttribute("pageInfo", service.getPage(bno));
        
        model.addAttribute("cri", cri);
        
    }
    
    // 게시판 글 수정
    @PostMapping("/modify")
    public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
        
        service.modify(board);
        
        rttr.addFlashAttribute("result", "modify success");
        
        return "redirect:/board/list";
        
    }
    
    // 게시판 글 삭제
    @PostMapping("/delete")
    public String boardDeletePOST(int bno, RedirectAttributes rttr) {
        
        service.delete(bno);
        
        rttr.addFlashAttribute("result", "delete success");
        
        return "redirect:/board/list";
    }
}
