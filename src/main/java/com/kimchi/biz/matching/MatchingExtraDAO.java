package com.kimchi.biz.matching;

import java.util.List;

import org.springframework.ui.Model;

import com.kimchi.biz.user.UserVO;

public interface MatchingExtraDAO {
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state);

	public void setMatchingState(UserVO vo, Model model);

	public String senderName(int mno);

	public String receiverName(int mno);

	public void updateState(MatchingVOExtra mvo);
}
