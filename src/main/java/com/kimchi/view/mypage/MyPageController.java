package com.kimchi.view.mypage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimchi.biz.matching.MatchingService;
import com.kimchi.biz.user.UserVO;
import com.kimchi.biz.user.impl.UserDAOImpl;

@Controller
public class MyPageController {
	@Autowired
	private MatchingService matchingService;
	
	@RequestMapping(value="/incomingRequest.do", method= {RequestMethod.POST})
	public String getBoardList(UserVO vo, Model model, Model model2) {
		model.addAttribute("ReceivedRequestList", matchingService.getMatchingList(vo,1));
		model2.addAttribute("SendedRequestList", matchingService.getMatchingList(vo,0));
		return "incomingRequest.jsp"; 
	}
	
	@RequestMapping(value="/payment.do", method= {RequestMethod.POST} )
	public String payment(UserDAOImpl userDAO, HttpSession session, @RequestParam("pay")int pay) {
		UserVO vo=(UserVO)session.getAttribute("loginUser");
		System.out.println(vo.toString()+"pay="+pay);
		System.out.println("충전완료");
		userDAO.updateUserMoney(vo, pay);
		System.out.println(vo.toString());
		return "myPage.do";
	}
}
