package com.kimchi.biz.helpee;

import java.util.List;

public interface HelpeeDAO {
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
	public void insertHelpee(HelpeeVO vo);
	public void updateHelpee(HelpeeVO vo);
	public void deleteHelpee(HelpeeVO vo);
}
