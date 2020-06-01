package com.kimchi.view.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PagesController {
	@RequestMapping(value = "/summary.do", method = RequestMethod.GET)
	public String summaryPageView() {
		System.out.println("서비스 개요로 이동");
		return "summary.jsp";
	}

	@RequestMapping(value = "/faq.do", method = RequestMethod.GET)
	public String faqPageView() {
		System.out.println("FAQ로 이동");
		return "faq.jsp";
	}

	@RequestMapping(value = "/payment.do", method = RequestMethod.GET)
	public String paymentView() {
		System.out.println("결제페이지로 이동");
		return "payment.jsp";
	}

	@RequestMapping(value = "/alert.do", method = RequestMethod.GET)
	public String alertView() {
		System.out.println("알람 드롭다운 이동");
		return "alert.jsp";
	}
}
