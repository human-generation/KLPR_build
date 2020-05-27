package com.kimchi.biz.helpee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeVO;


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
	
	

}
