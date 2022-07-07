package com.spring.shop.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shop.dto.AttachDto;
import com.spring.shop.dto.BoardDetailResponseDto;
import com.spring.shop.dto.BoardDto;
import com.spring.shop.dto.BoardResponseDto;
import com.spring.shop.dto.SearchDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 공지사항 게시판 페이지
	@RequestMapping("/board/notice")
	public String noticeBoard(Model model) {
		model.addAttribute("content", "board/notice.jsp");
		
		return "home";
	}
	
	// ajax 공지사항 게시판 리스트
	@RequestMapping(value = "/board/getNoticeList", method = RequestMethod.GET)
	@ResponseBody
	public BoardResponseDto getNoticeList(SearchDto searchDto) {
		return boardService.list(searchDto);
	}
	
	// 글 작성 페이지
	@RequestMapping("/board/write")
	public String writelPage(Model model) {
		model.addAttribute("content", "board/write.jsp");
		
		return "home";
	}
	
	// 글 작성 실행
	@RequestMapping("/write")
	public String boardWrite(Model model, BoardDto boardDto, HttpServletRequest req, AttachDto attachDto) throws IOException {
		int result = boardService.write(boardDto, req, attachDto);
		
		if(result == 1) {
			model.addAttribute("noticeWrite", result);
			model.addAttribute("MSG", "글 등록 완료");
			model.addAttribute("content", "board/notice.jsp");
		}
		return "home";
	}
	
	// 글 상세 페이지
	@RequestMapping(value="/board/page", method = RequestMethod.GET)
	public String getPage(Model model, @RequestParam("bi_no") int bi_no, AttachDto attachDto) {
		BoardDto data = boardService.getPage(bi_no);
		AttachDto uploadData = boardService.fileInfo(bi_no);
		BoardDetailResponseDto dto = BoardDetailResponseDto.create(data, uploadData);
		boardService.hit(bi_no);
		
		model.addAttribute("dto", dto);
		model.addAttribute("content", "board/page.jsp");
		
		return "home";
	}
	
	// 글 수정 페이지
	@RequestMapping(value="/board/modify", method = RequestMethod.GET)
	public String modifyPage(Model model, int bi_no) {
		BoardDto data = boardService.getPage(bi_no);
		AttachDto uploadData = boardService.fileInfo(bi_no);
		BoardDetailResponseDto dto = BoardDetailResponseDto.create(data, uploadData);
		
		model.addAttribute("dto", dto);
		model.addAttribute("content", "board/modify.jsp");
		
		return "home";
	}
	
	// 글 수정 실행
	@RequestMapping("/modify")
	public String boardModify(Model model, BoardDto boardDto, HttpServletRequest req, AttachDto attachDto) throws IOException {
		BoardDetailResponseDto dto = boardService.modify(boardDto, req, attachDto);
		
		if(dto != null) {
			model.addAttribute("MSG", "글 수정 완료");
			model.addAttribute("dto", dto);
		}
		model.addAttribute("content", "board/page.jsp");
		return "home";
	}
	
	// 글 삭제 실행
	@RequestMapping("/remove")
	public String boardDelete(Model model, BoardDto boardDto) {
		int result = boardService.remove(boardDto);
		
		if(result == 1) {
			model.addAttribute("MSG", "글 삭제 완료");
			model.addAttribute("content", "board/notice.jsp");
		}
		return "home";
	}
}