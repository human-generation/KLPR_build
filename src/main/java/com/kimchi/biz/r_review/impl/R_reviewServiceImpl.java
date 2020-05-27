package com.kimchi.biz.r_review.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.r_review.R_reviewDAO;
import com.kimchi.biz.r_review.R_reviewService;
import com.kimchi.biz.r_review.R_reviewVO;
import com.kimchi.biz.user.UserVO;

@Service("r_reviewService")
public class R_reviewServiceImpl implements R_reviewService {

	@Autowired	
	private R_reviewDAO r_reviewDAO;
	
	
	
	@Override
	public void insertR_review(R_reviewVO vo) {
		r_reviewDAO.insertR_review(vo);
		
	}
	
	
}
