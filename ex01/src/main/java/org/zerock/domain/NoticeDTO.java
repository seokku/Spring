package org.zerock.domain;

import java.sql.Date;

//import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

// NoticeDTO = NoticeVO
@Data
public class NoticeDTO {
	
	private Long no;
	private String title, content;
	// 날짜 입력할 때만 해당이 된다.
	// 화면의 날짜 형식이 String으므로 날짜 형식에 맞지 않아서 형식은 맞춰서 입력을 받아야 오류가 나지 않는다.
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate; 
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private Date writeDate;
	private Date updateDate;

}
