package com.kimchi.biz.matching;

import java.util.List;

import com.kimchi.biz.user.UserVO;

public interface MatchingExtraService {
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state);

	public void updateState(MatchingVOExtra mvo);
	
	public void insertMatching(MatchingVOExtra vo);
}
