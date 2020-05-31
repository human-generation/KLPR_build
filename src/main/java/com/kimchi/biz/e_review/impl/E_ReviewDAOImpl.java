package com.kimchi.biz.e_review.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.e_review.E_ReviewDAO;
import com.kimchi.biz.e_review.E_ReviewVO;

@Repository("e_reviewDAO")
public class E_ReviewDAOImpl implements E_ReviewDAO {

	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String E_REVIEW_INSERT = "INSERT INTO e_review(eno, rno, ecomment, escore) VALUES(?,?,?,?)";
	private final String E_REVIEW_GET = "SELECT * FROM e_review WHERE e_vno=?";
	private final String E_REVIEW_LIST = "SELECT * FROM e_review ORDER BY e_vno ASC";

	// 헬피가 받는 리뷰 입력
	@Override
	public void insertE_Review(E_ReviewVO vo) {
		System.out.println("-----E_ReviewDAOImpl의-insertE_Review() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(E_REVIEW_INSERT);
			stmt.setInt(1, vo.getEno());
			stmt.setInt(2, vo.getRno());
			stmt.setString(3, vo.getEcomment());
			stmt.setInt(4, vo.getEscore());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 헬피가 받은 리뷰 상세 조회
	@Override
	public E_ReviewVO getE_Review(E_ReviewVO vo) {
		System.out.println("-----E_ReviewDAOImpl의-getE_Review() 기능 처리");
		E_ReviewVO e_review = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(E_REVIEW_GET);
			stmt.setInt(1, vo.getE_vno());
			rs = stmt.executeQuery();
			if (rs.next()) {
				e_review = new E_ReviewVO();
				e_review.setE_vno(rs.getInt("e_vno"));
				e_review.setEno(rs.getInt("eno"));
				e_review.setRno(rs.getInt("rno"));
				e_review.setEcomment(rs.getString("ecomment"));
				e_review.setEscore(rs.getInt("escore"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return e_review;
	}

	// 헬피가 받은 리뷰 목록
	@Override
	public List<E_ReviewVO> getE_ReviewList(E_ReviewVO vo) {
		System.out.println("-----E_ReviewDAOImpl의-getE_ReviewList() 기능 처리");
		System.out.println(vo.toString());
		List<E_ReviewVO> e_reviewList = new ArrayList<E_ReviewVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(E_REVIEW_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				E_ReviewVO e_review = new E_ReviewVO();
				e_review.setE_vno(rs.getInt("e_vno"));
				e_review.setEno(rs.getInt("eno"));
				e_review.setRno(rs.getInt("rno"));
				e_review.setEcomment(rs.getString("ecomment"));
				e_review.setEscore(rs.getInt("escore"));
				e_reviewList.add(e_review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return e_reviewList;
	}

}
