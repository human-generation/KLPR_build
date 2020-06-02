package com.kimchi.biz.helpee.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class HelpeeServiceImpl implements HelpeeService{
	@Autowired
	private HelpeeDAO helpeeDAO;
	
	@Autowired
	private LanguageDAO languageDAO;
	
	@Autowired
	private SeoulDAO seoulDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		return helpeeDAO.getHelpee(vo);
	}

	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 getHelpeeList() 실행...");
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
	public List<LanguageVO> getLanguageList(LanguageVO vo) {
		return languageDAO.getLanguageList(vo);
	}	
	
	@Override
	public void deleteHelpee(HelpeeVO vo) {
		helpeeDAO.deleteHelpee(vo);
	}

	@Override
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		return seoulDAO.getSeoulList(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return userDAO.getUserList(vo);
	}

	
}
