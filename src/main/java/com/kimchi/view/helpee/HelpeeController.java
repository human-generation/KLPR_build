package com.kimchi.view.helpee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.e_review.E_ReviewVO;
import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

@Controller
public class HelpeeController {

	@Autowired
	private HelpeeService helpeeService;

	// 전체 헬피 목록 출력
	@RequestMapping(value = "/getHelpeeList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo,
			@ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("헬피 홍보글 목록으로 이동");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.getHelpeeList(hvo));

		return "getHelpeeList.jsp";
	}

	// 헬피 요청 글 작성 폼
	@RequestMapping(value = "/helpeeWriteForm.do", method = RequestMethod.GET)
	public String helpeeFormView(@ModelAttribute("helpee") HelpeeVO vo, @ModelAttribute("language") LanguageVO lvo,
			@ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("헬피-요청 글 작성 페이지로 이동");

		List<LanguageVO> languageList = helpeeService.getLanguageList(lvo);
		model.addAttribute("languageList", languageList);

		List<SeoulVO> seoulList = helpeeService.getSeoulList(svo);
		model.addAttribute("seoulList", seoulList);

		return "helpeeWriteForm.jsp";
	}

	// 헬피 요청 글 입력
	@RequestMapping(value = "/helpeeWriteForm.do", method = RequestMethod.POST)
	public String helpeeForm(@ModelAttribute("helpee") HelpeeVO vo, Model model) {
		System.out.println("헬피-요청 글 작성 후 Submit.");

		// DB에 저장
		helpeeService.insertHelpee(vo);

		return "getHelpeeList.do";
	}

	// 헬피 요청 글 삭제
	@RequestMapping(value = "/helpeeDelete.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String helpeeDelete(@ModelAttribute("helpee") HelpeeVO vo) {
		System.out.println("헬피-요청 글 삭제.");

		helpeeService.deleteHelpee(vo);

		return "getHelpeeList.do";
	}

	// 헬피 요청 글 수정
	@RequestMapping(value = "/helpeeUpdate.do", method = RequestMethod.GET)
	public String helpeeUpdateView(@ModelAttribute("helpee") HelpeeVO vo, @ModelAttribute("language") LanguageVO lvo,
			@ModelAttribute("seoul") SeoulVO svo, @ModelAttribute("user") UserVO uvo, Model model) {
		System.out.println("헬피-요청 글 상세 보기.");

		HelpeeVO helpee = helpeeService.getHelpee(vo);
		model.addAttribute("helpee", helpee);

		List<LanguageVO> languageList = helpeeService.getLanguageList(lvo);
		model.addAttribute("languageList", languageList);

		List<SeoulVO> seoulList = helpeeService.getSeoulList(svo);
		model.addAttribute("seoulList", seoulList);

		return "helpeeUpdateForm.jsp";
	}

	@RequestMapping(value = "/helpeeUpdate.do", method = RequestMethod.POST)
	public String helpeeUpdate(@ModelAttribute("helpee") HelpeeVO vo, Model model) {
		System.out.println("헬피-요청 글 수정.");

		helpeeService.updateHelpee(vo);

		return "getHelpeeList.do";
	}

	// 헬피글 최신순 정렬
	@RequestMapping(value = "/recentHelpeeList.do", method = RequestMethod.GET)
	public String recentHelpeeList(@ModelAttribute("helpee") HelpeeVO hvo, E_ReviewVO evo,
			@ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("헬피 홍보글 최신순 목록으로 이동");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.recentHelpeeList(hvo));
		return "getHelpeeList.jsp";
	}
	
	// 헬피글 평점순 정렬
	@RequestMapping(value = "/scoreHelpeeList.do", method = RequestMethod.GET)
	public String scoreHelpeeList(@ModelAttribute("helpee") HelpeeVO hvo, E_ReviewVO evo,
			@ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("헬피 홍보글 최신순 목록으로 이동");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.scoreHelpeeList(hvo));
		return "getHelpeeList.jsp";
	}

	// 이사 헬피 리스트
	@RequestMapping(value = "/moveHelpee.do", method = RequestMethod.GET)
	public String moveHelpee(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo,
			@ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("이사 서비스 헬피 목록 출력");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.moveHelpee(hvo));
		return "getHelpeeList.jsp";
	}

	// 병원 헬피 리스트
	@RequestMapping(value = "/hospitalHelpee.do", method = RequestMethod.GET)
	public String hospitalHelpee(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo,
			@ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("병원 서비스 헬피 목록 출력");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.hospitalHelpee(hvo));
		return "getHelpeeList.jsp";
	}

	// 출입국 헬피 리스트
	@RequestMapping(value = "/immigrationHelpee.do", method = RequestMethod.GET)
	public String immigrationHelpee(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo,
			@ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("출입국 서비스 헬피 목록 출력");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.immigrationHelpee(hvo));
		return "getHelpeeList.jsp";
	}

	// 지역별 헬피 리스트
	@RequestMapping(value = "/seoulHelpeeList.do", method = RequestMethod.GET)
	public String seoulHelpeeList(@ModelAttribute("helpee") HelpeeVO hvo, @ModelAttribute("eReview") E_ReviewVO evo,
			@ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("지역별 헬피 목록 출력");
		model.addAttribute("seoulList", helpeeService.getSeoulList(svo));
		model.addAttribute("countList", helpeeService.getE_ReviewCountList(evo));
		model.addAttribute("avgList", helpeeService.getE_ReviewAvgList(evo));
		model.addAttribute("helpeeList", helpeeService.seoulHelpeeList(hvo));
		return "getHelpeeList.jsp";
	}

}
