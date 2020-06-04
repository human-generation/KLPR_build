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
import com.kimchi.biz.language.LanguageDAO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulDAO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserDAO;
import com.kimchi.biz.user.UserVO;

@Service("helpeeService")
public class HelpeeServiceImpl implements HelpeeService {
	@Autowired
	private HelpeeDAO helpeeDAO;

	@Autowired
	private LanguageDAO languageDAO;

	@Autowired
	private SeoulDAO seoulDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private E_ReviewDAO e_reviewDAO;

	@Autowired
	HttpSession session;

	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		return helpeeDAO.getHelpee(vo);
	}

	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 getHelpeeList() 실행...");
		helpeeDAO.deleteDateHelpee(vo);
		return helpeeDAO.getHelpeeList(vo);
	}

	@Override
	public void insertHelpee(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 insertHelpee() 실행...");
		helpeeDAO.insertHelpee(vo);
	}

	@Override
	public void updateHelpee(HelpeeVO vo) {
		helpeeDAO.updateHelpee(vo);

	}

	@Override
	public void deleteHelpee(HelpeeVO vo) {
		helpeeDAO.deleteHelpee(vo);
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
	public List<E_ReviewVO> getE_ReviewCountList(E_ReviewVO vo) {
		System.out.println("HelpeeServiceImpl의 getReviewCountList() 실행...");
		return e_reviewDAO.getE_ReviewCountList(vo);
	}

	@Override
	public List<E_ReviewVO> getE_ReviewAvgList(E_ReviewVO vo) {
		System.out.println("HelpeeServiceImpl의 getReviewAvgList() 실행...");
		return e_reviewDAO.getE_ReviewAvgList(vo);
	}

	@Override
	public List<HelpeeVO> recentHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 recentHelpeeList() 실행...");
		return helpeeDAO.recentHelpeeList(vo);
	}

	@Override
	public List<HelpeeVO> moveHelpee(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 moveHelpee() 실행...");
		return helpeeDAO.moveHelpee(vo);
	}

	@Override
	public List<HelpeeVO> hospitalHelpee(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 hospitalHelpee() 실행...");
		return helpeeDAO.hospitalHelpee(vo);
	}

	@Override
	public List<HelpeeVO> immigrationHelpee(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 immigrationHelpee() 실행...");
		return helpeeDAO.immigrationHelpee(vo);
	}

	@Override
	public List<HelpeeVO> seoulHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 seoulHelpeeList() 실행...");
		return helpeeDAO.seoulHelpeeList(vo);
	}

	@Override
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		System.out.println("HelpeeServiceImpl의 getSeoulList() 실행...");
		return seoulDAO.getSeoulList(vo);
	}

}
