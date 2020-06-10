package com.kimchi.biz.matching.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.matching.MatchingDAO;
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return matchingList;
	}

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
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
}
