package org.zerock.notice.mapper;

import java.util.List;

import org.zerock.notice.vo.NoticeVO;

public interface NoticeMapper {
	
	// 1. 게시판 리스트
		public List<NoticeVO> list();
		
//		 1-1. 게시판 리스트의 페이지 처리를 위한 전체 데이터 갯수
		public Long getTotalRow();
		
//		 2. 게시판 글보기
		public NoticeVO view(Long no);
		
		// 2-1. 게시판 조회수 1증가
//		public int increase(Long no);
		
		// 3. 게시판 글쓰기
//		public int write(BoardVO vo);
		
		// 4. 게시판 글수정
//		public int update(BoardVO vo);
		
		// 5. 게시판 글삭제
//		public int delete(BoardVO vo);
		

}
