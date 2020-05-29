package com.kimchi.view.helper;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.helper.HelperVO;
<<<<<<< HEAD
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

		List<HelperVO> helperList = helperDAO.getHelperList(vo);
		session.setAttribute("helperList", helperList);
		return "getHelperList.jsp";
	}	
=======
import com.kimchi.biz.helper.impl.HelperDAOImpl;

@Controller
public class HelperController {
	
	@RequestMapping(value = "/helperWriteForm.do", method = {RequestMethod.GET})
	public String helperFormView(@ModelAttribute("helper") HelperVO vo) {
		System.out.println("헬퍼-홍보 글 작성 페이지로 이동");
		
		return "helperWriteForm.jsp";
	}
	
	@RequestMapping(value = "/helperWriteForm.do", method = {RequestMethod.POST})
	public String helperForm(HelperVO vo, HelperDAOImpl helperDAO, HttpSession session) {
		System.out.println("헬퍼-홍보 글 작성 submit. DB에 저장.");
		
		//DB에 저장
		helperDAO.insertHelper(vo);
		
		return "main.do";
	}
	
	
	
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a

}
