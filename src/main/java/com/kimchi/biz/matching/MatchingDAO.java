package com.kimchi.biz.matching;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kimchi.biz.user.UserVO;

public interface MatchingDAO {
	public List<MatchingVO> getMatchingList(UserVO vo, int state);
	public void setMatchingState(UserVO vo, HttpSession session);
//	public List<MatchingVO> getReceivedMatchingList(UserVO vo);
//	public List<MatchingVO> getWaitingMatchingList(UserVO vo);
//	public List<MatchingVO> getPaidMatchingList(UserVO vo);
//	public List<MatchingVO> getEndedMatchingList(UserVO vo);
//	public List<MatchingVO> getDeniedMatchingList(UserVO vo);
}
