package com.kimchi.view.help;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;

@Controller
//@SessionAttributes("helpee")
public class HelpController {
	
	@Autowired
	private HelpeeService helpeeService;
	
	@RequestMapping(value = "/getHelpeeList.do", method = RequestMethod.GET)
	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO hVo, LanguageVO lVo, SeoulVO sVo, Model model) {
		System.out.println("헬피 홍보글 목록으로 이동");
		List<LanguageVO> languageList = helpeeService.getLanguageList(lVo);
		model.addAttribute("languageList", languageList);
		System.out.println(languageList.toString());
		List<SeoulVO> seoulList = helpeeService.getSeoulList(sVo);
		model.addAttribute("seoulList", seoulList);
		System.out.println(seoulList.toString());
		List<HelpeeVO> helpeeList = helpeeService.getHelpeeList(hVo);
		model.addAttribute("helpeeList", helpeeList);
		System.out.println(helpeeList.toString());
		
		return "getHelpeeList.jsp";
	}
}
