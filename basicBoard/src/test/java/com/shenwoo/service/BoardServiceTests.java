package com.shenwoo.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shenwoo.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
    
    @Autowired
    private BoardService service;
    
    //@Test
    public void testEnroll() {
        
        BoardVO vo = new BoardVO();
        
        vo.setTitle("service test");
        vo.setContent("service test");
        vo.setWriter("service test");
        
        service.enroll(vo);
        
    }
    
    /* 게시판 수정 */
    @Test
    public void testModify() {
        
        BoardVO board = new BoardVO();
        board.setBno(10);
        board.setTitle("수정 제목");
        board.setContent("수정 내용");
        
        int result = service.modify(board);
        log.info("result : " +result);
        
    }   
 
}
 