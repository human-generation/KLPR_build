package com.kimchi.view.e_review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.e_review.E_ReviewService;
import com.kimchi.biz.e_review.E_ReviewVO;

@Controller
public class E_ReviewController {

	@Autowired
	private E_ReviewService e_reviewService;

	@RequestMapping(value = "/insertE_Review.do", method = RequestMethod.GET)
	public String insertE_ReviewView(E_ReviewVO vo) {
		System.out.println("E_ReivewController의 insertE_ReviewView() 실행");
		System.out.println("헬피에게 쓰는 리뷰창이 보일겁니다.");
		return "MyPageDetailProcess.jsp";
	}

	@RequestMapping(value = "/insertE_Review.do", method = RequestMethod.POST)
	public String insertE_Review(E_ReviewVO vo) {
		System.out.println("E_ReivewController의 insertE_Review() 실행");

		// DB에 저장
		e_reviewService.insertE_Review(vo);
		System.out.println("헬퍼가 헬피에 쓴 리뷰가 저장됐습니다.");
		return "myPage.do";
	}
}
