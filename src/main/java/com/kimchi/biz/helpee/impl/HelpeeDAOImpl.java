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
//		private final String HELPEELIST_GET = "SELECT eno,uno,edate,eplace,moving,hospital,immigration,lno,e_intro FROM helpee ORDER BY eno";
	private final String HELPEE_GET = "SELECT * FROM helpee WHERE eno=?";
	private final String HELPEE_INSERT = "INSERT INTO helpee (uno, edate, eplace, moving, hospital, immigration, lno, e_intro) VALUES(?,?,?,?,?,?,?,?)";
	private final String HELPEE_UPDATE = "UPDATE helpee SET edate=?, eplace=?, moving=?, hospital=?, immigration=?, e_intro=? WHERE eno=?";
	private final String HELPEE_DELETE = "DELETE FROM helpee WHERE eno=?";

	private final String HELPEELIST_GET = "SELECT u.uno, u.name, p.eno, p.edate, s.dno, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno";
	private final String HELPEE_DATE_DELETE = "DELETE FROM helpee WHERE edate < CURDATE()";
	private final String HELPEELIST_RECENTLY = "SELECT u.uno, u.name, p.eno, p.edate, s.dno, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno"
			+ " ORDER BY p.eno DESC";
	private final String HELPEELIST_SCORE = "SELECT DISTINCT h.eno, u.uno, u.name, h.edate, s.dno, s.district, h.moving, h.hospital, h.immigration, l.language, h.e_intro, IFNULL(truncate(AVG(er.escore), 1), '-none-') AS avg FROM helpee AS h JOIN user AS u ON h.uno=u.uno JOIN language AS l ON h.lno=l.lno JOIN seoul AS s ON s.dno=h.eplace LEFT JOIN e_review AS er ON er.eno = h.uno GROUP BY h.eno ORDER BY avg DESC";

	private final String HELPEE_MOVE = "SELECT u.uno, u.name, p.eno, p.edate, s.dno, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno WHERE p.moving=1";
	private final String HELPEE_HOSP = "SELECT u.uno, u.name, p.eno, p.edate, s.dno, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno WHERE p.hospital=1";
	private final String HELPEE_IMMI = "SELECT u.uno, u.name, p.eno, p.edate, s.dno, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro"
			+ " FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno WHERE p.immigration";

	private final String HELPEE_SEOUL = "SELECT u.uno, u.name, p.eno, p.edate, s.dno, s.district, p.moving, p.hospital, p.immigration, l.language, p.e_intro FROM helpee AS p JOIN user AS u ON p.uno=u.uno JOIN language AS l ON p.lno=l.lno JOIN seoul AS s ON p.eplace=s.dno WHERE p.eplace=?;";

	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImpl의-getHelpeeList() 기능 처리");

		List<HelpeeVO> helpeeList = new ArrayList<HelpeeVO>();

		try {
			conn = JDBCUtil.getConnection();
			System.out.println(conn.toString());
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
				seoul.setDno(rs.getInt("dno"));
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);
				helpee.setEno(rs.getInt("eno"));
				helpee.setEdate(rs.getString("edate"));
				helpee.setMoving(rs.getInt("moving"));
				helpee.setHospital(rs.getInt("hospital"));
				helpee.setImmigration(rs.getInt("immigration"));
				helpee.setE_intro(rs.getString("e_intro"));
				helpeeList.add(helpee);
			}
			System.out.println("getHelpeeList 값 확인: " + helpeeList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helpeeList;
	}

	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		System.out.println("----HelpeeDAOImpl의-getHelpee() 기능 처리");
		HelpeeVO helpee = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_GET);
			stmt.setInt(1, vo.getEno());
			rs = stmt.executeQuery();
			if (rs.next()) {
				helpee = new HelpeeVO();
				helpee.setEno(rs.getInt("eno"));
				helpee.setUno(rs.getInt("uno"));
				helpee.setEdate(rs.getString("edate"));
				helpee.setEplace(rs.getInt("eplace"));
				helpee.setMoving(rs.getInt("moving"));
				helpee.setHospital(rs.getInt("hospital"));
				helpee.setImmigration(rs.getInt("immigration"));
				helpee.setLno(rs.getInt("lno"));
				helpee.setE_intro(rs.getString("e_intro"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return helpee;
	}

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

	@Override
	public void updateHelpee(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImlp의-updateHelpee() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_UPDATE);
			stmt.setString(1, vo.getEdate());
			stmt.setInt(2, vo.getEplace());
			stmt.setInt(3, vo.getMoving());
			stmt.setInt(4, vo.getHospital());
			stmt.setInt(5, vo.getImmigration());
			stmt.setString(6, vo.getE_intro());
			stmt.setInt(7, vo.getEno());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	@Override
	public void deleteHelpee(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImlp의-deleteHelpee() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_DELETE);
			stmt.setInt(1, vo.getEno());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	// 날짜 지난 헬피 글 삭제하기
	@Override
	public void deleteDateHelpee(HelpeeVO vo) {
		System.out.println("===> JDBC로 deleteHelpee() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_DATE_DELETE);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 헬피리스트 최신순으로 정렬하기
	@Override
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
				seoul.setDno(rs.getInt("dno"));
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);
				helpee.setEno(rs.getInt("eno"));
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
	
	// 헬피리스트 최신순으로 정렬하기
	@Override
	public List<HelpeeVO> scoreHelpeeList(HelpeeVO vo) {
		System.out.println("------HelpeeDAOImpl의-scoreHelpeeList() 기능 처리");
		
		List<HelpeeVO> helpeeList = new ArrayList<HelpeeVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEELIST_SCORE);
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
				seoul.setDno(rs.getInt("dno"));
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);
				helpee.setEno(rs.getInt("eno"));
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
				seoul.setDno(rs.getInt("dno"));
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);
				helpee.setEno(rs.getInt("eno"));
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
				seoul.setDno(rs.getInt("dno"));
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);
				helpee.setEno(rs.getInt("eno"));
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
				seoul.setDno(rs.getInt("dno"));
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);
				helpee.setEno(rs.getInt("eno"));
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
			stmt.setInt(1, vo.getEplace());
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
				seoul.setDno(rs.getInt("dno"));
				seoul.setDistrict(rs.getString("district"));
				helpee.setSeoulVO(seoul);
				helpee.setEno(rs.getInt("eno"));
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
