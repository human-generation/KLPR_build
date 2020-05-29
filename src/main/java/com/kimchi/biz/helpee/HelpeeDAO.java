package com.kimchi.biz.helpee;

import java.util.List;

public interface HelpeeDAO {
	public void insertHelpee(HelpeeVO vo);
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
}
