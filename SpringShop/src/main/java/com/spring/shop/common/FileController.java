package com.spring.shop.common;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shop.dto.AttachDto;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	// 첨부 파일 다운로드
	@RequestMapping(value="/board/fileDownload", method=RequestMethod.GET)
	public void downloadFile(@RequestParam("board_id") int board_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 파일 업로드 경로
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/file/");
		
		// SQL 실행
		AttachDto file = fileService.fileInfo(board_id);
		
		// 저장된 파일이름 불러오기
		String saveFileName = file.getSaved_file_name();
		
		// 저장된 파일 원본 이름 불러오기
		String originalFileName = file.getFile_name();
		
		// 파일 업로드 경로 + 저장된 파일 이름
		File downloadFile = new File(uploadPath + saveFileName);
		
		if(downloadFile.exists()) {
			// 파일을 바이트 배열로 변환?
			byte fileByte[] = FileUtils.readFileToByteArray(downloadFile);
			
			response.setContentType("application/octer-stream");
			response.setContentLength(fileByte.length);
			
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} else {
			response.sendRedirect("/board/notice");
		}
	}
	
	// 첨부 파일 삭제
	@RequestMapping(value="/fileDelete", method = RequestMethod.GET)
	@ResponseBody
	public int deleteFile(HttpServletRequest req, Model model, int bi_no) {
		fileService.deleteFile(req, bi_no);
		model.addAttribute("content", "board/modify.jsp?bi_no="+bi_no);
		return 1;
	}
}
