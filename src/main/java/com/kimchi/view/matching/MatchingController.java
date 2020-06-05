package com.kimchi.view.matching;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kimchi.biz.matching.MatchingExtraService;
import com.kimchi.biz.matching.MatchingVOExtra;
import com.kimchi.biz.matching.Impl.MatchingDAOImpl;
import com.kimchi.biz.user.UserVO;

@Controller
@SessionAttributes("matching")
public class MatchingController {
	@Autowired
	private MatchingExtraService matchingService;

	@RequestMapping(value = "/incomingRequest.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String getBoardList(HttpSession session, Model model, Model model2) {
		UserVO vo = (UserVO) session.getAttribute("loginUser");
		System.out.println(vo.toString());

		model.addAttribute("ReceivedRequestList", matchingService.getMatchingList(vo, 1));
		model2.addAttribute("SendedRequestList", matchingService.getMatchingList(vo, 0));
		return "incomingRequest.jsp";
	}

	@RequestMapping(value = "/myPageDetailProcess.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String getBoardList(HttpSession session, Model model) {
		UserVO vo = (UserVO) session.getAttribute("loginUser");
		System.out.println(vo.toString());
		model.addAttribute("WaitingList", matchingService.getMatchingList(vo, 2));
		model.addAttribute("PaidList", matchingService.getMatchingList(vo, 3));
		model.addAttribute("EndedList", matchingService.getMatchingList(vo, 4));
		return "MyPageDetailProcess.jsp";
	}

	@RequestMapping(value = "/updateState.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String updatingState(int mstate, int mno, MatchingDAOImpl matchingDAO) {
		MatchingVOExtra mvo = new MatchingVOExtra();
		System.out.println(mno + " " + mstate);
		mvo.setMno(mno);
		mvo.setMstate(mstate);
		System.out.println(mvo.toString());
		matchingService.updateState(mvo);
		return "myPage.do";
	}

	@RequestMapping(value = "/helperSendRequest.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String helperSendRequest(MatchingVOExtra vo) {
		System.out.println("매칭테이블 insert됨. mstate=1");

		// DB에 저장
		matchingService.insertMatching(vo);
		return "myPage.do";
	}
}
