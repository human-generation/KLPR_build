package com.kimchi.biz.matching.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.matching.MatchingService;
import com.kimchi.biz.matching.MatchingVOExtra;
import com.kimchi.biz.user.UserVO;

@Service("matchingService")
public class MatchingServiceImpl implements MatchingService {
	@Autowired
	private MatchingDAOImpl matchingDAO;
	
	@Override
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state) {
		return matchingDAO.getMatchingList(vo, state);	
	}

}
