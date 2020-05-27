package com.kimchi.view.r_review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.r_review.R_reviewVO;
import com.kimchi.biz.r_review.impl.R_reviewDAOImpl;

@Controller
public class R_reviewController {

	
	@RequestMapping(value = "/r_review.do", method =  { RequestMethod.GET, RequestMethod.POST })
	public String r_review(R_reviewVO vo, R_reviewDAOImpl r_reviewDAO) {
		
		r_reviewDAO.insertR_review(vo);
		return "mypage.jsp";
	}
	
	
}
