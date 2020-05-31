package com.kimchi.view.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimchi.biz.matching.MatchingVOExtra;
import com.kimchi.biz.matching.Impl.MatchingDAOImpl;
import com.kimchi.biz.user.UserVO;
import com.kimchi.biz.user.impl.UserDAOImpl;

@Controller
public class MyPageController {
//	@Autowired
//	private MatchingService matchingService;
	
	@RequestMapping(value="/incomingRequest.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String getBoardList(HttpSession session, Model model, Model model2, MatchingDAOImpl matchingDAO) {
		UserVO vo=(UserVO)session.getAttribute("loginUser");
		System.out.println(vo.toString());
		
		model.addAttribute("ReceivedRequestList", matchingDAO.getMatchingList(vo,1));
		model2.addAttribute("SendedRequestList", matchingDAO.getMatchingList(vo,0));
		return "incomingRequest.jsp"; 
	}
	
	@RequestMapping(value="/ongoing.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String getBoardList(HttpSession session, Model model, MatchingDAOImpl matchingDAO) {
		UserVO vo=(UserVO)session.getAttribute("loginUser");
		System.out.println(vo.toString());
		model.addAttribute("WaitingList", matchingDAO.getMatchingList(vo,2));
		model.addAttribute("PaidList", matchingDAO.getMatchingList(vo,3));
		model.addAttribute("EndedList", matchingDAO.getMatchingList(vo,4));
		return "ongoing.jsp"; 
	}
	
	@RequestMapping(value="/payment.do", method= {RequestMethod.POST,RequestMethod.GET} )
	public String payment(UserDAOImpl userDAO, HttpSession session, @RequestParam("pay")int pay) {
		UserVO vo=(UserVO)session.getAttribute("loginUser");
		System.out.println(vo.toString()+"pay="+pay);
		System.out.println("충전완료");
		userDAO.updateUserMoney(vo, pay);
		System.out.println(vo.toString());
		return "myPage.do";
	}
	
	@RequestMapping(value="/updateState.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String updatingState(MatchingVOExtra mvo, MatchingDAOImpl matchingDAO) {
		System.out.println(mvo.toString());
		matchingDAO.updateState(mvo);
		return "myPage.do";
	}
}
