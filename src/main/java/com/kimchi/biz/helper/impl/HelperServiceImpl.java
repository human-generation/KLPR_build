package com.kimchi.biz.helper.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.r_review.R_reviewDAO;
import com.kimchi.biz.r_review.R_reviewVO;
import com.kimchi.biz.seoul.SeoulDAO;
import com.kimchi.biz.seoul.SeoulVO;

@Service("HelperService")
public class HelperServiceImpl implements HelperService {
	
	@Autowired
	private HelperDAO helperDAO;
	
	@Autowired
	private SeoulDAO seoulDAO;
	
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

	@Override
	public List<HelperVO> scoreHelperList(HelperVO vo) {
		System.out.println("HelperServiceImpl의 scoreHelperList() 실행...");
		return helperDAO.scoreHelperList(vo);
	}
	
	@Override
	public List<HelperVO> moveHelper(HelperVO vo) {
		System.out.println("HelperServiceImpl의 moveHelper() 실행...");
		return helperDAO.moveHelper(vo);
	}

	@Override
	public List<HelperVO> hospitalHelper(HelperVO vo) {
		System.out.println("HelperServiceImpl의 hospitalHelper() 실행...");
		return helperDAO.hospitalHelper(vo);
	}

	@Override
	public List<HelperVO> immigrationHelper(HelperVO vo) {
		System.out.println("HelperServiceImpl의 immigrationHelper() 실행...");
		return helperDAO.immigrationHelper(vo);
	}

	@Override
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		System.out.println("HelperServiceImpl의 getSeoulList() 실행...");
		return seoulDAO.getSeoulList(vo);
	}

	@Override
	public HelperVO getHelper(HelperVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HelperVO> seoulHelperList(HelperVO vo) {
		System.out.println("HelperServiceImpl의 seoulHelperList() 실행...");
		return helperDAO.seoulHelperList(vo);
	}

	@Override
	public List<R_reviewVO> getR_ReviewCountList(R_reviewVO vo) {
		System.out.println("HelperServiceImpl의 getReviewCountList() 실행...");
		return R_reviewDAO.getR_ReviewCountList(vo);
	}

	@Override
	public List<R_reviewVO> getR_ReviewAvgList(R_reviewVO vo) {
		System.out.println("HelperServiceImpl의 getReviewAvgList() 실행...");
		return R_reviewDAO.getR_ReviewAvgList(vo);
	}

}
