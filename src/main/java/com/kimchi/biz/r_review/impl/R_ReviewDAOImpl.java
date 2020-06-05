package com.kimchi.biz.r_review.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.r_review.R_ReviewDAO;
import com.kimchi.biz.r_review.R_ReviewVO;

@Repository("r_reviewDAO")
public class R_ReviewDAOImpl implements R_ReviewDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String R_REVIEW_SELECT = "SELECT rno FROM matching WHERE eno=? AND mstate=3";
	private final String R_REVIEW_INSERT = "INSERT INTO r_review (eno, rno, rcomment, rscore) VALUES(?,?,?,?)";
	private final String R_REVIEW_UPDATE = "UPDATE matching SET mstate=4 WHERE eno=? AND rno=? AND mstate=3";
	private final String R_REVIEW_GET = "SELECT * FROM r_review WHERE r_vno=?";
	private final String R_REVIEW_LIST = "SELECT * FROM r_review ORDER BY r_vno ASC";

	private final String HELPER_REVIEW_EVNO = "SELECT hp.uno, IFNULL(truncate(AVG(rr.rscore), 1), '-none-') AS avg FROM helper AS hp LEFT JOIN r_review AS rr ON rr.rno = hp.uno GROUP BY hp.uno";
	private final String HELPER_REVIEW_COUNT = "SELECT rno, count(r_vno) AS count FROM r_review GROUP BY rno ORDER BY count";

	@Override
	public void insertR_review(R_ReviewVO vo) {

		System.out.println("------R_reviewDAOImlp의-insertR_review() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(R_REVIEW_SELECT);
			stmt.setInt(1, vo.getUno()); // eno == uno : 헬피 번호(작성자)

			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setRno(rs.getInt("rno")); // rno : 헬퍼 번호
			}
			// +에러처리 추가 : matching 테이블에서 헬퍼번호(rno)를 못 받아왔을 때

			stmt = conn.prepareStatement(R_REVIEW_INSERT);

			stmt.setInt(1, vo.getUno()); // 헬피 번호(작성자)
			stmt.setInt(2, vo.getRno()); // 헬퍼 번호
			stmt.setString(3, vo.getRcomment());
			stmt.setInt(4, vo.getRscore());
			stmt.executeUpdate();
			// +에러처리 추가 : r_review 테이블 insert 실패 시(리뷰 작성 실패)

			stmt = conn.prepareStatement(R_REVIEW_UPDATE);

			stmt.setInt(1, vo.getUno()); // 헬피 번호(작성자)
			stmt.setInt(2, vo.getRno()); // 헬퍼 번호
			stmt.executeUpdate();
			// +에러처리 추가 : matching 테이블 mstate 컬럼 4로 update 못 했을 때

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 헬피가 받은 리뷰 상세 조회
	@Override
	public R_ReviewVO getR_Review(R_ReviewVO vo) {
		System.out.println("-----R_ReviewDAOImpl의-getR_Review() 기능 처리");
		R_ReviewVO r_review = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(R_REVIEW_GET);
			stmt.setInt(1, vo.getR_vno());
			rs = stmt.executeQuery();
			if (rs.next()) {
				r_review = new R_ReviewVO();
				r_review.setR_vno(rs.getInt("r_vno"));
				r_review.setEno(rs.getInt("eno"));
				r_review.setRno(rs.getInt("rno"));
				r_review.setRcomment(rs.getString("rcomment"));
				r_review.setRscore(rs.getInt("rscore"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return r_review;
	}

	// 헬피가 받은 리뷰 목록
	@Override
	public List<R_ReviewVO> getR_ReviewList(R_ReviewVO vo) {
		System.out.println("-----E_ReviewDAOImpl의-getE_ReviewList() 기능 처리");
		System.out.println(vo.toString());
		List<R_ReviewVO> r_reviewList = new ArrayList<R_ReviewVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(R_REVIEW_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				R_ReviewVO r_review = new R_ReviewVO();
				r_review.setR_vno(rs.getInt("r_vno"));
				r_review.setEno(rs.getInt("eno"));
				r_review.setRno(rs.getInt("rno"));
				r_review.setRcomment(rs.getString("rcomment"));
				r_review.setRscore(rs.getInt("rscore"));
				r_reviewList.add(r_review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return r_reviewList;
	}

	@Override
	public List<R_ReviewVO> getR_ReviewCountList(R_ReviewVO vo) { // 헬퍼 리뷰갯수 세기
		List<R_ReviewVO> countList = new ArrayList<R_ReviewVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_REVIEW_COUNT);
			rs = stmt.executeQuery();

			while (rs.next()) {
				R_ReviewVO r_reivew = new R_ReviewVO();
				r_reivew.setRno(rs.getInt("rno"));
				r_reivew.setCount(rs.getInt("count"));

				countList.add(r_reivew);
			}
			System.out.println("countList 확인: " + countList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return countList;
	}

	@Override
	public List<R_ReviewVO> getR_ReviewAvgList(R_ReviewVO vo) { // 헬퍼 평점
		List<R_ReviewVO> avgList = new ArrayList<R_ReviewVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_REVIEW_EVNO);
			rs = stmt.executeQuery();

			while (rs.next()) {

				R_ReviewVO r_reivew = new R_ReviewVO();
				r_reivew.setRno(rs.getInt("hp.uno"));
				r_reivew.setR_avg(rs.getString("avg"));

				avgList.add(r_reivew);
			}
			System.out.println("R리뷰 확인 : " + avgList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return avgList;
	}

}