package com.kimchi.biz.helpee.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;

@Component
public class HelpeeServiceImpl implements HelpeeService{
	
	private HelpeeDAO helpeeDAO;
	
	@Autowired
	void setHelpeeDao(HelpeeDAO helpeeDAO) {
		this.helpeeDAO = helpeeDAO;
	}
	
	@Autowired
	HttpSession session;

	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		return helpeeDAO.getHelpee(vo);
	}

	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 getHelpeeList() 실행...");
		System.out.println("HelpeeDAO : " + helpeeDAO);
		return helpeeDAO.getHelpeeList(vo);
	}
	
	
}
