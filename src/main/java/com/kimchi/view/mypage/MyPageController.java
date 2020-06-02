package com.kimchi.view.mypage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimchi.biz.matching.MatchingExtraService;
import com.kimchi.biz.user.UserService;
import com.kimchi.biz.user.UserVO;

@Controller
public class MyPageController {

	@Autowired
	MatchingExtraService matchingService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/myPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String myPageView(HttpSession session, Model model) {
		System.out.println("마이페이지로 이동");
		UserVO user = (UserVO) session.getAttribute("loginUser");
		System.out.println(user.toString());
		model.addAttribute("userMoney", user.getMoney());
		matchingService.setMatchingState(user, model);
		return "myPage.jsp";
	}

	@RequestMapping(value = "/payment.do", method = { RequestMethod.POST })
	public String payment(HttpSession session, @RequestParam("pay") int pay, Model model) {
		UserVO vo = (UserVO) session.getAttribute("loginUser");
		System.out.println(vo.toString() + "pay=" + pay);
		System.out.println("충전완료");
		userService.updateUserMoney(vo, pay);
		int money = (Integer) session.getAttribute("userMoney") + pay;
		System.out.println(money);
		session.removeAttribute("userMoney");
		session.setAttribute("userMoney", money);
		model.addAttribute("userMoney", money);
		System.out.println(vo.toString());
		return "myPage.do";
	}

}
