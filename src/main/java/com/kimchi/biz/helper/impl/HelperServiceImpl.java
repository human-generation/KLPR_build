package com.kimchi.biz.helper.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;

@Service("HelperService")
public class HelperServiceImpl implements HelperService {
	
	@Autowired
	private HelperDAO helperDAO;

	@Override
	public List<HelperVO> getHelperList(HelperVO vo) {
		return helperDAO.getHelperList(vo);
	}

	@Override
	public List<HelperVO> getMoving(HelperVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HelperVO> getHospital(HelperVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HelperVO> getImmigration(HelperVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
