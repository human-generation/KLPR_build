package com.kimchi.biz.helper.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;

public class HelperServiceImpl  implements HelperService{

	@Autowired
	private HelperDAO helperDAO;

	@Override
	public HelperVO getHelper(HelperVO vo) {
		return helperDAO.getHelper(vo);
	}

	@Override
	public void insertHelper(HelperVO vo) {
		helperDAO.insertHelper(vo);
	}
	
	
	
		
}
