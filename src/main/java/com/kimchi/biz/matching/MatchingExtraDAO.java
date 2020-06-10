package com.kimchi.biz.matching;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kimchi.biz.user.UserVO;

public interface MatchingExtraDAO {
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state);

	public void setMatchingState(UserVO vo, HttpSession session);
	public void insertMatching(MatchingVOExtra vo);
}
