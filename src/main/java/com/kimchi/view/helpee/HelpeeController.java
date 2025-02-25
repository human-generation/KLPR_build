package com.kimchi.view.helpee;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helpee.HelpeeVO;
import com.kimchi.biz.helpee.impl.HelpeeDAOImpl;


/*
 * request 종류인데 하는 역할이 조금 다름
 * GET  - 서버에 ~.do를 띄우기 요청
 * POST - 입력 값을 DB에 저장 & 서버 요청
 * */

@Controller
public class HelpeeController {
	
	// 서버에 ~.do를 띄우기 요청
	@RequestMapping(value = "/helpeeWriteForm.do", method = RequestMethod.GET) //eIntro.do에서 helpeeWriteForm.do로 변경
	public String helpeeFormView(@ModelAttribute("helpee") HelpeeVO vo) {
		System.out.println("헬피-요청 글 작성 페이지로 이동 ");
		
		return "helpeeWriteForm.jsp";
	}
	
	// 입력 값을 DB에 저장 & 서버 요청
	@RequestMapping(value = "/helpeeWriteForm.do", method = RequestMethod.POST)	//eIntro.do에서 helpeeWriteForm.do로 변경
	public String helpeeForm(HelpeeVO vo, HelpeeDAOImpl helpeeDAO, HttpSession session ) {
		System.out.println("헬피-요청 글 작성 submit. DB에 저장.");
		
		helpeeDAO.insertHelpee(vo);
		
		return "main.do";
	}
}
