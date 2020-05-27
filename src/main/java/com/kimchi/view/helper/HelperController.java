package com.kimchi.view.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;

@Controller
@SessionAttributes("helper")
public class HelperController {
	
	@Autowired
	private HelperService helperService;
	
	// 헬퍼 목록
	@RequestMapping("/getHelperList.do")
	public String getBoardList(HelperVO vo, Model model) {
		System.out.println("헬퍼 목록 처리 웽");

		List<HelperVO> helperList = helperService.getHelperList(vo);
		model.addAttribute("helperList", helperList);
		return "helperBoard.jsp";
	}	

}
