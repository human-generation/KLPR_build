package com.kimchi.biz.helper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.helper.HelperDAO;
import com.kimchi.biz.helper.HelperVO;

@Repository("HelperDAO")
public class HelperDAOImpl implements HelperDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어 
	private final String HELPERLIST_GET = "SELECT sta, end, rplace, moving, hospital, immigration, lno, r_intro FROM helper";
//	private final String HELPER_LIST = "SELECT u.name, u.comment, r.rscore, h.sta, h.end, "
//			+ "h.rplace, h.moving, h.hospital, h.immigration, h.lno FROM helper AS h "
//			+ "JOIN r_review AS r JOIN user AS u ORDER BY r.rno DESC";

	@Override
	public List<HelperVO> getHelperList(HelperVO vo) { // 모든 헬퍼 리스트 보여주기
		System.out.println("===> JDBC로 getHelperList() 기능 처리");
		
		List<HelperVO> helperList = new ArrayList<HelperVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPERLIST_GET);
			rs = stmt.executeQuery();
			while (rs.next()) {
				HelperVO helper = new HelperVO();
				helper.setSta(rs.getDate("sta"));
				helper.setEnd(rs.getDate("end"));
				helper.setRplace(rs.getInt("rplace"));
				helper.setMoving(rs.getInt("moving"));
				helper.setHospital(rs.getInt("hospital"));
				helper.setImmigration(rs.getInt("immigration"));
				helper.setLno(rs.getInt("lno"));
				helper.setR_intro(rs.getString("r_intro"));
				helperList.add(helper);
			}
			System.out.println("확인시발: " + helperList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helperList;
	}

	@Override
	public HelperVO getHelper(HelperVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
