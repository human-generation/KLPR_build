package com.kimchi.biz.helper.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;

@Service("HelperService")
public class HelperServiceImpl implements HelperService {
	
	@Autowired
	private HelperDAO helperDAO;
	
	@Autowired
	HttpSession session;

	@Override
	public List<HelperVO> getHelperList(HelperVO vo) {
		System.out.println("HelperServiceImpl의 getHelperList() 실행...");
		return helperDAO.getHelperList(vo);
	}

	@Override
	public HelperVO getHelper(HelperVO vo) {
		return helperDAO.getHelper(vo);
	}
	
}
