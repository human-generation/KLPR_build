package com.kimchi.view.helper;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> klpr/push_dpk_cstl
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;
<<<<<<< HEAD
=======
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
>>>>>>> klpr/push_dpk_cstl
import com.kimchi.biz.user.UserVO;

@Controller
public class HelperController {
<<<<<<< HEAD
	
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
	
=======

	@Autowired
	private HelperService helperService;

	// 헬퍼 목록
	@RequestMapping(value = "/getHelperList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String getHelperList(@ModelAttribute("helper") HelperVO vo, @ModelAttribute("language") LanguageVO lvo,
			@ModelAttribute("seoul") SeoulVO svo, @ModelAttribute("user") UserVO uvo, Model model) {
		System.out.println("헬퍼 목록 처리 웽");

		List<HelperVO> helperList = helperService.getHelperList(vo);
		model.addAttribute("helperList", helperList);

		List<LanguageVO> languageList = helperService.getLanguageList(lvo);
		model.addAttribute("languageList", languageList);
		System.out.println(languageList.toString());
		
		List<SeoulVO> seoulList = helperService.getSeoulList(svo);
		model.addAttribute("seoulList", seoulList);
		System.out.println(seoulList.toString());
		
		List<UserVO> userList = helperService.getUserList(uvo);
		model.addAttribute("userList", userList);
		
		return "getHelperList.jsp";
	}

	// 헬퍼 홍보 작성 폼
	@RequestMapping(value = "/helperWriteForm.do", method = { RequestMethod.GET})
	public String helperFormView(@ModelAttribute("helper") HelperVO vo, @ModelAttribute("language") LanguageVO lvo,
			@ModelAttribute("seoul") SeoulVO svo, Model model) {
		System.out.println("헬퍼-홍보 글 작성 페이지로 이동");
		
		List<LanguageVO> languageList = helperService.getLanguageList(lvo);
		model.addAttribute("languageList", languageList);
		System.out.println(languageList.toString());
		
		List<SeoulVO> seoulList = helperService.getSeoulList(svo);
		model.addAttribute("seoulList", seoulList);
		System.out.println(seoulList.toString());
		
		return "helperWriteForm.jsp";
	}

	// 헬퍼 홍보 글 입력
	@RequestMapping(value = "/helperWriteForm.do", method = {RequestMethod.POST})
	public String helperForm(@ModelAttribute("helper") HelperVO vo, Model model) {
		System.out.println("헬퍼-홍보 글 작성 submit. DB에 저장.");
		System.out.println(vo.toString());

		// DB에 저장
		// helperDAO.insertHelper(vo);
		helperService.insertHelper(vo);
		
		return "getHelperList.do";
	}
	
	// 헬퍼 홍보 글 삭제
	@RequestMapping(value = "/helperDelete.do", method = RequestMethod.GET)
	public String helperDelete(@ModelAttribute("helper") HelperVO vo) {
		System.out.println("헬퍼-홍보 글 삭제. DB에 저장.");
		
		helperService.deleteHelper(vo);
		
		return "getHelperList.do";
	}
	
	@RequestMapping(value = "/helperUpdate.do", method = RequestMethod.GET)
	public String helperUpdateView(@ModelAttribute("helper") HelperVO vo, @ModelAttribute("language") LanguageVO lvo,
			@ModelAttribute("seoul") SeoulVO svo, @ModelAttribute("user") UserVO uvo, Model model) {
		System.out.println("헬퍼-홍보 글 상세 보기.");
		
		HelperVO helper = helperService.getHelper(vo);
		model.addAttribute("helper", helper);
		
		List<LanguageVO> languageList = helperService.getLanguageList(lvo);
		model.addAttribute("languageList", languageList);
		
		List<SeoulVO> seoulList = helperService.getSeoulList(svo);
		model.addAttribute("seoulList", seoulList);
		
		return "helperUpdateForm.jsp";
	}
	
	@RequestMapping(value = "/helperUpdate.do", method = RequestMethod.POST)
	public String helperUpdate(@ModelAttribute("helper") HelperVO vo, Model model) {
		System.out.println("헬퍼-홍보 글 수정");
		System.out.println("수정 값 toString : " + vo.toString());
		
		helperService.updateHelper(vo);
		
		
		return "getHelperList.do";
	}
	
	

>>>>>>> klpr/push_dpk_cstl
}
