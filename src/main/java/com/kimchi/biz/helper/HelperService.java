package com.kimchi.biz.helper;

import java.util.List;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

public interface HelperService {

	public HelperVO getHelper(HelperVO vo);
	public List<HelperVO> getHelperList(HelperVO vo);
	void insertHelper(HelperVO vo);
	void updateHelper(HelperVO vo);
	void deleteHelper(HelperVO vo);
	public List<LanguageVO> getLanguageList(LanguageVO vo);
	public List<SeoulVO> getSeoulList(SeoulVO vo);
	public List<UserVO> getUserList(UserVO vo);

}