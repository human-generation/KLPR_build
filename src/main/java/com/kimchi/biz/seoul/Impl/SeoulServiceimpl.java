package com.kimchi.biz.seoul.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.seoul.SeoulDAO;
import com.kimchi.biz.seoul.SeoulService;
import com.kimchi.biz.seoul.SeoulVO;

@Service("SeoulService")
public class SeoulServiceimpl implements SeoulService{
	
	@Autowired
	private SeoulDAO seoulDAO;
	
	@Override
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		return seoulDAO.getSeoulList(vo);
	}
	
}
