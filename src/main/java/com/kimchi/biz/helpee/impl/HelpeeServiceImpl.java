package com.kimchi.biz.helpee.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;

@Service("helpeeService")
public class HelpeeServiceImpl implements HelpeeService{
	@Autowired
	private HelpeeDAO helpeeDAO;
	
	@Autowired
	HttpSession session;
	
	@Override
	public void insertHelpee(HelpeeVO vo) {
		helpeeDAO.insertHelpee(vo);
	}

	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		return helpeeDAO.getHelpee(vo);
	}

	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 getHelpeeList() 실행...");
		return helpeeDAO.getHelpeeList(vo);
	}
	
	
}
