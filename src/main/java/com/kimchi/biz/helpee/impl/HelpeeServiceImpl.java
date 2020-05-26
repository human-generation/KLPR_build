package com.kimchi.biz.helpee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;

@Service("helpeeService")
public class HelpeeServiceImpl implements HelpeeService{
	@Autowired
	private HelpeeDAO helpeeDAO;

	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		return helpeeDAO.getHelpee(vo);
	}

	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		return helpeeDAO.getHelpeeList(vo);
	}
	
	
}
