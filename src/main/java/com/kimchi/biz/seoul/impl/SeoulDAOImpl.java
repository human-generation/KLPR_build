package com.kimchi.biz.seoul.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.seoul.SeoulDAO;
import com.kimchi.biz.seoul.SeoulVO;

@Repository("seoulDAO")
public class SeoulDAOImpl implements SeoulDAO {

	@Override
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		return null;
	}
	
}
