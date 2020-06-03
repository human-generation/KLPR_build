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
import com.kimchi.biz.seoul.SeoulVO;

@Controller
//@SessionAttributes("helpee")
public class HelpController {

	@Autowired
	private HelpeeService helpeeService;

	// 전체 헬피 목록 출력
	@RequestMapping(value = "/getHelpeeList.do", method = RequestMethod.GET)
	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo, @ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("헬피 홍보글 목록으로 이동");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.getHelpeeList(hvo));

		return "getHelpeeList.jsp";
	}

	// 헬피글 최신순 정렬
	@RequestMapping(value = "/recentHelpeeList.do", method = RequestMethod.GET)
	public String recentHelpeeList(@ModelAttribute("helpee") HelpeeVO hvo, E_ReviewVO evo, @ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("헬피 홍보글 최신순 목록으로 이동");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.recentHelpeeList(hvo));
		return "getHelpeeList.jsp";
	}
	
	// 이사 헬피 리스트
	@RequestMapping(value = "/moveHelpee.do", method = RequestMethod.GET)
	public String moveHelpee(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo, @ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("이사 서비스 헬피 목록 출력");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.moveHelpee(hvo));
		return "getHelpeeList.jsp";
	}
	
	// 병원 헬피 리스트
	@RequestMapping(value = "/hospitalHelpee.do", method = RequestMethod.GET)
	public String hospitalHelpee(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo, @ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("이사 서비스 헬피 목록 출력");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.hospitalHelpee(hvo));
		return "getHelpeeList.jsp";
	}
	
	// 출입국 헬피 리스트
	@RequestMapping(value = "/immigrationHelpee.do", method = RequestMethod.GET)
	public String immigrationHelpee(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo, @ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("이사 서비스 헬피 목록 출력");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.immigrationHelpee(hvo));
		return "getHelpeeList.jsp";
	}
	
	// 지역별 헬피 리스트
	@RequestMapping(value = "/seoulHelpeeList.do", method = RequestMethod.GET)
	public String seoulHelpeeList(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo, @ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("이사 서비스 헬피 목록 출력");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.seoulHelpeeList(hvo));
		return "getHelpeeList.jsp";
	}
	
}
