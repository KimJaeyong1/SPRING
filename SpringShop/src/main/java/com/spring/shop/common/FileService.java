package com.spring.shop.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.spring.shop.dto.AttachDto;

public interface FileService {
	AttachDto singleFileUpload(HttpServletRequest req, AttachDto attachDto, int board_id, String board_type) throws IOException;
	
	AttachDto fileInfo(int bi_no);
	
	void deleteFile(HttpServletRequest req, int bi_no);
}
