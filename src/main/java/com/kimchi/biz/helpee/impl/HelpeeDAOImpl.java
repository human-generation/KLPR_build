package com.kimchi.biz.helpee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.e_review.E_ReviewVO;
import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeVO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

@Repository("helpeeDAO")
public class HelpeeDAOImpl implements HelpeeDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String HELPEELIST_GET = "SELECT u.uno, u.name, p.edate, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno";
	private final String HELPEE_DELETE = "DELETE FROM helpee WHERE edate < CURDATE()";
	private final String HELPEELIST_RECENTLY = "SELECT u.uno, u.name, p.edate, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno"
			+ " ORDER BY p.eno DESC";
	
	private final String HELPEE_MOVE = "SELECT u.uno, u.name, p.edate, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno WHERE p.moving=1";
	private final String HELPEE_HOSP = "SELECT u.uno, u.name, p.edate, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno WHERE p.hospital=1";
	private final String HELPEE_IMMI = "SELECT u.uno, u.name, p.edate, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno WHERE p.immigration";
	
	private final String HELPEE_SEOUL = "SELECT u.uno, u.name, p.edate, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno"
			+ " WHERE p.eplace=?";

	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	// 모든 헬피 리스트 출력
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImpl의-getHelpeeList() 기능 처리");

		List<HelpeeVO> helpeeList = new ArrayList<HelpeeVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEELIST_GET);
			rs = stmt.executeQuery();

			while (rs.next()) {
				HelpeeVO helpee = new HelpeeVO();

				UserVO user = new UserVO();
				user.setUno(rs.getInt("uno"));
				user.setName(rs.getString("name"));
				helpee.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helpee.setLanguageVO(language);

				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);

				helpee.setEdate(rs.getString("edate"));
				helpee.setMoving(rs.getInt("moving"));
				helpee.setHospital(rs.getInt("hospital"));
				helpee.setImmigration(rs.getInt("immigration"));
				helpee.setE_intro(rs.getString("e_intro"));
				helpeeList.add(helpee);
			}
			System.out.println("확인 뿨킹: " + helpeeList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helpeeList;
	}

	@Override
	// 날짜 지난 헬피 글 삭제하기
	public void deleteHelpee(HelpeeVO vo) {
		System.out.println("===> JDBC로 deleteHelpee() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_DELETE);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	// 헬피리스트 최신순으로 정렬하기
	public List<HelpeeVO> recentHelpeeList(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImpl의-recentHelpeeList() 기능 처리");

		List<HelpeeVO> helpeeList = new ArrayList<HelpeeVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEELIST_RECENTLY);
			rs = stmt.executeQuery();

			while (rs.next()) {
				HelpeeVO helpee = new HelpeeVO();

				UserVO user = new UserVO();
				user.setUno(rs.getInt("uno"));
				user.setName(rs.getString("name"));
				helpee.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helpee.setLanguageVO(language);

				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);

				helpee.setEdate(rs.getString("edate"));
				helpee.setMoving(rs.getInt("moving"));
				helpee.setHospital(rs.getInt("hospital"));
				helpee.setImmigration(rs.getInt("immigration"));
				helpee.setE_intro(rs.getString("e_intro"));
				helpeeList.add(helpee);
			}
			System.out.println("확인 뿨킹: " + helpeeList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helpeeList;
	}

	@Override
	public List<HelpeeVO> moveHelpee(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImpl의-moveHelpee() 기능 처리");

		List<HelpeeVO> helpeeList = new ArrayList<HelpeeVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_MOVE);
			rs = stmt.executeQuery();

			while (rs.next()) {
				HelpeeVO helpee = new HelpeeVO();

				UserVO user = new UserVO();
				user.setUno(rs.getInt("uno"));
				user.setName(rs.getString("name"));
				helpee.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helpee.setLanguageVO(language);

				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);

				helpee.setEdate(rs.getString("edate"));
				helpee.setMoving(rs.getInt("moving"));
				helpee.setHospital(rs.getInt("hospital"));
				helpee.setImmigration(rs.getInt("immigration"));
				helpee.setE_intro(rs.getString("e_intro"));
				helpeeList.add(helpee);
			}
			System.out.println("확인 뿨킹: " + helpeeList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helpeeList;
	}


	@Override
	public List<HelpeeVO> hospitalHelpee(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImpl의-hospitalHelpee() 기능 처리");

		List<HelpeeVO> helpeeList = new ArrayList<HelpeeVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_HOSP);
			rs = stmt.executeQuery();

			while (rs.next()) {
				HelpeeVO helpee = new HelpeeVO();

				UserVO user = new UserVO();
				user.setUno(rs.getInt("uno"));
				user.setName(rs.getString("name"));
				helpee.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helpee.setLanguageVO(language);

				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);

				helpee.setEdate(rs.getString("edate"));
				helpee.setMoving(rs.getInt("moving"));
				helpee.setHospital(rs.getInt("hospital"));
				helpee.setImmigration(rs.getInt("immigration"));
				helpee.setE_intro(rs.getString("e_intro"));
				helpeeList.add(helpee);
			}
			System.out.println("확인 뿨킹: " + helpeeList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helpeeList;
	}


	@Override
	public List<HelpeeVO> immigrationHelpee(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImpl의-immigrationHelpee() 기능 처리");

		List<HelpeeVO> helpeeList = new ArrayList<HelpeeVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_IMMI);
			rs = stmt.executeQuery();

			while (rs.next()) {
				HelpeeVO helpee = new HelpeeVO();

				UserVO user = new UserVO();
				user.setUno(rs.getInt("uno"));
				user.setName(rs.getString("name"));
				helpee.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helpee.setLanguageVO(language);

				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);

				helpee.setEdate(rs.getString("edate"));
				helpee.setMoving(rs.getInt("moving"));
				helpee.setHospital(rs.getInt("hospital"));
				helpee.setImmigration(rs.getInt("immigration"));
				helpee.setE_intro(rs.getString("e_intro"));
				helpeeList.add(helpee);
			}
			System.out.println("확인 뿨킹: " + helpeeList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helpeeList;
	}


	@Override
	public List<HelpeeVO> seoulHelpeeList(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImpl의-seoulHelpeeList() 기능 처리");

		List<HelpeeVO> helpeeList = new ArrayList<HelpeeVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_SEOUL);
			rs = stmt.executeQuery();

			while (rs.next()) {
				HelpeeVO helpee = new HelpeeVO();

				UserVO user = new UserVO();
				user.setUno(rs.getInt("uno"));
				user.setName(rs.getString("name"));
				helpee.setUserVO(user);

				LanguageVO language = new LanguageVO();
				language.setLanguage(rs.getString("language"));
				helpee.setLanguageVO(language);

				SeoulVO seoul = new SeoulVO();
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);

				helpee.setEdate(rs.getString("edate"));
				helpee.setMoving(rs.getInt("moving"));
				helpee.setHospital(rs.getInt("hospital"));
				helpee.setImmigration(rs.getInt("immigration"));
				helpee.setE_intro(rs.getString("e_intro"));
				helpeeList.add(helpee);
			}
			System.out.println("확인 뿨킹: " + helpeeList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helpeeList;
	}
	
	 

}
