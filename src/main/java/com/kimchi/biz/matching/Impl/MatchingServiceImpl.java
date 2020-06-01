package com.kimchi.biz.matching.Impl;

import java.util.List;

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
	public void insertMatchingState1(MatchingVO vo) {
		matchingDAO.insertMatchingState1(vo);
	}

	@Override
	public void updateMatchingState2(MatchingVO vo) {
		matchingDAO.updateMatchingState2(vo);
	}

	@Override
	public void updateMatchingState3(MatchingVO vo) {
		matchingDAO.updateMatchingState3(vo);
	}

	@Override
	public void updateMatchingState4(MatchingVO vo) {
		matchingDAO.updateMatchingState4(vo);
	}

	@Override
	public void updateMatchingState5(MatchingVO vo) {
		matchingDAO.updateMatchingState5(vo);
	}

	@Override
	public MatchingVO getMatching(MatchingVO vo) {
		return matchingDAO.getMatching(vo);
	}

	@Override
	public List<MatchingVO> getMatchingSenderList(MatchingVO vo) {
		return matchingDAO.getMatchingSenderList(vo);
	}

	@Override
	public List<MatchingVO> getMatchingReceiverList(MatchingVO vo) {
		return matchingDAO.getMatchingReceiverList(vo);
	}

	@Override
	public List<MatchingVO> getMatchingState2List(MatchingVO vo) {
		return matchingDAO.getMatchingState2List(vo);
	}

	@Override
	public List<MatchingVO> getMatchingState3List(MatchingVO vo) {
		return matchingDAO.getMatchingState3List(vo);
	}

	@Override
	public List<MatchingVO> getMatchingState4List(MatchingVO vo) {
		return matchingDAO.getMatchingState4List(vo);
	}

	@Override
	public List<MatchingVO> getMatchingSenderState5List(MatchingVO vo) {
		return matchingDAO.getMatchingSenderState5List(vo);
	}

	@Override
	public List<MatchingVO> getMatchingReceiverState5List(MatchingVO vo) {
		return matchingDAO.getMatchingReceiverState5List(vo);
	}

}
