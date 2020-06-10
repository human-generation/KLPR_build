package com.kimchi.biz.matching.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.matching.MatchingDAO;
<<<<<<< HEAD
import com.kimchi.biz.matching.MatchingVOExtra;
import com.kimchi.biz.user.UserVO;

@Repository("matchingDAO")
public class MatchingDAOImpl implements MatchingDAO {
	// JDBC 관련 변수들
	private Connection conn=null;
	private PreparedStatement stmt = null;
	private PreparedStatement stmt2=null;
	private ResultSet rs = null;
	private ResultSet rs2=null;

	private final String SENDED_MATCHING_GET = "SELECT * FROM matching WHERE seno=?";
	private final String RECEIVED_MATCHING_GET = "SELECT * FROM matching WHERE rcno=?";
	private final String WAITING_MATCHING_GET = "SELECT * FROM matching WHERE (seno=? AND mstate=2) OR (rcno=? AND mstate=2)";
	private final String PAID_MATCHING_GET = "SELECT * FROM matching WHERE (rcno=? AND mstate=3) OR (seno=? AND mstate=3)";
	private final String ENDED_MATCHING_GET = "SELECT * FROM matching WHERE (rcno=? AND mstate=4) OR (seno=? AND mstate=4)";
	private final String DENIED_MATCHING_GET = "SELECT * FROM matching WHERE (rcno=? AND mstate=5) OR (seno=? AND mstate=5)";

	private final String S_YOUR_NAME = "SELECT name FROM user WHERE uno=(SELECT seno FROM matching WHERE mno=?)";
	private final String R_YOUR_NAME = "SELECT name FROM user WHERE uno=(SELECT rcno FROM matching WHERE mno=?)";
	
	private final String UPDATE_PAID="UPDATE matching SET mstate=3 where mno=?";
	private final String UPDATE_ENDED="UPDATE matching SET mstate=4 where mno=?";
	private final String UPDATE_WAIT="UPDATE matching SET mstate=2 where mno=?";
	
	private final String LANGUAGE_GET_R="SELECT language FROM language WHERE lno=ANY(SELECT lno FROM helper WHERE uno=?)";
	private final String LANGUAGE_GET_E="SELECT language FROM language WHERE lno=ANY(SELECT lno FROM helpee WHERE uno=?)";

	@Override
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state) { // state에 따라 리스트 리턴해주는 함수
		List<MatchingVOExtra> matchingList = new ArrayList<MatchingVOExtra>();
		try {
			conn = JDBCUtil.getConnection();
			System.out.println(conn.toString());
			switch (state) {
			case 0:
				stmt = conn.prepareStatement(SENDED_MATCHING_GET);
				stmt.setInt(1, vo.getUno());
				break;
			case 1:
				stmt = conn.prepareStatement(RECEIVED_MATCHING_GET);
				stmt.setInt(1, vo.getUno());
				break;
			case 2:
				stmt = conn.prepareStatement(WAITING_MATCHING_GET);
				stmt.setInt(1, vo.getUno());
				stmt.setInt(2, vo.getUno());
				break;
			case 3:
				stmt = conn.prepareStatement(PAID_MATCHING_GET);
				stmt.setInt(1, vo.getUno());
				stmt.setInt(2, vo.getUno());
				break;
			case 4:
				stmt = conn.prepareStatement(ENDED_MATCHING_GET);
				stmt.setInt(1, vo.getUno());
				stmt.setInt(2, vo.getUno());
				break;
			case 5:
				stmt = conn.prepareStatement(DENIED_MATCHING_GET);
				stmt.setInt(1, vo.getUno());
				stmt.setInt(2, vo.getUno());
				break;
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				MatchingVOExtra mvo = new MatchingVOExtra();
				mvo.setMno(rs.getInt("mno"));
				mvo.setSeno(rs.getInt("seno"));
				mvo.setRcno(rs.getInt("rcno"));
				mvo.setRno(rs.getInt("rno"));
				mvo.setEno(rs.getInt("eno"));
				mvo.setMdate(rs.getDate("mdate"));
				mvo.setMplace(rs.getInt("mplace"));
				mvo.setMservice(rs.getInt("mservice"));
				mvo.setMstate(rs.getInt("mstate"));
				mvo.setSenderName(senderName(mvo.getMno()));
				mvo.setReceiverName(receiverName(mvo.getMno()));
				mvo.setMplaceName(convertPlace(mvo.getMplace()));
				if(vo.getUno()==mvo.getRno()) {
					mvo.setLanguage(convertLanguage(LANGUAGE_GET_E, mvo.getEno()));
				}else if(vo.getUno()==mvo.getEno()){
					mvo.setLanguage(convertLanguage(LANGUAGE_GET_R, mvo.getRno()));
				}
				matchingList.add(mvo);
=======
import com.kimchi.biz.matching.MatchingVO;

//@Repository("matchingDAO")
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
>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matchingList;
	}

<<<<<<< HEAD
	@Override
	public void setMatchingState(UserVO vo, HttpSession session) {
		List<MatchingVOExtra> list = getMatchingList(vo, 0);
		session.setAttribute("mstate0", list.size());
		list = getMatchingList(vo, 1);
		session.setAttribute("mstate1", list.size());
		list = getMatchingList(vo, 2);
		session.setAttribute("mstate2", list.size());
		list = getMatchingList(vo, 3);
		session.setAttribute("mstate3", list.size());
		list = getMatchingList(vo, 4);
		session.setAttribute("mstate4", list.size());
		list = getMatchingList(vo, 5);
		session.setAttribute("mstate5", list.size());
	}

	public String senderName(int mno) {
		try {
			conn = JDBCUtil.getConnection();
			stmt2 = conn.prepareStatement(S_YOUR_NAME);
			stmt2.setInt(1, mno);
			rs2 = stmt2.executeQuery();
			if(rs2.next()) {
				return rs2.getString("name");
=======
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
>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
<<<<<<< HEAD
			JDBCUtil.close(rs2, stmt2, conn);
		}
		return null;
	}
	
	public String receiverName(int mno) {
		try {
			conn = JDBCUtil.getConnection();
//			System.out.println(conn.toString());
			stmt2 = conn.prepareStatement(R_YOUR_NAME);
			stmt2.setInt(1, mno);
			rs2 = stmt2.executeQuery();
			if(rs2.next()) {
				return rs2.getString("name");
=======
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
>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
<<<<<<< HEAD
			JDBCUtil.close(rs2, stmt2, conn);
		}
		return null;
	}
	
	
	public void updateState(MatchingVOExtra mvo) {
			conn=JDBCUtil.getConnection();
			try {
				if(mvo.getMstate()==2) {
					stmt2=conn.prepareStatement(UPDATE_PAID);
					stmt2.setInt(1, mvo.getMno());
					stmt2.executeUpdate();
				}
				else if(mvo.getMstate()==3) {
					stmt2=conn.prepareStatement(UPDATE_ENDED);
					stmt2.setInt(1, mvo.getMno());
					stmt2.executeUpdate();
				}else if(mvo.getMstate()==1) {
					stmt2=conn.prepareStatement(UPDATE_WAIT);
					stmt2.setInt(1, mvo.getMno());
					stmt2.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				JDBCUtil.close(rs2, stmt2, conn);
			}
	}
	
	public List<String> convertLanguage(String eOrh, int uno) {
		List<String> list=new ArrayList<String>();
		try{
			conn=JDBCUtil.getConnection();
			stmt2=conn.prepareStatement(eOrh);
			stmt2.setInt(1, uno);
			rs2=stmt2.executeQuery();
			while(rs2.next()) {
				list.add(rs2.getString("language"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs2, stmt2, conn);
		}
		return list;
	}
	
	public String convertPlace(int mplace) { //실행시간 관점에서 하나 조회할때마다 join으로 db참고하는것보다 이게 더 빠르다는 판단,,,
		switch(mplace){
			case 1: return "Gangbuk-gu";
			case 2: return "Gangdong-gu";
			case 3: return "Gangname-gu";
			case 4: return "Gangseo-gu";
			case 5: return "Geumcheon-gu";
			case 6: return "Guro-gu";
			case 7: return "Gwanak-gu";
			case 8: return "Gwangjin-gu";
			case 9: return "Nowon-gu";
			case 10: return "Dobong-gu";
			case 11: return "Dongdaemun-gu";
			case 12: return "Dongjak-gu";
			case 13: return "Mapo-gu";
			case 14: return "Seocho-gu";
			case 15: return "Seodaemun-gu";
			case 16: return "Seongbuk-gu";
			case 17: return "Seongdong-gu";
			case 18: return "Songpa-gu";
			case 19: return "Yangcheon-gu";
			case 20: return "Yeongdeungpo-gu";
			case 21: return "Yongsan-gu";
			case 22: return "Eunpyeong-gu";
			case 23: return "Jongno-gu";
			case 24: return "Jungnang-gu";
			case 25: return "Jung-gu";
			default: return "";
		}
	}
=======
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

>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
}
