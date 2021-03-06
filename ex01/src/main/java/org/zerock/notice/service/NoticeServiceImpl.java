package org.zerock.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zerock.notice.mapper.NoticeMapper;
import org.zerock.notice.vo.NoticeVO;


// 자동 생성
@Service
// 타입이 같은 객체들이 많은 경우 선택할 수 있도록 지정
@Qualifier("bsi")
public class NoticeServiceImpl implements NoticeService {
	
	// mapper를 이용해서 DB처리해야한다.
	// 자동 DI 적용 - @Setter : lombok, @Autowired: spring, @Inject : java
	@Inject
	private NoticeMapper mapper;

	@Override
	public List<NoticeVO> list() throws Exception {
		// TODO Auto-generated method stub
		// 페이지 처리를 위한 전체 데이터 가져오기 - 추후
		return mapper.list();
	}
 
	@Override
	public NoticeVO view(Long no) throws Exception {
		// TODO Auto-generated method stub
		// list -> view : inc = 1 - 조회수 1증가
		return mapper.view(no);
	}
//
//	@Override
//	public int write(NoticeVO vo) throws Exception {
//		// TODO Auto-generated method stub
//		return  mapper.write(vo);
//	}
//
//	@Override
//	public int update(NoticeVO vo) throws Exception {
//		// TODO Auto-generated method stub
//		return  mapper.update(vo);
//	}
//
//	@Override
//	public int delete(NoticeVO vo) throws Exception {
//		// TODO Auto-generated method stub
//		return  mapper.delete(vo);
//	}

}
