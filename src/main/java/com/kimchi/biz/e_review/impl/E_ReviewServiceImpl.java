package com.kimchi.biz.e_review.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.e_review.E_ReviewDAO;
import com.kimchi.biz.e_review.E_ReviewService;
import com.kimchi.biz.e_review.E_ReviewVO;

@Service("e_reviewService")
public class E_ReviewServiceImpl implements E_ReviewService {

	@Autowired
	private E_ReviewDAO e_reviewDAO;

	@Override
	public void insertE_Review(E_ReviewVO vo) {
		e_reviewDAO.insertE_Review(vo);
	}

	@Override
	public E_ReviewVO getE_Review(E_ReviewVO vo) {
		return e_reviewDAO.getE_Review(vo);
	}

	@Override
	public List<E_ReviewVO> getE_ReviewList(E_ReviewVO vo) {
		return e_reviewDAO.getE_ReviewList(vo);
	}

}
