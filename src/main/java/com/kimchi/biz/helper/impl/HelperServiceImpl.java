package com.kimchi.biz.helper.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;

@Service("helperService")
public class HelperServiceImpl implements HelperService{

	@Autowired
	private HelperDAO helperDAO;
	
	@Autowired
	HttpSession httpSession;

	@Override
	public HelperVO getHelper(HelperVO vo) {
		return helperDAO.getHelper(vo);
	}

	@Override
	public void insertHelper(HelperVO vo) {
		helperDAO.insertHelper(vo);
	}

	@Override
	public void updateHelper(HelperVO vo) {
		helperDAO.updateHelper(vo);
	}

	@Override
	public void deleteHelper(HelperVO vo) {
		helperDAO.deleteHelper(vo);
	}
		
}
