package com.kimchi.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kimchi.biz.user.UserVO;

@Repository
public class UserDAOMybatis extends SqlSessionDaoSupport {
//	@Autowired
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		super.setSqlSessionFactory(sqlSessionFactory);
//	}
	@Autowired
	private SqlSessionTemplate mybatis;
	

	public UserVO getUser(UserVO vo) {
		System.out.println("------UserDAOMybatis의-getUser() 기능 처리");
		System.out.println(vo.toString());
		UserVO vo2=mybatis.selectOne("UserDAO.getUser", vo); //널포인터 오류나는 위치
		if(vo==null) {
			System.out.println("지금 아무것도 안받아오고있음");
		}
		System.out.println(vo.toString());
		System.out.println(vo2.toString());
		return vo2;
	}

	public void insertUser(UserVO vo) {
		System.out.println("------UserDAOMybatis의-insertUser() 기능 처리");
		mybatis.insert("UserDAO.insertUser", vo);//여기에서 입력은되고있으나 마찬가지로 db저장은 널포인터가 뜨므로
		//지금 문제인 것은 역시 mysql 연동,,,
	}

}
