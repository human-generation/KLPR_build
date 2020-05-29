package com.kimchi.biz.helpee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeVO;

@Repository("helpeeDAO")
public class HelpeeDAOImpl implements HelpeeDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	private final String HELPEE_INSERT = "INSERT INTO helpee (uno, edate, eplace, moving, hospital, immigration, lno, e_intro) VALUES(?,?,?,?,?,?,?,?)";
	
	@Override
	public void insertHelpee(HelpeeVO vo) {
		System.out.println("----HelpeeDAOImpl의-insertHelpee()기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_INSERT);
			stmt.setInt(1, vo.getUno());
			stmt.setString(2, vo.getEdate());
			stmt.setInt(3, vo.getEplace());
			stmt.setInt(4, vo.getMoving());
			stmt.setInt(5, vo.getHospital());
			stmt.setInt(6, vo.getImmigration());
			stmt.setInt(7, vo.getLno());
			stmt.setString(8, vo.getE_intro());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
