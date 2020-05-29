package com.kimchi.view.helper;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helper.HelperListVO;
import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.helper.impl.HelperDAOImpl;

@Controller
//@SessionAttributes("helper")
public class HelperController {
	
//	@Autowired
//	private HelperService helperService;
	
	// 헬퍼 목록
	@RequestMapping(value = "/getHelperList.do", method = RequestMethod.GET)
	public String getHelperList(@ModelAttribute("helper") HelperListVO vo, HelperDAOImpl helperDAO, HttpSession session) {
		System.out.println("헬퍼 목록 처리 웽");

		List<HelperListVO> helperList = helperDAO.getHelperList(vo);
		session.setAttribute("helperList", helperList);
		return "getHelperList.jsp";
	}	

}
