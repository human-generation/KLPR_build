package com.kimchi.biz.helper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.user.UserVO;

public class HelperDAOImpl implements HelperDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String HELPER_GET = "SELECT * FROM helper WHERE rno=?";
	
	private final String HELPER_MOVING = "SELECT * FROM helper WHERE moving=1";
	private final String HELPER_HOSPITAL = "SELECT * FROM helper WHERE hospital=1";
	private final String HELPER_IMMIGRATION = "SELECT * FROM helper WHERE immigration=1";

	@Override
	public HelperVO getHelper(HelperVO vo) {
		System.out.println("selectHelper 기능 처리");

		HelperVO helper = null;
		try {
			conn = JDBCUtil.getConnection();
			System.out.println(conn.toString());
			stmt = conn.prepareStatement(HELPER_GET);
			stmt.setInt(1, vo.getRno());
			rs = stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helper;
	}

	@Override
	public HelperVO getMoving(HelperVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelperVO getHospital(HelperVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelperVO getImmigration(HelperVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
