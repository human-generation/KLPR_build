package com.kimchi.biz.matching;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kimchi.biz.user.UserVO;

@Service
public interface MatchingService {
	public List<MatchingVO> getMatchingList(UserVO vo, int state);
}
