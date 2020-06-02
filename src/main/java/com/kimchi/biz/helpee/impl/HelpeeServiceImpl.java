package com.kimchi.biz.helpee.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.e_review.E_ReviewDAO;
import com.kimchi.biz.e_review.E_ReviewVO;
import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;

@Service("HelpeeService")
public class HelpeeServiceImpl implements HelpeeService {
	@Autowired
	private HelpeeDAO helpeeDAO;

	@Autowired
	private E_ReviewDAO e_reviewDAO;

	@Autowired
	HttpSession session;

	@Override
	public List<E_ReviewVO> getReviewCountList(E_ReviewVO vo) {
		System.out.println("HelpeeServiceImpl의 getReviewCountList() 실행...");
		return e_reviewDAO.getReviewCountList(vo);
	}

	@Override
	public List<E_ReviewVO> getReviewAvgList(E_ReviewVO vo) {
		System.out.println("HelpeeServiceImpl의 getReviewAvgList() 실행...");
		return e_reviewDAO.getReviewAvgList(vo);
	}
	
	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 getHelpeeList() 실행...");
		helpeeDAO.deleteHelpee(vo);
		return helpeeDAO.getHelpeeList(vo);
	}

	@Override
	public List<HelpeeVO> recentHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 recentHelpeeList() 실행...");
		return helpeeDAO.recentHelpeeList(vo);
	}


	
//	public List<HelpeeVO> getReviewCountList(HelpeeVO vo) {
//		System.out.println("HelpeeServiceImpl의 getReviewCountList() 실행...");
//		return helpeeDAO.getReviewCountList(vo);
//	}

}
