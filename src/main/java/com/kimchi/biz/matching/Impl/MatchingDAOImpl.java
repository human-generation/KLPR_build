package com.kimchi.biz.matching.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.matching.MatchingDAO;
import com.kimchi.biz.matching.MatchingVOExtra;
import com.kimchi.biz.user.UserVO;

public class MatchingDAOImpl implements MatchingDAO {
	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private PreparedStatement stmt2=null;
	private ResultSet rs = null;
	private ResultSet rs2=null;

	private final String SENDED_MATCHING_GET = "SELECT * FROM matching WHERE seno=?";
	private final String RECEIVED_MATCHING_GET = "SELECT * FROM matching WHERE rcno=?";
	private final String WAITING_MATCHING_GET = "SELECT * FROM matching WHERE (rcno=? AND mstate=2) OR (seno=? AND mstate=2)";
	private final String PAID_MATCHING_GET = "SELECT * FROM matching WHERE (rcno=? AND mstate=3) OR (seno=? AND mstate=3)";
	private final String ENDED_MATCHING_GET = "SELECT * FROM matching WHERE (rcno=? AND mstate=4) OR (seno=? AND mstate=4)";
	private final String DENIED_MATCHING_GET = "SELECT * FROM matching WHERE (rcno=? AND mstate=5) OR (seno=? AND mstate=5)";

	private final String S_YOUR_NAME = "SELECT name FROM user WHERE uno=(SELECT seno FROM matching WHERE mno=?)";
	private final String R_YOUR_NAME = "SELECT name FROM user WHERE uno=(SELECT rcno FROM matching WHERE mno=?)";
	
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
				mvo.setEno(rs.getInt("eno"));
				mvo.setMdate(rs.getDate("mdate"));
				mvo.setMplace(rs.getInt("mplace"));
				mvo.setMservice(rs.getInt("mservice"));
				mvo.setMstate(rs.getInt("mstate"));
				mvo.setSenderName(senderName(mvo.getMno()));
				mvo.setReceiverName(receiverName(mvo.getMno()));
				matchingList.add(mvo);
				System.out.println(mvo.toString());
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
			System.out.println(conn.toString());
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
			System.out.println(conn.toString());
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
}
