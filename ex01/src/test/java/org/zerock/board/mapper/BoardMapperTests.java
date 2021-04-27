package org.zerock.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.vo.BoardVO;

import com.webjjang.util.PageObject;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	// 자동 DI
	@Setter(onMethod_ =@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testList() {
		log.info(mapper);
		log.info(mapper.list(new PageObject()));
		
	}
	
	@Test
	public void testwrite() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("test title");
		vo.setContent("test content");
		vo.setWriter("test");
		vo.setPw("1111");
		
//		log.info(mapper.list());
		log.info(mapper.write(vo)); // 1, 0 값으로 성공,실패 여부도 뜸
		
	}

}
