package com.kimchi.biz.e_review.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.e_review.E_ReviewDAO;
import com.kimchi.biz.e_review.E_ReviewService;
import com.kimchi.biz.e_review.E_ReviewVO;

@Service("E_ReviewService")
public class E_ReviewServiceImpl implements E_ReviewService{
	
	@Autowired
	private E_ReviewDAO e_ReviewDAO;
	
	@Autowired
	HttpSession session;

	@Override
	public E_ReviewVO countE_vno(E_ReviewVO vo) {
		System.out.println("E_ReviewServiceImpl의 countE_vno() 실행...");
		return e_ReviewDAO.countE_vno(vo);
	}

	@Override
	public E_ReviewVO avgEscore(E_ReviewVO vo) {
		System.out.println("E_ReviewServiceImpl의 avgEscore() 실행...");
		return e_ReviewDAO.avgEscore(vo);
	}
	
	
}
