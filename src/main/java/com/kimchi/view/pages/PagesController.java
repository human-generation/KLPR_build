package com.kimchi.view.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.matching.MatchingVO;
import com.kimchi.biz.matching.impl.MatchingDAOImpl;
import com.kimchi.biz.user.UserVO;
import com.kimchi.biz.user.impl.UserDAOImpl;

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

	@RequestMapping(value = "/myPage.do", method = RequestMethod.GET)
	public String myPageView() {
		System.out.println("마이페이지로 이동");
		return "myPage.jsp";
	}

	@RequestMapping(value = "/alert.do", method = RequestMethod.GET)
	public String alertView() {
		System.out.println("알람 드롭다운 이동");
		return "alert.jsp";
	}

	@RequestMapping(value = "/matchInsert.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String matchingView(MatchingVO vo, MatchingDAOImpl matchingDAO) {
		if (vo.getEno() == 0) {
			System.out.println("매칭 인서트 화면 이동");
			return "matchingInsert.jsp";
		} else {
			// DB에 저장
			System.out.println("매칭 됨. DB에 저장.");
			matchingDAO.insertMatching(vo);
			return "main.do";
		}

	}
}
