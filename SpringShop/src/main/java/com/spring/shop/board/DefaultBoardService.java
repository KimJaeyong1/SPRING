package com.spring.shop.board;

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
import com.spring.shop.dto.BoardDetailResponseDto;
import com.spring.shop.dto.BoardDto;
import com.spring.shop.dto.BoardResponseDto;
import com.spring.shop.dto.SearchDto;

@Service
public class DefaultBoardService implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager; 
	
	// 페이징에 필요한 데이터 처리
	@Override
	public BoardResponseDto list(SearchDto searchDto) {
		int totalCnt = boardRepository.getTotalCnt(searchDto);
		
		float limit = ((searchDto.getCurPage() - 1) * searchDto.getPagePerCnt()) + searchDto.getPagePerCnt();
		float offset = (searchDto.getCurPage() - 1) * searchDto.getPagePerCnt();
	
		searchDto.setTotalCnt(totalCnt);
		searchDto.setLimit(limit);
		searchDto.setOffset(offset);
		
		List<BoardDto> list = boardRepository.list(searchDto);
		
		return BoardResponseDto.create(list, searchDto);
	}
	
	// 글 작성 + 파일 업로드
	@Override
	public int write(BoardDto boardDto, HttpServletRequest req, AttachDto attachDto) throws IOException {
		// 데이터베이스를 변경시키는 명력이 모두 성공해야지만 커밋 아니면 롤백
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		try {
			boardRepository.write(boardDto); // 명령 1 (글 내용 db에 저장)
			
			attachDto = fileService.singleFileUpload(req, attachDto, boardDto.getBi_no(), "NOTICE");
			
			boardRepository.upload(attachDto); // 명령 2 (업로드 파일 정보 db에 저장)
			
			platformTransactionManager.commit(status); // 커밋
			
			return 1;
		} catch (Exception e) {
			platformTransactionManager.rollback(status); // 롤백
			File file = new File(
					req.getSession().getServletContext().getRealPath("resources/file/")+attachDto.getSaved_file_name()
				);
			file.delete(); // 실패하면 경로에 저장된 파일 이름 찾아서 파일 삭제
			return 0;
		}
	}
	
	// 글 수정 + 업로드 파일 수정
	@Override
	public BoardDetailResponseDto modify(BoardDto boardDto, HttpServletRequest req, AttachDto attachDto) throws IOException {
		TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionAttribute());
		
		try {
			
			// 수정
			// 1. 파일 있어
			//	- 기존 파일 삭제 ( db 랑 서버랑)
			//	- 파일 서비스의 업로드 호출
			
			// 2. 파일 없어
			//	- 그냥 수정만
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
			MultipartFile file = mr.getFile("file");
			
			if(!file.isEmpty()) {
				fileService.deleteFile(req, boardDto.getBi_no());
				attachDto = fileService.singleFileUpload(req, attachDto, boardDto.getBi_no(), "NOTICE");
				
				boardRepository.deleteFile(boardDto.getBi_no());
				boardRepository.upload(attachDto);
			}
			
			boardRepository.modify(boardDto);
			boardDto = boardRepository.getPage(boardDto.getBi_no());
			
			platformTransactionManager.commit(status);
			return BoardDetailResponseDto.create(boardDto, attachDto);
		} catch (Exception e) {
			platformTransactionManager.rollback(status);
			e.printStackTrace();
			File file = new File(
					req.getSession().getServletContext().getRealPath("resources/file/")+attachDto.getSaved_file_name()
				);
			file.delete();
			return null;
		}
	}
	
	@Override
	public BoardDto getPage(int bi_no) {
		return boardRepository.getPage(bi_no);
	}
	
	@Override
	public int remove(BoardDto boardDto) {
		return boardRepository.remove(boardDto);
	}
	
	@Override
	public void hit(int bi_no) {
		boardRepository.hit(bi_no);
	}
	
	@Override
	public AttachDto fileInfo(int bi_no) {
		return boardRepository.fileInfo(bi_no);
	}
	
	@Override
	public List<BoardDto> mainBoardList() {
		return boardRepository.mainBoardList();
	}
}
