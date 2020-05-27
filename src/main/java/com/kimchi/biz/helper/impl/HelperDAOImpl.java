package com.kimchi.biz.helper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperVO;

@Repository("helperDAO")
public class HelperDAOImpl implements HelperDAO{
	//JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	//SQL 명령어 
	private final String HELPER_GET = "SELECT * FROM helper WHERE rno=?";
	private final String HELPER_INSERT = "INSERT INTO helper(uno, sta, end, rplace, moving, hospital, immigration, lno, r_intro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String HELPER_UPDATE = "";
	private final String HELPER_DELETE = "";
	
	@Override
	public HelperVO getHelper(HelperVO vo) {
		System.out.println("------HelperDAOImlp의-getHelper() 기능 처리");
		
		HelperVO helper = null;
		try {

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helper;
	}
	
	
	@Override
	public void insertHelper(HelperVO vo) {
		System.out.println("------HelperDAOImlp의-insertHelper() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_INSERT);
			stmt.setInt(1, vo.getUno());
			stmt.setString(2, vo.getSta());
			stmt.setString(3, vo.getEnd());
			stmt.setInt(4, vo.getRplace());
			stmt.setInt(5,vo.getMoving());
			stmt.setInt(6, vo.getHospital());
			stmt.setInt(7, vo.getImmigration());
			stmt.setInt(8, vo.getLno());
			stmt.setString(9, vo.getR_intro());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	
}
