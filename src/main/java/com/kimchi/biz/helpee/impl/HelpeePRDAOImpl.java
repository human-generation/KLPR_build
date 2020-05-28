package com.kimchi.biz.helpee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.helpee.HelpeePRDAO;
import com.kimchi.biz.helpee.HelpeePRVO;

@Repository("helpeeDAO")
public class HelpeePRDAOImpl implements HelpeePRDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	private final String EPR_INSERT = "INSERT INTO helpee (edate, eplace, moving, hospital, immigration, lno, e_intro) VALUES(?,?,?,?,?,?,?)";
	
	public void insertEPR(HelpeePRVO vo) {
		System.out.println("----HelpeePRDAOImpl의-insertEPR()기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(EPR_INSERT);
			stmt.setString(1, vo.getEdate());
			stmt.setInt(2, vo.getEplace());
			stmt.setInt(3, vo.getMoving());
			stmt.setInt(4, vo.getHospital());
			stmt.setInt(5, vo.getImmigration());
			stmt.setInt(6, vo.getLno());
			stmt.setString(7, vo.getEIntro());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
