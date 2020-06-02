package com.kimchi.biz.helper.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;
<<<<<<< HEAD
=======
import com.kimchi.biz.language.LanguageDAO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulDAO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserDAO;
>>>>>>> klpr/push_dpk_cstl
import com.kimchi.biz.user.UserVO;

@Service("HelperService")
public class HelperServiceImpl implements HelperService {

	@Autowired
	private HelperDAO helperDAO;
	
	@Autowired
	HttpSession session;

	@Autowired
	private LanguageDAO languageDAO;

	@Autowired
	private SeoulDAO seoulDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<HelperVO> getHelperList(HelperVO vo) {
<<<<<<< HEAD
		System.out.println("HelperServiceImpl의 getHelperList() 실행...");
		helperDAO.deleteHelper(vo);
=======
		
>>>>>>> klpr/push_dpk_cstl
		return helperDAO.getHelperList(vo);
	}

//	@Override
//	public void deleteHelper(HelperVO vo) {
//		System.out.println("HelperServiceImpl의 deleteHelper() 실행...");
//		helperDAO.deleteHelper(vo);
//	}

	@Override
	public List<HelperVO> recentHelperList(HelperVO vo) {
		System.out.println("HelperServiceImpl의 recentHelperList() 실행...");
		return helperDAO.recentHelperList(vo);
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
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		return seoulDAO.getSeoulList(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return userDAO.getUserList(vo);
	}
	
	

}
