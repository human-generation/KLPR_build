package com.kimchi.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.user.UserVO;
import com.kimchi.biz.user.impl.UserDAOMybatis;

@Controller
public class UserController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		return "main.do";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAOMybatis userDAO, HttpSession session) {
		System.out.println("로그인 인증 처리");

		if (vo.getEmail() == null || vo.getEmail() == "") {
			throw new IllegalArgumentException("이메일 반드시 입력해야 됩니다.");
		}

		System.out.println(vo.toString());
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			System.out.println(user.getName());
//			return "getMain.do";
			return "main.do";
		} else {
			return "main.do";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");

		session.invalidate();
		return "main.do";
	}

	@RequestMapping(value = "/join.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(UserVO vo, UserDAOMybatis userDAO) {
		System.out.println(vo.toString());
		if (vo.getEmail() == null) {
			System.out.println("회원가입 화면으로 이동");
			return "main.do";
		} else {
			System.out.println("회원가입 됨. DB에 저장.");
			// DB에 저장
			userDAO.insertUser(vo);
			return "main.do";
		}
	}
}
