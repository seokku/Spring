package org.zerock.notice.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeVO {
	
	private Long no;
	private String title;
	private String content;
	private String writer;
	private Date startDate;
	private Date endDate;
	private Date writeDate;
	private Date updateDate;
	

}
