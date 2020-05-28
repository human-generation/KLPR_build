package com.kimchi.biz.helpee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helpee.HelpeePRDAO;
import com.kimchi.biz.helpee.HelpeePRService;
import com.kimchi.biz.helpee.HelpeePRVO;

@Service("helpeeservice")
public class HelpeePRServiceImpl implements HelpeePRService {

	@Autowired
	private HelpeePRDAO eprDAO;

	@Override
	public void insertEPR(HelpeePRVO vo) {
		eprDAO.insertEPR(vo);
	}
	
}
