package com.kimchi.biz.helpee;

import java.util.List;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;

public interface HelpeeService {
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
	void insertHelpee(HelpeeVO vo);
	void updateHelpee(HelpeeVO vo);
	void deleteHelpee(HelpeeVO vo);
	public List<LanguageVO> getLanaguageList(LanguageVO vo);
	public List<SeoulVO> getSeoulList(SeoulVO vo);

}
