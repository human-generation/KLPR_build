package com.kimchi.view.mainpage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.main.MainVO;
import com.kimchi.biz.main.impl.MainDAOImpl;

@Controller
public class MainController {

	@RequestMapping(value = "/main.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String mainView(MainVO vo, MainDAOImpl MainDAO, Model model) {
		System.out.println("메인 화면으로 이동");

		// ArrayList<MainVO> list = new ArrayList<MainVO>();

		// MainDAO.selectHelperScore();
		// MainDAO.selectHelpeeScore();
		MainDAO.selectRScoreTop5();
		MainDAO.selectRTop5();
		MainDAO.selectETop5();

		model.addAttribute("RScoreTop5", MainDAO.selectRScoreTop5()); // key,value
		model.addAttribute("RTop5", MainDAO.selectRTop5());
		model.addAttribute("ETop5", MainDAO.selectETop5());

		return "main.jsp";
	}
}
