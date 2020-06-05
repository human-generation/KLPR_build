package com.kimchi.biz.r_review.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.r_review.R_ReviewDAO;
import com.kimchi.biz.r_review.R_ReviewService;
import com.kimchi.biz.r_review.R_ReviewVO;

@Service("r_reviewService")
public class R_ReviewServiceImpl implements R_ReviewService {

	@Autowired
	private R_ReviewDAO r_reviewDAO;

	@Override
	public void insertR_review(R_ReviewVO vo) {
		r_reviewDAO.insertR_review(vo);
	}

	@Override
	public R_ReviewVO getR_Review(R_ReviewVO vo) {
		return r_reviewDAO.getR_Review(vo);
	}

	@Override
	public List<R_ReviewVO> getR_ReviewList(R_ReviewVO vo) {
		return r_reviewDAO.getR_ReviewList(vo);
	}

}