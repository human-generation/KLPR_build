package com.kimchi.view.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.e_review.E_ReviewVO;
import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;

@Controller
//@SessionAttributes("helpee")
public class HelpController {

	@Autowired
	private HelpeeService helpeeService;

	// 전체 헬피 목록 출력
	@RequestMapping(value = "/getHelpeeList.do", method = RequestMethod.GET)
	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO hvo, E_ReviewVO evo, Model model) {
		System.out.println("헬피 홍보글 목록으로 이동");
		model.addAttribute("countList", helpeeService.getReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.getHelpeeList(hvo));

		return "getHelpeeList.jsp";
	}

	// 헬피글 최신순 정렬
	@RequestMapping(value = "/recentHelpeeList.do", method = RequestMethod.GET)
	public String recentHelpeeList(@ModelAttribute("helpee") HelpeeVO hvo, E_ReviewVO evo, Model model) {
		System.out.println("헬피 홍보글 최신순 목록으로 이동");
		model.addAttribute("countList", helpeeService.getReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.recentHelpeeList(hvo));
		return "getHelpeeList.jsp";
	}
}
