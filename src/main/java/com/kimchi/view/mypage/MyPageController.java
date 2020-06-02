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

	@RequestMapping(value="/payment.do", method= {RequestMethod.POST} )
	public String payment(UserDAOImpl userDAO, HttpSession session, @RequestParam("pay")int pay) {
		UserVO vo=(UserVO)session.getAttribute("loginUser");
		System.out.println(vo.toString()+"pay="+pay);
		System.out.println("충전완료");
		userDAO.updateUserMoney(vo, pay);
		session.setAttribute("loginUser", vo);
		System.out.println(vo.toString());
		return "myPage.do";
	}

}
