package com.kimchi.view.helpee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;

@Controller
@SessionAttributes("helpee")
public class HelpeeController {
	
	@Autowired
	private HelpeeService helpeeService;
	
	// 전체 헬피 목록 출력
	@RequestMapping(value = "/getHelpeeList.do", method = RequestMethod.GET)
	public String getHelpeeList(@ModelAttribute("helpee") HelpeeVO vo, Model model) {
		System.out.println("헬피 홍보글 목록으로 이동");
		
<<<<<<< HEAD:src/main/java/com/kimchi/view/help/HelpController.java
		model.addAttribute("helpeeList", helpeeService.getHelpeeList(vo));
		
		return "getHelpeeList.jsp";
	}
	
	// 헬피글 최신순 정렬
	@RequestMapping(value = "/recentHelpeeList.do", method = RequestMethod.GET)
	public String recentHelpeeList(@ModelAttribute("helpee") HelpeeVO vo, Model model) {
		System.out.println("헬피 홍보글 최신순 목록으로 이동");
		
		model.addAttribute("helpeeList", helpeeService.recentHelpeeList(vo));
=======
		List<HelpeeVO> helpeeList = helpeeDAO.getHelpeeList(vo);
		session.setAttribute("helpeeList", helpeeList);
		
>>>>>>> klpr/push_dpk_cstl:src/main/java/com/kimchi/view/helpee/HelpeeController.java
		return "getHelpeeList.jsp";
	}
}
