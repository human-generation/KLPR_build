package com.kimchi.biz.helpee;

import java.util.List;

public interface HelpeeDAO {
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
}
