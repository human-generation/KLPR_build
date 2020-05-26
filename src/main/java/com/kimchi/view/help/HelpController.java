package com.kimchi.view.help;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelpController {
	
	@RequestMapping(value = "/writeForm.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeFormView() {
		System.out.println("헬퍼 홍보 / 헬피 요청 글 페이지로 이동");
		
		return "writeForm.jsp";
	}
}
