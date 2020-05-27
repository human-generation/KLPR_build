package com.kimchi.biz.matching.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.matching.MatchingDAO;
import com.kimchi.biz.matching.MatchingService;
import com.kimchi.biz.matching.MatchingVO;

@Service("matchingService")
public class MatchingServiceImpl implements MatchingService {
	@Autowired
	private MatchingDAO matchingDAO;

	@Override
	public void insertMatching(MatchingVO vo) {
		matchingDAO.insertMatching(vo);
	}

}
