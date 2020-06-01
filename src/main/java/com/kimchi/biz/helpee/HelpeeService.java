package com.kimchi.biz.helpee;

import java.util.List;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;

public interface HelpeeService {
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
	public List<LanguageVO> getLanguageList(LanguageVO vo);
	public List<SeoulVO> getSeoulList(SeoulVO vo);
}
