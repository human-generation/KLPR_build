package com.kimchi.biz.r_review.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.r_review.R_reviewDAO;
import com.kimchi.biz.r_review.R_reviewVO;
import com.kimchi.biz.user.UserVO;


@Repository("r_reviewDAO")	
public class R_reviewDAOImpl implements R_reviewDAO {
	
	// JDBC 관련 변수들
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;

		// SQL 명령어
		private final String R_REVIEW_SELECT = "SELECT rno FROM matching WHERE eno=? AND mstate=3";
		private final String R_REVIEW_INSERT = "INSERT INTO r_review (eno, rno, rcomment, rscore) VALUES(?,?,?,?)";
		private final String R_REVIEW_UPDATE = "UPDATE matching SET mstate=4 WHERE eno=? AND rno=? AND mstate=3";
		
		
		@Override
		public void insertR_review(R_reviewVO vo) {
			
			System.out.println("------R_reviewDAOImlp의-insertR_review() 기능 처리");
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(R_REVIEW_SELECT);
				stmt.setInt(1, vo.getUno());			//eno == uno : 헬피 번호(작성자)
				
				rs = stmt.executeQuery();
				if (rs.next()) {
					vo.setRno(rs.getInt("rno"));		//rno : 헬퍼 번호 
				}
				//+에러처리 추가 : matching 테이블에서 헬퍼번호(rno)를 못 받아왔을 때
								
				stmt = conn.prepareStatement(R_REVIEW_INSERT);
								
				stmt.setInt(1, vo.getUno());			//헬피 번호(작성자)
				stmt.setInt(2, vo.getRno());			//헬퍼 번호
				stmt.setString(3, vo.getRcomment());
				stmt.setInt(4, vo.getRscore());
				stmt.executeUpdate();
				//+에러처리 추가 : r_review 테이블 insert 실패 시(리뷰 작성 실패) 
				
				
				stmt = conn.prepareStatement(R_REVIEW_UPDATE);
				
				stmt.setInt(1, vo.getUno());			//헬피 번호(작성자)
				stmt.setInt(2, vo.getRno());			//헬퍼 번호
				stmt.executeUpdate();
				//+에러처리 추가 : matching 테이블 mstate 컬럼 4로 update 못 했을 때
				
			} catch (Exception e) {
				
				e.printStackTrace();
			} finally {
				JDBCUtil.close(stmt, conn);
			}
		}
		
}