package com.kimchi.biz.helpee;

import java.util.List;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

public interface HelpeeService {
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
	void insertHelpee(HelpeeVO vo);
	void updateHelpee(HelpeeVO vo);
	void deleteHelpee(HelpeeVO vo);
	public List<LanguageVO> getLanguageList(LanguageVO vo);
	public List<SeoulVO> getSeoulList(SeoulVO vo);
	public List<UserVO> getUserList(UserVO vo);

}
