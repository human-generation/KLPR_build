package com.kimchi.view.helpee;

import java.util.List;

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
//@SessionAttributes("helpee")
public class HelpeeController {
	
	@RequestMapping(value = "/getHelpeeList.do", method = RequestMethod.GET)
	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO vo, HelpeeDAOImpl helpeeDAO, HttpSession session) {
		System.out.println("헬피 홍보글 목록으로 이동");
		
		List<HelpeeVO> helpeeList = helpeeDAO.getHelpeeList(vo);
		session.setAttribute("helpeeList", helpeeList);
		System.out.println(helpeeList.toString());
		return "getHelpeeList.jsp";
	}
}
