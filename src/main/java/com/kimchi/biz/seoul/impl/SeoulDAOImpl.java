package com.kimchi.biz.seoul.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.seoul.SeoulDAO;
import com.kimchi.biz.seoul.SeoulVO;

@Repository("SeoulDAO")
public class SeoulDAOImpl implements SeoulDAO {
	
	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 문
	private final String SEOULLIST_GET = "SELECT dno, district FROM seoul ORDER BY dno";

	@Override
	public List<SeoulVO> getSeoulList(SeoulVO vo) {
		System.out.println("===> JDBC로 getSeoulList() 기능 처리");
		
		List<SeoulVO> seoulList = new ArrayList<SeoulVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SEOULLIST_GET);
			rs = stmt.executeQuery();
			while(rs.next()) {
				SeoulVO seoul = new SeoulVO();
				seoul.setDno(rs.getInt("dno"));
				seoul.setDistrict(rs.getString("district"));
				seoulList.add(seoul);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return seoulList;
	}
	
}
