package org.zerock.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.board.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
@Qualifier("bsi")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		
		log.info("list() +++++++++++++++++++++++++");
		return mapper.list(); 
	}

	@Override
	public BoardVO view(Long no) throws Exception {
		// TODO Auto-generated method stub

		log.info("view() +++++++++++++++++++++++++");
		return mapper.view(no); 
	}
	
	

}
