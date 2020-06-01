package com.kimchi.biz.helper.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.user.UserVO;

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
	public void deleteHelper(HelperVO vo) {
		System.out.println("HelperServiceImpl의 deleteHelper() 실행...");
		helperDAO.deleteHelper(vo);
	}

	@Override
	public List<HelperVO> recentHelperList(HelperVO vo) {
		System.out.println("HelperServiceImpl의 recentHelperList() 실행...");
		return helperDAO.recentHelperList(vo);
	}
	
}
