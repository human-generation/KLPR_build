package com.kimchi.view.language;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.language.impl.LanguageDAOImpl;

//@Controller
public class LanguageController {

	@RequestMapping(value = {"/helperWriteForm.jsp"}, method = RequestMethod.GET)
	public String getLanguageList(@ModelAttribute("language") LanguageVO vo, LanguageDAOImpl languageDAO, HttpSession session){
		List<LanguageVO> languageList = languageDAO.getLanguageList(vo);
		session.setAttribute("languageList", languageList);
		
			return "helperWriteForm.do";
	}
	
	@RequestMapping(value = {"/helpeeWriteForm.jsp"}, method = RequestMethod.GET)
	public String getHelpeeLanguageList(@ModelAttribute("language") LanguageVO vo, LanguageDAOImpl languageDAO, HttpSession session){
		List<LanguageVO> languageList = languageDAO.getLanguageList(vo);
		session.setAttribute("languageList", languageList);
		return "helpeeWriteForm.do";
	}
	
	
}
