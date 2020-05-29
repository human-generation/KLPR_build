package com.kimchi.biz.matching;

import java.util.List;

import com.kimchi.biz.user.UserVO;

public interface MatchingService {
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state);
}
