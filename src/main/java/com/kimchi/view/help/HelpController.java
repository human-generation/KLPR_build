package com.kimchi.view.help;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.helper.impl.HelperDAOImpl;

@Controller
public class HelpController {
	
	@RequestMapping(value = "/writeForm.do", method = {RequestMethod.GET})
	public String writeFormView(@ModelAttribute("helper") HelperVO vo) {
		System.out.println("헬퍼-홍보 글 작성 페이지로 이동");
		
		return "helperWriteForm.jsp";
	}
	
	@RequestMapping(value = "/writeForm.do", method = {RequestMethod.POST})
	public String writeForm(HelperVO vo, HelperDAOImpl helperDAO, HttpSession session) {
		System.out.println("헬퍼-홍보 글 작성 submit. DB에 저장.");
		
		//DB에 저장
		
		helperDAO.insertHelper(vo);
		return "main.do";
	}
	
	
	

}
