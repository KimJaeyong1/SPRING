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
	
	// 게시판 목록
    @GetMapping("/list")
    public void boardListGET(Model model, Criteria cri) {
        
    	log.info("========== 게시판 글 목록 페이지 입장 ==========");
        
        model.addAttribute("list", service.getListPaging(cri));
        
        int total = service.getTotal(cri);
        
        PageMakerDTO pageMake = new PageMakerDTO(cri, total);
        
        model.addAttribute("pageMaker", pageMake);
        
    }  
	
	// 게시판 글 등록 페이지 접속
	@GetMapping("/register")
	public void boardRegisterGET() {
		
		log.info("========== 게시판 글 등록 페이지 입장 ==========");
	}
	
	 // 게시판 글 등록
    @PostMapping("/register")
    public String boardRegisterPOST(BoardVO board, RedirectAttributes rttr) {
    	
    	log.info("========== 게시판 글 등록 ==========");
        
        log.info("BoardVO : " + board);
        
        service.register(board);
        
        rttr.addFlashAttribute("result", "enroll success");
        
        return "redirect:/board/list";
    }
    
    // 게시판 글 조회
    @GetMapping("/get")
    public void boardGetPageGET(int bno, Model model, Criteria cri) {
    	
    	log.info("========== 게시판 " +bno+ " 글 조회 페이지 입장 ==========");
    	
    	model.addAttribute("pageInfo", service.getPage(bno));
    	
    	model.addAttribute("cri", cri);
    }
    
    // 게시판 글 수정
    @GetMapping("/modify")
    public void boardModifyGET(int bno, Model model, Criteria cri) {
    	
    	log.info("========== 게시판 " +bno+ " 글 수정 페이지 입장 ==========");
        
        model.addAttribute("pageInfo", service.getPage(bno));
        
        model.addAttribute("cri", cri);
        
    }
    
    // 게시판 글 수정
    @PostMapping("/modify")
    public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
        
    	log.info("========== 게시판 글 수정 ==========");
    	
        service.modify(board);
        
        rttr.addFlashAttribute("result", "modify success");
        
        return "redirect:/board/list";
        
    }
    
    // 게시판 글 삭제
    @PostMapping("/delete")
    public String boardDeletePOST(int bno, RedirectAttributes rttr) {
    	
    	log.info("========== 게시판 " +bno+ " 글 삭제 ==========");
        
        service.delete(bno);
        
        rttr.addFlashAttribute("result", "delete success");
        
        return "redirect:/board/list";
    }
}
