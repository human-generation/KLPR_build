package com.kimchi.biz.e_review.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.e_review.E_ReviewDAO;
import com.kimchi.biz.e_review.E_ReviewVO;

@Repository("E_ReviewDAO")
public class E_ReviewDAOImpl implements E_ReviewDAO{
	// JDBC 관련 변수들
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;

		// SQL 명령어
		private final String COUNT_EVNO = "SELECT ";

		@Override
		public E_ReviewVO countE_vno(E_ReviewVO vo) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public E_ReviewVO avgEscore(E_ReviewVO vo) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
}
