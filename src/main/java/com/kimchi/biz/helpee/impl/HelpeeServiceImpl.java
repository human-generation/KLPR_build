package com.kimchi.biz.helpee.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;

@Service("helpeeService")
public class HelpeeServiceImpl implements HelpeeService {

	@Autowired
	private HelpeeDAO helpeeDAO;
	
	@Autowired
	HttpSession httpSession;

	@Override
	public void insertHelpee(HelpeeVO vo) {
		helpeeDAO.insertHelpee(vo);
	}
	
}
