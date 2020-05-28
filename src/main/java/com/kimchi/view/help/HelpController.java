package com.kimchi.view.help;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helpee.HelpeeVO;
import com.kimchi.biz.helpee.impl.HelpeeDAOImpl;
import com.kimchi.biz.helpee.impl.HelpeeServiceImpl;

@Controller
//@SessionAttributes("helpee")
public class HelpController {
	
//	@RequestMapping(value = "/getHelpeeList.do", method = RequestMethod.GET)
//	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO vo, HelpeeDAOImpl helpeeDAO, HttpSession session) {
//		System.out.println("헬피 홍보글 목록으로 이동");
//		
//		List<HelpeeVO> helpeeList = helpeeDAO.getHelpeeList(vo);
//		session.setAttribute("helpeeList", helpeeList);
//		System.out.println(helpeeList.toString());
//		return "getHelpeeList.jsp";
//	}
	
	@RequestMapping(value = "/getHelpeeList.do", method = RequestMethod.GET)
	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO vo, HelpeeServiceImpl helpeeDAO, HttpSession session) {
		System.out.println("헬피 홍보글 목록으로 이동");
		
		List<HelpeeVO> helpeeList = helpeeDAO.getHelpeeList(vo);
		System.out.println("helpeeList : " + helpeeList);
		System.out.println(helpeeList.toString());
		session.setAttribute("helpeeList", helpeeList);
		
		return "getHelpeeList.jsp";
	}
}
