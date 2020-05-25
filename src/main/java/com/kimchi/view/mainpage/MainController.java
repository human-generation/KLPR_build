package com.kimchi.view.mainpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/main.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String mainView() {
		System.out.println("메인 화면으로 이동");

		return "main.jsp";
	}
}
