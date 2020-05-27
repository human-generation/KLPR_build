package com.kimchi.biz.e_review.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kimchi.biz.e_review.E_ReviewDAO;
import com.kimchi.biz.e_review.E_ReviewVO;

@Repository("e_reviewDAO")
public class E_ReviewDAOMybatisTemplate implements E_ReviewDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertE_Review(E_ReviewVO vo) {
		System.out.println("-----E_ReviewDAOMybatis로 insertE_Review() 실행");
		mybatis.insert("E_ReviewDAO.insertE_Review", vo);
	}

	@Override
	public E_ReviewVO getE_Review(E_ReviewVO vo) {
		System.out.println("-----E_ReviewDAOMybatis로 insertE_Review() 실행");
		return (E_ReviewVO) mybatis.selectOne("E_ReviewDAO.getE_Review", vo);
	}

	@Override
	public List<E_ReviewVO> getE_ReviewList(E_ReviewVO vo) {
		System.out.println("-----E_ReviewDAOMybatis로 insertE_Review() 실행");
		return mybatis.selectList("E_ReviewDAO.getE_ReviewList", vo);
	}

}
