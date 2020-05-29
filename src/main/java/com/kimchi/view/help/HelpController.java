package com.kimchi.view.help;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;

@Controller
//@SessionAttributes("helpee")
public class HelpController {
	
	@Autowired
	private HelpeeService helpeeService;
	
	@RequestMapping(value = "/getHelpeeList.do", method = RequestMethod.GET)
	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO vo, HttpSession session) {
		System.out.println("헬피 홍보글 목록으로 이동");
		
		List<HelpeeVO> helpeeList = helpeeService.getHelpeeList(vo);
		session.setAttribute("helpeeList", helpeeList);
		System.out.println(helpeeList.toString());
		return "getHelpeeList.jsp";
	}
}
