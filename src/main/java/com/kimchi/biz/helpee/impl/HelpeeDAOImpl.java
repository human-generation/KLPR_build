package com.kimchi.biz.helpee.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeVO;


@Repository("helpeeDAO")
public class HelpeeDAOImpl implements HelpeeDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		System.out.println("===> MyBatis로 getHelpee() 기능 처리");
	     return (HelpeeVO)mybatis.selectOne("HelpeeDAO.getBoard", vo);
	}

	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("===> MyBatis로 getHelpeeList() 기능 처리");
		System.out.println("SqlSessionTemplate : " + mybatis);
		return mybatis.selectList("HelpeeDAO.getHelpeeList", vo);
	}

}
