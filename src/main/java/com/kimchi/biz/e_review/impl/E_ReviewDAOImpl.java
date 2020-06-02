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

@Repository("E_ReviewDAO")
public class E_ReviewDAOImpl implements E_ReviewDAO {
	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;


	private final String HELPEE_REVIEW_EVNO = "SELECT eno, truncate(AVG(escore), 1) AS avg FROM e_review GROUP BY eno ORDER BY avg";
	private final String HELPEE_REVIEW_COUNT = "SELECT eno, count(e_vno) AS count FROM e_review GROUP BY eno ORDER BY count";

	@Override
	// 헬피 리뷰 개수 세기
	public List<E_ReviewVO> getE_ReviewCountList(E_ReviewVO vo) {
		List<E_ReviewVO> countList = new ArrayList<E_ReviewVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_REVIEW_COUNT);
			rs = stmt.executeQuery();

			while (rs.next()) {

				E_ReviewVO e_reivew = new E_ReviewVO();
				e_reivew.setEno(rs.getInt("eno"));
				e_reivew.setCount(rs.getInt("count"));

				countList.add(e_reivew);
			}
			System.out.println("확인 뿨킹: " + countList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return countList;
	}

	@Override
	// 헬피 리뷰 평점 계산
	public List<E_ReviewVO> getE_ReviewAvgList(E_ReviewVO vo) {
		List<E_ReviewVO> avgList = new ArrayList<E_ReviewVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_REVIEW_EVNO);
			rs = stmt.executeQuery();

			while (rs.next()) {

				E_ReviewVO e_reivew = new E_ReviewVO();
				e_reivew.setEno(rs.getInt("eno"));
				e_reivew.setEscore(rs.getDouble("avg"));

				avgList.add(e_reivew);
			}
			System.out.println("E리뷰 확인 뿨킹: " + avgList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return avgList;
	}

}
