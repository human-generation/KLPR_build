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
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.user.UserVO;

@Repository("HelperDAO")
public class HelperDAOImpl implements HelperDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String HELPERLIST_GET = "SELECT u.name, h.sta, h.end, h.rplace, h.moving, h.hospital, h.immigration, l.language, h.r_intro"
			+ " FROM helper AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno";
	private final String HELPER_DELETE = "DELETE FROM helper WHERE end < CURDATE()";
	private final String HELPERLIST_RECENTLY = "SELECT u.name, h.sta, h.end, h.rplace, h.moving, h.hospital, h.immigration, l.language, h.r_intro"
			+ " FROM helper AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno ORDER BY h.rno DESC";

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

				UserVO user = new UserVO();
				user.setName(rs.getString("name"));
				helper.setUserVO(user);
				
				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helper.setLanguageVO(language);

				helper.setSta(rs.getDate("sta"));
				helper.setEnd(rs.getDate("end"));
				helper.setRplace(rs.getInt("rplace"));
				helper.setMoving(rs.getInt("moving"));
				helper.setHospital(rs.getInt("hospital"));
				helper.setImmigration(rs.getInt("immigration"));
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
	public void deleteHelper(HelperVO vo) { // 날짜지난 헬퍼글 삭제하기
		System.out.println("===> JDBC로 deleteHelper() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_DELETE);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public List<HelperVO> recentHelperList(HelperVO vo) {	// 헬퍼리스트 최신순으로 정렬하기
		System.out.println("===> JDBC로 recentHelperList() 기능 처리");

		List<HelperVO> helperList = new ArrayList<HelperVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPERLIST_RECENTLY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				HelperVO helper = new HelperVO();

				UserVO user = new UserVO();
				user.setName(rs.getString("name"));
				helper.setUserVO(user);
				
				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helper.setLanguageVO(language);

				helper.setSta(rs.getDate("sta"));
				helper.setEnd(rs.getDate("end"));
				helper.setRplace(rs.getInt("rplace"));
				helper.setMoving(rs.getInt("moving"));
				helper.setHospital(rs.getInt("hospital"));
				helper.setImmigration(rs.getInt("immigration"));
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
