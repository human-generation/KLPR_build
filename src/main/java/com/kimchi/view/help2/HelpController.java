package com.kimchi.view.help2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helpee.HelpeePRVO;
import com.kimchi.biz.helpee.impl.HelpeePRDAOImpl;


/*
 * request 종류인데 하는 역할이 조금 다름
 * GET  - 서버에 ~.do를 띄우기 요청
 * POST - 입력 값을 DB에 저장 & 서버 요청
 * */

@Controller
public class HelpController {
	
	// 서버에 ~.do를 띄우기 요청
	@RequestMapping(value = "/eIntro.do", method = RequestMethod.GET)
	public String IntroForm(@ModelAttribute("helpee") HelpeePRVO vo) {
		System.out.println("move to eIntro page");
		
		return "eIntro.jsp";
	}
	
	// 입력 값을 DB에 저장 & 서버 요청
	@RequestMapping(value = "/eIntro.do", method = RequestMethod.POST)
	public String IntroPosting(HelpeePRVO vo, HelpeePRDAOImpl eprDAO) {
		eprDAO.insertEPR(vo);
		
		return "main.do";
	}
}
