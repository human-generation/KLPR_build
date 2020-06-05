package com.kimchi.biz.r_review.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	private final String HELPER_REVIEW_EVNO = "SELECT rno, truncate(AVG(rscore), 1) AS avg FROM r_review GROUP BY rno ORDER BY avg";
	private final String HELPER_REVIEW_COUNT = "SELECT rno, count(r_vno) AS count FROM r_review GROUP BY rno ORDER BY count";

	@Override
	public List<R_reviewVO> getR_ReviewCountList(R_reviewVO vo) { // 헬퍼 리뷰갯수 세기
		List<R_reviewVO> countList = new ArrayList<R_reviewVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_REVIEW_COUNT);
			rs = stmt.executeQuery();

			while (rs.next()) {
				R_reviewVO r_reivew = new R_reviewVO();
				r_reivew.setRno(rs.getInt("rno"));
				r_reivew.setCount(rs.getInt("count"));

				countList.add(r_reivew);
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
	public List<R_reviewVO> getR_ReviewAvgList(R_reviewVO vo) { // 헬퍼 평점
		List<R_reviewVO> avgList = new ArrayList<R_reviewVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_REVIEW_EVNO);
			rs = stmt.executeQuery();

			while (rs.next()) {

				R_reviewVO r_reivew = new R_reviewVO();
				r_reivew.setRno(rs.getInt("rno"));
				r_reivew.setRscore(rs.getDouble("avg"));

				avgList.add(r_reivew);
			}
			System.out.println("R리뷰 확인 뿨킹: " + avgList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return avgList;
	}

}
