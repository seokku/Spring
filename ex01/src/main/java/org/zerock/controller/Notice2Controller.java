package org.zerock.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.NoticeDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/notice")
@Log4j
public class Notice2Controller {
	
	// /notice/write
	@GetMapping("/write")
	public void write(NoticeDTO dto) {
		
		log.info("dto : " + dto);
		log.info("dto : " + dto.getStartDate());
		log.info("dto type : " + (dto.getStartDate() instanceof Date));
	}

}
