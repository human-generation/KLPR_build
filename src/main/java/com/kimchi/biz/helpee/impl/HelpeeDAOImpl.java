package com.kimchi.biz.helpee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeVO;

<<<<<<< HEAD

@Repository("helpeeDAO")
public class HelpeeDAOImpl implements HelpeeDAO{
	
	// JDBC 관련 변수들
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;

		// SQL 명령어
		private final String HELPEELIST_GET = "SELECT edate,eplace,moving,hospital,immigration,lno,e_intro FROM helpee ORDER BY eno";
	
	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImpl의-getHelpeeList() 기능 처리");
		
		List<HelpeeVO> helpeeList = new ArrayList<HelpeeVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			System.out.println(conn.toString());
			stmt = conn.prepareStatement(HELPEELIST_GET);
			rs = stmt.executeQuery();
			while(rs.next()) {
				HelpeeVO helpee = new HelpeeVO();
				helpee.setEdate(rs.getString("edate"));
				helpee.setEplace(rs.getInt("eplace"));
				helpee.setMoving(rs.getInt("moving"));
				helpee.setHospital(rs.getInt("hospital"));
				helpee.setImmigration(rs.getInt("immigration"));
				helpee.setE_intro(rs.getString("e_intro"));
				helpeeList.add(helpee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helpeeList;
	}
	
	

=======
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
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
}
