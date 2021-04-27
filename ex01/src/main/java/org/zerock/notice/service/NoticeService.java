package org.zerock.notice.service;

import java.util.List;

import org.zerock.notice.vo.NoticeVO;

public interface NoticeService {
	
	
	// 1. 공지사항 리스트
	// [전체 데이터 갯수 가져오기 ]+ 리스트 데이터 가져오기
	public List<NoticeVO> list() throws Exception;
	
	// 2. 공지사항 글보기
	public NoticeVO view(Long no) throws Exception;
	// 3. 공지사항 글쓰기
//	public int write(NoticeVO vo) throws Exception;
	// 4. 공지사항 글수정
//	public int update(NoticeVO vo) throws Exception;
	// 5. 공지사항 글삭제
//	public int delete(NoticeVO vo) throws Exception;


}
