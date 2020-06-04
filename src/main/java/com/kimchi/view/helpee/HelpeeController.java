package com.kimchi.view.helpee;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;
import com.kimchi.biz.helpee.impl.HelpeeDAOImpl;
import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

@Controller
public class HelpeeController {
	
	@Autowired
	private HelpeeService helpeeService;
	
	// 헬피 목록 
	@RequestMapping(value = "/getHelpeeList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO vo, @ModelAttribute("language") LanguageVO lvo,
			@ModelAttribute("seoul") SeoulVO svo, @ModelAttribute("user") UserVO uvo, Model model) {
		System.out.println("헬피-요청 글 목록으로 이동");
		
		List<HelpeeVO> helpeeList = helpeeService.getHelpeeList(vo);
		model.addAttribute("helpeeList", helpeeList);

		List<LanguageVO> languageList = helpeeService.getLanguageList(lvo);
		model.addAttribute("languageList", languageList);
		System.out.println(languageList.toString());
		
		List<SeoulVO> seoulList = helpeeService.getSeoulList(svo);
		model.addAttribute("seoulList", seoulList);
		System.out.println(seoulList.toString());
		
		List<UserVO> userList = helpeeService.getUserList(uvo);
		model.addAttribute("userList", userList);
		
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
		
		//DB에 저장
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
	@RequestMapping(value = "/helpeeUpdate.do", method = { RequestMethod.GET, RequestMethod.POST })
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
	
}
