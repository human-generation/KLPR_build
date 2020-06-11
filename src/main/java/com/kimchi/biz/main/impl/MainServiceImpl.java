package com.kimchi.biz.main.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.main.MainDAO;
import com.kimchi.biz.main.MainService;
import com.kimchi.biz.main.MainVO;

@Service("MainService")
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainDAO MainDAO;
	
	@Override
	public List<MainVO> selectHelperScore() {		
		return MainDAO.selectHelperScore();
	}

	@Override
	public List<MainVO> selectHelpeeScore() {
		return MainDAO.selectHelpeeScore();
	}

	@Override
	public MainVO selectHelperScoreAvg(MainVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MainVO selectHelpeeScoreAvg(MainVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MainVO> selectRScoreTop5() {
		return MainDAO.selectRScoreTop5();
	}

	@Override
	public List<MainVO> selectRTop5() {
		return MainDAO.selectRTop5();
	}

	@Override
	public List<MainVO> selectETop5() {
		return MainDAO.selectETop5();
	}	
	
}
