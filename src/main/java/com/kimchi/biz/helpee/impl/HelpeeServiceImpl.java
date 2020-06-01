package com.kimchi.biz.helpee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;
import com.kimchi.biz.language.LanguageDAO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulDAO;
import com.kimchi.biz.seoul.SeoulVO;

@Service("HelpeeService")
public class HelpeeServiceImpl implements HelpeeService{
	@Autowired
	private HelpeeDAO helpeeDAO;
	@Autowired
	private LanguageDAO languageDAO;
	@Autowired
	private SeoulDAO seoulDAO;


	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 getHelpeeList() 실행...");
		return helpeeDAO.getHelpeeList(vo);
	}


	@Override
	public List<LanguageVO> getLanguageList(LanguageVO vo) {
		System.out.println("HelpeeServiceImpl의 getLanguageList() 실행...");
		return languageDAO.getLanguageList(vo);
	}


	@Override
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		System.out.println("HelpeeServiceImpl의 getSeoulList() 실행...");
		return seoulDAO.getSeoulList(vo);
	}
	
	
	
	
}
