package com.kimchi.biz.matching;

import java.util.List;

import org.springframework.ui.Model;

import com.kimchi.biz.user.UserVO;

public interface MatchingExtraService {
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state);

	public void updateState(MatchingVOExtra mvo);

	public void setMatchingState(UserVO vo, Model model);
}
