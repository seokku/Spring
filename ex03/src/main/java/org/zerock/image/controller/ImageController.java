package org.zerock.image.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.image.service.ImageService;
import org.zerock.image.vo.ImageVO;
import org.zerock.member.vo.LoginVO;

import com.webjjang.util.PageObject;
import com.webjjang.util.file.FileUtil;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/image")
@Log4j
public class ImageController {
	
	private final String MODULE = "image";
	@Autowired
	@Qualifier("isi")
	private ImageService service;
	
	// 1. 이미지 겔러리 리스트

	@GetMapping("/list.do")
	public String list(@ModelAttribute PageObject pageObject, Model model, HttpSession session) 
	throws Exception {
		
	if(pageObject.getPerPageNum() == 10)
	pageObject.setPerPageNum(8);
	
	log.info("list().pageObject : " + pageObject);
	
	// 강제 로그인 시킨다.
	LoginVO vo = new LoginVO();
	vo.setId("test");
	vo.setGradeNo(1);
	session.setAttribute("login", vo);
	
	
	model.addAttribute("list", service.list(pageObject));

	//jsp의 정보 리턴
	return MODULE + "/list";
	}
	
	// 2. 이미지 보기
	@GetMapping("/view.do")
	public String view(Long no, @ModelAttribute PageObject pageObject,
			Model model) throws Exception {
		
		log.info("view().no : " + no);
		
		model.addAttribute("vo", service.view(no));
		
		//jsp의 정보 리턴
		return MODULE + "/view";
	}
	
	// 3. 이미지 등록 폼
	@GetMapping("/write.do") 
	public String writeForm() {
		
		log.info("writeForm() .........");
		
		return MODULE + "/write";
	}
	
	// 3-1. 이미지 등록 처리
	@PostMapping("/write.do") 
	public String write(ImageVO vo, Long perPageNum, HttpSession session, HttpServletRequest request) throws Exception {
		
		log.info("write()......이미지 등록에서 새로고침을 하지 마시고 리스트에서 새로고침해서 들어오세요.(세션)");
		
		// 저장할 위치 - 운영되는 서버에서 부터 찾는 상대 위치
		String path = "/upload/image/";
		
		// 실제적으로 저장이 되는 위치
		String realPath = request.getServletContext().getRealPath(path);
		
		log.info("realPath : " + realPath);
		
		LoginVO loginVO = (LoginVO)session.getAttribute("login");
		
		log.info("loginVO : " + loginVO);
		
		// 전달 받지 않는 데이터의 수집
		vo.setId(loginVO.getId());
		String fileName = vo.getMultipartFile().getOriginalFilename();
		File imageFile = FileUtil.noDuplicate(realPath + fileName);
		vo.setFileName(path + imageFile.getName());
		
		log.info("write().vo ........." + vo);
//		log.info("write().vo.getMultipartFile.name ........."
//		+ vo.getMultipartFile().getOriginalFilename());
		
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
	
		// 중복된 파일에 대한 처리 - 중복이 되지 않는 파일 객체를 리턴해 준다.
		public static File noDuplicate(String fileFullName) {
		
		return null;
		
	}

}
