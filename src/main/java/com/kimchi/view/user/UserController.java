package com.kimchi.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.user.UserService;
import com.kimchi.biz.user.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		return "main.do";
	}

<<<<<<< HEAD
	@RequestMapping(value = "/login.do", method =  {RequestMethod.GET, RequestMethod.POST})
	public String login(UserVO vo, UserDAOImpl userDAO, HttpSession session) {
=======
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
		System.out.println("로그인 인증 처리");

		if (vo.getEmail() == null || vo.getEmail() == "") {
			throw new IllegalArgumentException("이메일 반드시 입력해야 됩니다.");
		}
<<<<<<< HEAD
		System.out.println(vo.toString());
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			session.setAttribute("loginUser", user);
			//session.setAttribute("userMoney", user.getMoney());
			System.out.println(user.getName());
			
=======

		UserVO user = userService.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			session.setAttribute("userNumber", user.getUno());
			session.setAttribute("userMoney", user.getMoney());
			session.setAttribute("userGender", user.getGender());
			session.setAttribute("userPhone", user.getPhone());
			session.setAttribute("loginUser", user);
			System.out.println(user.toString());
>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
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
	public String join(UserVO vo) {
		System.out.println(vo.toString());
		if (vo.getEmail() == null) {
			System.out.println("회원가입 화면으로 이동");
			return "main.do";
		} else {
			System.out.println("회원가입 됨. DB에 저장.");
			// DB에 저장
			userService.insertUser(vo);
			return "main.do";
		}
	}
}
