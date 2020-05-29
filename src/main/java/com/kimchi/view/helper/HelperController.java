package com.kimchi.view.helper;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.helper.impl.HelperDAOImpl;

@Controller
//@SessionAttributes("helper")
public class HelperController {
	
//	@Autowired
//	private HelperService helperService;
	
	// 헬퍼 목록
	@RequestMapping(value = "/getHelperList.do", method = RequestMethod.GET)
	public String getHelperList(@ModelAttribute("helper") HelperVO vo, HelperDAOImpl helperDAO, HttpSession session) {
		System.out.println("헬퍼 목록 처리 웽");

		helperDAO.deleteHelper(vo);	// 날짜지난 홍보글부터 삭제
		
		List<HelperVO> helperList = helperDAO.getHelperList(vo); // 홍보글 리스트 불러오기
		session.setAttribute("helperList", helperList);
		return "getHelperList.jsp";
	}
	
	// 최신순
	@RequestMapping(value = "/recentHelperList.do", method = RequestMethod.GET)
	public String recentHelperList(@ModelAttribute("helper") HelperVO vo, HelperDAOImpl helperDAO, HttpSession session) {
		System.out.println("최신순 헬퍼 목록 처리 띠용 되나요?");
		
		List<HelperVO> helperList = helperDAO.recentHelperList(vo); // 홍보글 목록 최신순으로 불러오기
		session.setAttribute("helperList", helperList);
//		return "recentHelperList.jsp";
		return "getHelperList.jsp";
	}
	
}
