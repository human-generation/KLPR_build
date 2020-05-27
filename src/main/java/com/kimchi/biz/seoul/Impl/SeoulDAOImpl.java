package com.kimchi.biz.seoul.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.kimchi.biz.seoul.SeoulDAO;
import com.kimchi.biz.seoul.SeoulVO;

public class SeoulDAOImpl implements SeoulDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		System.out.println("===> MyBatis로 getSeoulList() 기능 처리");
		return mybatis.selectList("SeoulDAO.getSeoulList", vo);
	}
	
}
