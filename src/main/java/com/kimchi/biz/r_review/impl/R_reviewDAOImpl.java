package com.kimchi.biz.r_review.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.r_review.R_reviewDAO;
import com.kimchi.biz.r_review.R_reviewVO;

@Repository("R_reviewDAO")	
public class R_reviewDAOImpl implements R_reviewDAO {
	
	// JDBC 관련 변수들
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;

		// SQL 명령어
		private final String R_review_INSERT = "INSERT INTO R_review (rno, eno, rcomment, rscore) VALUES(?,?,?,?)";
				
		@Override
		public void insertR_review(R_reviewVO vo) {
			System.out.println("------R_reviewDAOImlp의-insertR_review() 기능 처리");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(R_review_INSERT);
				stmt.setInt(1, vo.getRno());
				stmt.setInt(2, vo.getEno());
				stmt.setString(3, vo.getRcomment());
				stmt.setInt(4, vo.getRscore());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}
		
}
