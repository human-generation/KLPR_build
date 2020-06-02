package com.kimchi.biz.matching.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kimchi.biz.matching.MatchingExtraDAO;
import com.kimchi.biz.matching.MatchingExtraService;
import com.kimchi.biz.matching.MatchingVOExtra;
import com.kimchi.biz.user.UserVO;

@Service("matchingService")
public class MatchingExtraServiceImpl implements MatchingExtraService {
	@Autowired
	private MatchingExtraDAO matchingDAO;

	@Override
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state) {
		return matchingDAO.getMatchingList(vo, state);
	}

	@Override
	public void updateState(MatchingVOExtra mvo) {
		matchingDAO.updateState(mvo);
	}

	@Override
	public void setMatchingState(UserVO vo, Model model) {
		matchingDAO.setMatchingState(vo, model);
	}

}
