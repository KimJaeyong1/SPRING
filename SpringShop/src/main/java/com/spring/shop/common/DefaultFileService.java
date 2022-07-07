package com.spring.shop.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.board.BoardRepository;
import com.spring.shop.dto.AttachDto;

@Service
public class DefaultFileService implements FileService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public AttachDto singleFileUpload(HttpServletRequest req, AttachDto attachDto, int board_id, String board_type) throws IOException {
		// MultipartFile 오브젝트를 가져와 사용하기 위해 파라미터로 받은 HttpServletRequest를 형변환하여 넣어준다
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		
		// 서버에 파일 저장 경로 
		String path = mr.getSession().getServletContext().getRealPath("resources/file");
		
		// 파일 및 디렉토리 경로 이름의 추상 표현입니다.
		File saveDir = new File(path);
		
		// 파일 경로에 폴더가 없으면 생성
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		
		// 업로드된 파일 가져오기
		MultipartFile file = mr.getFile("file");
		
		// 업로드된 원본 파일 이름 저장
		String name = file.getOriginalFilename();
		
		// 저장될 파일 이름 설정 (prefix, suffix, file directory)
		File destination = File.createTempFile("F_"+ System.currentTimeMillis(), name.substring(name.lastIndexOf(".")), saveDir);
		
		// 업로드된 파일을 복사해서 저장?
		FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(destination));
		
		// AttachDto에 setter로 데이터 저장
		attachDto.setFile_name(name); // 업로드된 파일 이름
		attachDto.setFile_size((int) file.getSize()); // 파일 크기
		attachDto.setSaved_file_name(destination.getName()); // 저장될 파일 이름
		attachDto.setBoard_id(board_id); // 업로드한 글 번호
		attachDto.setBoard_type(board_type); // 게시판 타입
		
		return attachDto;
	}
	
	@Override
	public AttachDto fileInfo(int board_id) {
		return boardRepository.fileInfo(board_id);
	}
	
	@Override
	public void deleteFile(HttpServletRequest req, int bi_no) {
		AttachDto attachDto = boardRepository.fileInfo(bi_no);
		File file = new File(req.getSession().getServletContext().getRealPath("resources/file/")+attachDto.getSaved_file_name());
		file.delete();
		}
}
