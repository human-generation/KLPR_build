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
import com.kimchi.biz.r_review.R_reviewVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

@Repository("HelperDAO")
public class HelperDAOImpl implements HelperDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String HELPERLIST_GET = "SELECT u.name, h.sta, h.end, s.district, h.moving, h.hospital, h.immigration, l.language, h.r_intro"
			+ " FROM helper AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno JOIN seoul AS s ON s.dno=h.rplace";
	private final String HELPER_DELETE = "DELETE FROM helper WHERE end < CURDATE()";
	private final String HELPERLIST_RECENTLY = "SELECT u.name, h.sta, h.end, s.district, h.moving, h.hospital, h.immigration, l.language, h.r_intro"
			+ " FROM helper AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno JOIN seoul AS s ON s.dno=h.rplace ORDER BY h.rno DESC";
	private final String HELPERLIST_SCORE = "SELECT u.name, h.sta, h.end, s.district, TRUNCATE(AVG(r.rscore),1) AS avg, h.moving, h.hospital, h.immigration, l.language, h.r_intro"
			+ " FROM helper AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno JOIN r_review AS r ON h.rno=r.rno"
			+ " JOIN seoul AS s ON s.dno=h.rplace GROUP BY r.rno ORDER BY avg DESC";
	
	private final String HELPER_MOVE = "SELECT u.name, h.sta, h.end, s.district, h.moving, h.hospital, h.immigration, l.language, h.r_intro"
			+ " FROM helper AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno JOIN seoul AS s ON s.dno=h.rplace WHERE h.moving=1";
	private final String HELPER_HOSP = "SELECT u.name, h.sta, h.end, s.district, h.moving, h.hospital, h.immigration, l.language, h.r_intro"
			+ " FROM helper AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno JOIN seoul AS s ON s.dno=h.rplace WHERE h.hospital=1";
	private final String HELPER_IMMI = "SELECT u.name, h.sta, h.end, s.district, h.moving, h.hospital, h.immigration, l.language, h.r_intro"
			+ " FROM helper AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno JOIN seoul AS s ON s.dno=h.rplace WHERE h.immigration=1";
	
	private final String HELPER_SEOUL = "SELECT u.name, h.sta, h.end, s.district, h.moving, h.hospital, h.immigration, l.language, h.r_intro"
			+ " FROM helper AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno JOIN seoul AS s ON s.dno=h.rplace"
			+ " WHERE s.dno=?";
	
//	private final String HELPER_AVG = "SELECT TRUNCATE(AVG(rscore),1) AS avg FROM r_review GROUP BY rno ORDER BY avg DESC";
	
	@Override
	public List<HelperVO> getHelperList(HelperVO vo) { // 모든 헬퍼 리스트 보여주기
		System.out.println("===> JDBC로 getHelperList() 기능 처리");

		List<HelperVO> helperList = new ArrayList<HelperVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPERLIST_GET);
			rs = stmt.executeQuery();

			deleteHelper(vo);
			
			while (rs.next()) {
				HelperVO helper = new HelperVO();

				UserVO user = new UserVO();
				user.setName(rs.getString("name"));
				helper.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helper.setLanguageVO(language);
				
				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helper.setSeoulVO(seoul);
				
//				R_reviewVO r_review = new R_reviewVO();
//				r_review.setAvg(rs.getDouble("avg"));
//				helper.setR_reviewVO(r_review);

				helper.setSta(rs.getDate("sta"));
				helper.setEnd(rs.getDate("end"));
//				helper.setRplace(rs.getInt("rplace"));
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
	public List<HelperVO> recentHelperList(HelperVO vo) { // 헬퍼리스트 최신순으로 정렬하기
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
				
				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helper.setSeoulVO(seoul);

				helper.setSta(rs.getDate("sta"));
				helper.setEnd(rs.getDate("end"));
//				helper.setRplace(rs.getInt("rplace"));
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
	public List<HelperVO> scoreHelperList(HelperVO vo) { // 헬퍼리스트 평점순으로 정렬하기
		System.out.println("===> JDBC로 scoreHelperList() 기능 처리");

		List<HelperVO> helperList = new ArrayList<HelperVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPERLIST_SCORE);
			rs = stmt.executeQuery();
			while (rs.next()) {
				HelperVO helper = new HelperVO();

				UserVO user = new UserVO();
				user.setName(rs.getString("name"));
				helper.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helper.setLanguageVO(language);
				
				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helper.setSeoulVO(seoul);

				R_reviewVO r_review = new R_reviewVO();
				r_review.setAvg(rs.getInt("avg"));
				helper.setR_reviewVO(r_review);
				
				helper.setSta(rs.getDate("sta"));
				helper.setEnd(rs.getDate("end"));
//				helper.setRplace(rs.getInt("rplace"));
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
	public List<HelperVO> moveHelper(HelperVO vo) {	// 이사 헬퍼 리스트
		System.out.println("===> JDBC로 MoveHelper() 기능 처리");

		List<HelperVO> helperList = new ArrayList<HelperVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_MOVE);
			rs = stmt.executeQuery();
			while (rs.next()) {
				HelperVO helper = new HelperVO();

				UserVO user = new UserVO();
				user.setName(rs.getString("name"));
				helper.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helper.setLanguageVO(language);
				
				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helper.setSeoulVO(seoul);

				helper.setSta(rs.getDate("sta"));
				helper.setEnd(rs.getDate("end"));
//				helper.setRplace(rs.getInt("rplace"));
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
	public List<HelperVO> hospitalHelper(HelperVO vo) {	// 병원 헬퍼 리스트
		System.out.println("===> JDBC로 hospitalHelper() 기능 처리");

		List<HelperVO> helperList = new ArrayList<HelperVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_HOSP);
			rs = stmt.executeQuery();
			while (rs.next()) {
				HelperVO helper = new HelperVO();

				UserVO user = new UserVO();
				user.setName(rs.getString("name"));
				helper.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helper.setLanguageVO(language);

				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helper.setSeoulVO(seoul);
				
				helper.setSta(rs.getDate("sta"));
				helper.setEnd(rs.getDate("end"));
//				helper.setRplace(rs.getInt("rplace"));
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
	public List<HelperVO> immigrationHelper(HelperVO vo) {	// 출입국 헬퍼 리스트
		System.out.println("===> JDBC로 immigrationHelper() 기능 처리");

		List<HelperVO> helperList = new ArrayList<HelperVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_IMMI);
			rs = stmt.executeQuery();
			while (rs.next()) {
				HelperVO helper = new HelperVO();

				UserVO user = new UserVO();
				user.setName(rs.getString("name"));
				helper.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helper.setLanguageVO(language);
				
				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helper.setSeoulVO(seoul);
				
				helper.setSta(rs.getDate("sta"));
				helper.setEnd(rs.getDate("end"));
//				helper.setRplace(rs.getInt("rplace"));
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
	public List<HelperVO> helper_avg(HelperVO vo) {
		System.out.println("===> JDBC로 헬퍼 평점 담아지나요?");
		
		List<HelperVO> helperList = new ArrayList<HelperVO>();
		return helperList;
	}
	
	@Override
	public HelperVO getHelper(HelperVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
