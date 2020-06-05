package com.kimchi.biz.helper.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.language.LanguageDAO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.r_review.R_ReviewDAO;
import com.kimchi.biz.r_review.R_ReviewVO;
import com.kimchi.biz.seoul.SeoulDAO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserDAO;
import com.kimchi.biz.user.UserVO;

@Service("helperService")
public class HelperServiceImpl implements HelperService {

	@Autowired
	private HelperDAO helperDAO;

	@Autowired
	private LanguageDAO languageDAO;

	@Autowired
	private SeoulDAO seoulDAO;

	@Autowired
	private R_ReviewDAO r_reviewDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	HttpSession session;

	@Override
	public HelperVO getHelper(HelperVO vo) {
		return helperDAO.getHelper(vo);
	}

	@Override
	public List<HelperVO> getHelperList(HelperVO vo) {
		System.out.println("HelperServiceImpl의 getHelperList() 실행...");
		helperDAO.deleteDateHelper(vo);
		return helperDAO.getHelperList(vo);
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

	@Override
	public List<LanguageVO> getLanguageList(LanguageVO vo) {
		return languageDAO.getLanguageList(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return userDAO.getUserList(vo);
	}

	@Override
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		System.out.println("HelperServiceImpl의 getSeoulList() 실행...");
		return seoulDAO.getSeoulList(vo);
	}

	@Override
	public List<R_ReviewVO> getR_ReviewCountList(R_ReviewVO vo) {
		System.out.println("HelperServiceImpl의 getReviewCountList() 실행...");
		return r_reviewDAO.getR_ReviewCountList(vo);
	}

	@Override
	public List<R_ReviewVO> getR_ReviewAvgList(R_ReviewVO vo) {
		System.out.println("HelperServiceImpl의 getReviewAvgList() 실행...");
		return r_reviewDAO.getR_ReviewAvgList(vo);
	}

	@Override
	public List<HelperVO> recentHelperList(HelperVO vo) {
		System.out.println("HelperServiceImpl의 recentHelperList() 실행...");
		return helperDAO.recentHelperList(vo);
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
	public List<HelperVO> seoulHelperList(HelperVO vo) {
		System.out.println("HelperServiceImpl의 seoulHelperList() 실행...");
		return helperDAO.seoulHelperList(vo);
	}

//	@Override
//	public void deleteDateHelper(HelperVO vo) {
//		System.out.println("HelperServiceImpl의 deleteDateHelper() 실행...");
//		helperDAO.deleteDateHelper(vo);
//	}
	
//	@Override
//	public List<HelperVO> scoreHelperList(HelperVO vo) {
//		System.out.println("HelperServiceImpl의 scoreHelperList() 실행...");
//		return helperDAO.scoreHelperList(vo);
//	}

}
