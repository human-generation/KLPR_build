package com.kimchi.view.mypage;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimchi.biz.matching.Impl.MatchingExtraDAOImpl;
import com.kimchi.biz.user.UserVO;
import com.kimchi.biz.user.impl.UserDAOImpl;

@Controller
public class MyPageController {

	@RequestMapping(value = "/myPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String myPageView(HttpSession session) {
		System.out.println("마이페이지로 이동");
		if (session.getAttribute("userMoney") != null)
			session.removeAttribute("userMoney");
		UserVO user = (UserVO) session.getAttribute("loginUser");
		System.out.println(user.toString());
		MatchingExtraDAOImpl matchingDAO = new MatchingExtraDAOImpl();
		matchingDAO.setMatchingState(user, session);
		session.setAttribute("userMoney", user.getMoney());
		return "myPage.jsp";
	}

	@RequestMapping(value = "/payment.do", method = { RequestMethod.POST })
	public String payment(UserDAOImpl userDAO, HttpSession session, @RequestParam("pay") int pay) {
		UserVO vo = (UserVO) session.getAttribute("loginUser");
		System.out.println(vo.toString() + "pay=" + pay);
		System.out.println("충전완료");
		userDAO.updateUserMoney(vo, pay);
		session.setAttribute("loginUser", vo);
		System.out.println(vo.toString());
		return "myPage.do";
	}

}
