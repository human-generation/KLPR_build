package com.kimchi.biz.matching.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.matching.MatchingDAO;
import com.kimchi.biz.matching.MatchingVO;

@Repository("matchingDAO")
public class MatchingDAOImpl implements MatchingDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String MATCHING_INSERT = "INSERT INTO matching(seno, rcno, rno, eno, mdate, mplace, mservice, mstate) VALUES(?,?,?,?,?,?,?,?)";

	@Override
	public void insertMatching(MatchingVO vo) {
		System.out.println("MatchingDAOImpl의 - insertMatching() 기능 처리");

		MatchingVO matching = null;
		try {
			conn = JDBCUtil.getConnection();
			System.out.println(conn.toString());
			stmt = conn.prepareStatement(MATCHING_INSERT);
			stmt.setInt(1, vo.getSeno());
			stmt.setInt(2, vo.getRcno());
			stmt.setInt(3, vo.getRno());
			stmt.setInt(4, vo.getEno());
			stmt.setString(5, vo.getMdate());
			stmt.setInt(6, vo.getMplace());
			stmt.setInt(7, vo.getMservice());
			stmt.setInt(8, vo.getMstate());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

}
