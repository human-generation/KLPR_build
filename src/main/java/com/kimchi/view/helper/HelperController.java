package com.kimchi.view.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.seoul.SeoulVO;

@Controller
//@SessionAttributes("helper")
public class HelperController {

	@Autowired
	private HelperService helperService;

	// 헬퍼 목록
	@RequestMapping(value = "/getHelperList.do", method = RequestMethod.GET)
	public String getHelperList(@ModelAttribute("helper") HelperVO vo, Model model) {
		System.out.println("헬퍼 목록 처리 웽 모델썻지롱");

		// 헬퍼 홍보글 리스트 모델에 담기?
		model.addAttribute("helperList", helperService.getHelperList(vo));

//		helperDAO.deleteHelper(vo);	// 날짜지난 홍보글부터 삭제

//		List<HelperVO> helperList = helperDAO.getHelperList(vo); // 홍보글 리스트 불러오기
//		session.setAttribute("helperList", helperList);
		return "getHelperList.jsp";
	}

	// 날짜지난 홍보글 삭제하기
//	@RequestMapping(value = "/getHelperList.do", method = RequestMethod.POST)
//	public String deleteHelper(@ModelAttribute("helper") HelperVO vo) {
//		System.out.println("날짜지난글 지움 리스트 모델때매 분리됐는데 작동하는지 봐바요");
//		
//		helperService.deleteHelper(vo);
//		
//		return "getHelperList.jsp";
//	}

	// 최신순 정렬
	@RequestMapping(value = "/recentHelperList.do", method = RequestMethod.GET)
	public String recentHelperList(@ModelAttribute("helper") HelperVO vo, Model model) {
		System.out.println("최신순 헬퍼 목록 처리 모델로한거임");

		model.addAttribute("helperList", helperService.recentHelperList(vo));
//		List<HelperVO> helperList = helperDAO.recentHelperList(vo); // 홍보글 목록 최신순으로 불러오기
//		session.setAttribute("helperList", helperList);
		return "getHelperList.jsp";
	}

	// 평점순 정렬
	@RequestMapping(value = "/scoreHelperList.do", method = RequestMethod.GET)
	public String scoreHelperList(@ModelAttribute("helper") HelperVO vo, Model model) {
		System.out.println("평점순 헬퍼 목록 모델!!! 로 처리");

		model.addAttribute("helperList", helperService.scoreHelperList(vo));
		return "getHelperList.jsp";
	}

	// 이사 헬퍼 리스트
	@RequestMapping(value = "/moveHelper.do", method = RequestMethod.GET)
	public String moveHelper(@ModelAttribute("helper") HelperVO vo, Model model) {
		System.out.println("모델로 이사헬퍼 리스트");

		model.addAttribute("helperList", helperService.moveHelper(vo));
		return "getHelperList.jsp";
	}

	// 병원 헬퍼 리스트
	@RequestMapping(value = "/hospitalHelper.do", method = RequestMethod.GET)
	public String hospitalHelper(@ModelAttribute("helper") HelperVO vo, Model model) {
		System.out.println("모델로 병원헬퍼 리스트");

		model.addAttribute("helperList", helperService.hospitalHelper(vo));
		return "getHelperList.jsp";
	}

	// 출입국 헬퍼 리스트
	@RequestMapping(value = "/immigrationHelper.do", method = RequestMethod.GET)
	public String immigrationHelper(@ModelAttribute("helper") HelperVO vo, Model model) {
		System.out.println("모델로 출입국헬퍼 리스트");

		model.addAttribute("helperList", helperService.immigrationHelper(vo));
		return "getHelperList.jsp";
	}
	
}
