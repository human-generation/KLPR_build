package com.kimchi.biz.matching.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.matching.MatchingDAO;
import com.kimchi.biz.matching.MatchingVO;

@Repository("matchingDAO")
public class MatchingDAOImpl implements MatchingDAO {

	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String MATCHING_INSERT = "INSERT INTO matching(seno, rcno, rno, eno, mdate, mplace, mservice, mstate) VALUES(?,?,?,?,?,?,?,?)";
	private final String MATCHING_UPDATE_STATE2 = "UPDATE matching SET mstate=2 WHERE mno=?";
	private final String MATCHING_UPDATE_STATE3 = "UPDATE matching SET mstate=3 WHERE mno=?";
	private final String MATCHING_UPDATE_STATE4 = "UPDATE matching SET mstate=4 WHERE mno=?";
	private final String MATCHING_UPDATE_STATE5 = "UPDATE matching SET mstate=5 WHERE mno=?";
	private final String MATCHING_GET = "SELECT * FROM matching WHERE mno=?";
	private final String MATCHING_GETLIST_SENDER = "SELECT * FROM matching WHERE seno=? AND mstate=1";
	private final String MATCHING_GETLIST_RECEIVER = "SELECT * FROM matching WHERE rcno=? AND mstate=1";
	private final String MATCHING_GETLIST_STATE2 = "SELECT * FROM matching WHERE (seno=? OR rcno=?) AND mstate=2";
	private final String MATCHING_GETLIST_STATE3 = "SELECT * FROM matching WHERE (seno=? OR rcno=?) AND mstate=3";
	private final String MATCHING_GETLIST_STATE4 = "SELECT * FROM matching WHERE (seno=? OR rcno=?) AND mstate=4";
	private final String MATCHING_GETLIST_STATE5_REJECTED = "SELECT * FROM matching WHERE seno=? AND mstate=5";
	private final String MATCHING_GETLIST_STATE5_REJECT = "SELECT * FROM matching WHERE rcno=? AND mstate=5";

	// 매칭리스트를 추가한다(state=1, 요청보내서 받음.)
	@Override
	public void insertMatchingState1(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-insertMatchingState1() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_INSERT);
			stmt.setInt(1, vo.getSeno());
			stmt.setInt(2, vo.getRcno());
			stmt.setInt(3, vo.getRno());
			stmt.setInt(4, vo.getEno());
			stmt.setString(5, vo.getMdate());
			stmt.setInt(6, vo.getMplace());
			stmt.setInt(7, vo.getMservice());
			stmt.setInt(8, vo.getMstate());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 매칭리스트의 state를 업데이트 한다(state=2, 요청확인을 해서 결제대기 상태)
	@Override
	public void updateMatchingState2(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-updateMatchingState2() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_UPDATE_STATE2);
			stmt.setInt(1, vo.getMno());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 매칭리스트의 state를 업데이트 한다(state=3, 결제완료~서비스이용직전까지 상태)
	@Override
	public void updateMatchingState3(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-updateMatchingState3() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_UPDATE_STATE3);
			stmt.setInt(1, vo.getMno());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 매칭리스트의 state를 업데이트 한다(state=4, 서비스이용 후 리뷰까지 작성함. 이전내역에서 볼수있음.)
	@Override
	public void updateMatchingState4(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-updateMatchingState4() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_UPDATE_STATE4);
			stmt.setInt(1, vo.getMno());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 매칭리스트의 state를 업데이트 한다(state=5, 요청단계에서 거절했을시)
	@Override
	public void updateMatchingState5(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-updateMatchingState5() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_UPDATE_STATE5);
			stmt.setInt(1, vo.getMno());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 매칭리스트 상세보기
	@Override
	public MatchingVO getMatching(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-getMatching() 기능 처리");
		MatchingVO matching = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_GET);
			stmt.setInt(1, vo.getMno());
			rs = stmt.executeQuery();
			if (rs.next()) {
				matching = new MatchingVO();
				matching.setMno(rs.getInt("mno"));
				matching.setSeno(rs.getInt("seno"));
				matching.setRcno(rs.getInt("rcno"));
				matching.setRno(rs.getInt("rno"));
				matching.setEno(rs.getInt("eno"));
				matching.setMdate(rs.getString("mdate"));
				matching.setMplace(rs.getInt("mplace"));
				matching.setMservice(rs.getInt("mservice"));
				matching.setMstate(rs.getInt("mstate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matching;
	}

	// 매칭리스트(내가 보낸 요청 매칭 리스트 : seno == 유저번호, state=1)
	@Override
	public List<MatchingVO> getMatchingSenderList(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-getMatchingSenderList() 기능 처리");
		System.out.println(vo.toString());
		List<MatchingVO> matchingList = new ArrayList<MatchingVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_GETLIST_SENDER);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MatchingVO matching = new MatchingVO();
				matching.setMno(rs.getInt("mno"));
				matching.setSeno(rs.getInt("seno"));
				matching.setRcno(rs.getInt("rcno"));
				matching.setRno(rs.getInt("rno"));
				matching.setEno(rs.getInt("eno"));
				matching.setMdate(rs.getString("mdate"));
				matching.setMplace(rs.getInt("mplace"));
				matching.setMservice(rs.getInt("mservice"));
				matching.setMstate(rs.getInt("mstate"));
				matchingList.add(matching);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matchingList;
	}

	// 매칭리스트(내가 받은 요청 매칭 리스트 : rcno == 유저번호, state=1)
	@Override
	public List<MatchingVO> getMatchingReceiverList(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-getMatchingReceiverList() 기능 처리");
		System.out.println(vo.toString());
		List<MatchingVO> matchingList = new ArrayList<MatchingVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_GETLIST_RECEIVER);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MatchingVO matching = new MatchingVO();
				matching.setMno(rs.getInt("mno"));
				matching.setSeno(rs.getInt("seno"));
				matching.setRcno(rs.getInt("rcno"));
				matching.setRno(rs.getInt("rno"));
				matching.setEno(rs.getInt("eno"));
				matching.setMdate(rs.getString("mdate"));
				matching.setMplace(rs.getInt("mplace"));
				matching.setMservice(rs.getInt("mservice"));
				matching.setMstate(rs.getInt("mstate"));
				matchingList.add(matching);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matchingList;
	}

	// 매칭리스트(결제 대기 중인 매칭 리스트 : seno == 유저번호 || rcno == 유저번호 , state=2)
	@Override
	public List<MatchingVO> getMatchingState2List(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-getMatchingState2List() 기능 처리");
		System.out.println(vo.toString());
		List<MatchingVO> matchingList = new ArrayList<MatchingVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_GETLIST_STATE2);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MatchingVO matching = new MatchingVO();
				matching.setMno(rs.getInt("mno"));
				matching.setSeno(rs.getInt("seno"));
				matching.setRcno(rs.getInt("rcno"));
				matching.setRno(rs.getInt("rno"));
				matching.setEno(rs.getInt("eno"));
				matching.setMdate(rs.getString("mdate"));
				matching.setMplace(rs.getInt("mplace"));
				matching.setMservice(rs.getInt("mservice"));
				matching.setMstate(rs.getInt("mstate"));
				matchingList.add(matching);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matchingList;
	}

	// 매칭리스트(결제완료 후 서비스 전인 매칭 리스트 : seno == 유저번호 || rcno == 유저번호 , state=3)
	@Override
	public List<MatchingVO> getMatchingState3List(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-getMatchingState3List() 기능 처리");
		System.out.println(vo.toString());
		List<MatchingVO> matchingList = new ArrayList<MatchingVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_GETLIST_STATE3);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MatchingVO matching = new MatchingVO();
				matching.setMno(rs.getInt("mno"));
				matching.setSeno(rs.getInt("seno"));
				matching.setRcno(rs.getInt("rcno"));
				matching.setRno(rs.getInt("rno"));
				matching.setEno(rs.getInt("eno"));
				matching.setMdate(rs.getString("mdate"));
				matching.setMplace(rs.getInt("mplace"));
				matching.setMservice(rs.getInt("mservice"));
				matching.setMstate(rs.getInt("mstate"));
				matchingList.add(matching);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matchingList;
	}

	// 매칭리스트(서비스완료, 리뷰작성 후 이전내역에 보여지는 매칭리스트 : seno == 유저번호 || rcno == 유저번호 ,state=4)
	@Override
	public List<MatchingVO> getMatchingState4List(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-getMatchingState4List() 기능 처리");
		System.out.println(vo.toString());
		List<MatchingVO> matchingList = new ArrayList<MatchingVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_GETLIST_STATE4);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MatchingVO matching = new MatchingVO();
				matching.setMno(rs.getInt("mno"));
				matching.setSeno(rs.getInt("seno"));
				matching.setRcno(rs.getInt("rcno"));
				matching.setRno(rs.getInt("rno"));
				matching.setEno(rs.getInt("eno"));
				matching.setMdate(rs.getString("mdate"));
				matching.setMplace(rs.getInt("mplace"));
				matching.setMservice(rs.getInt("mservice"));
				matching.setMstate(rs.getInt("mstate"));
				matchingList.add(matching);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matchingList;
	}

	// 매칭리스트(거절당한 매칭 리스트 : seno == 유저번호, state=5)
	@Override
	public List<MatchingVO> getMatchingSenderState5List(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-getMatchingSenderState5List() 기능 처리");
		System.out.println(vo.toString());
		List<MatchingVO> matchingList = new ArrayList<MatchingVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_GETLIST_STATE5_REJECTED);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MatchingVO matching = new MatchingVO();
				matching.setMno(rs.getInt("mno"));
				matching.setSeno(rs.getInt("seno"));
				matching.setRcno(rs.getInt("rcno"));
				matching.setRno(rs.getInt("rno"));
				matching.setEno(rs.getInt("eno"));
				matching.setMdate(rs.getString("mdate"));
				matching.setMplace(rs.getInt("mplace"));
				matching.setMservice(rs.getInt("mservice"));
				matching.setMstate(rs.getInt("mstate"));
				matchingList.add(matching);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matchingList;
	}

	// 매칭리스트(거절한 매칭 리스트 : rcno == 유저번호, state=5)
	@Override
	public List<MatchingVO> getMatchingReceiverState5List(MatchingVO vo) {
		System.out.println("-----MatchingDAOImpl의-getMatchingReceiverState5List() 기능 처리");
		System.out.println(vo.toString());
		List<MatchingVO> matchingList = new ArrayList<MatchingVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MATCHING_GETLIST_STATE5_REJECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MatchingVO matching = new MatchingVO();
				matching.setMno(rs.getInt("mno"));
				matching.setSeno(rs.getInt("seno"));
				matching.setRcno(rs.getInt("rcno"));
				matching.setRno(rs.getInt("rno"));
				matching.setEno(rs.getInt("eno"));
				matching.setMdate(rs.getString("mdate"));
				matching.setMplace(rs.getInt("mplace"));
				matching.setMservice(rs.getInt("mservice"));
				matching.setMstate(rs.getInt("mstate"));
				matchingList.add(matching);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matchingList;
	}

}
