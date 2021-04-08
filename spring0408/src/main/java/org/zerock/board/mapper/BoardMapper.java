package org.zerock.board.mapper;

import java.util.List;

import org.zerock.board.vo.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> list() throws Exception;

	public BoardVO view(Long no);

}
