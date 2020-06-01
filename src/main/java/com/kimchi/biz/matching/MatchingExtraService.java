package com.kimchi.biz.matching;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kimchi.biz.user.UserVO;

public interface MatchingExtraService {
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state);

	public void updateState(MatchingVOExtra mvo);

	public void setMatchingState(UserVO vo, HttpSession session);
}
