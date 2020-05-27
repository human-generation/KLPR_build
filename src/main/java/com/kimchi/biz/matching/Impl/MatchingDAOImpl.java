package com.kimchi.biz.matching.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.matching.MatchingDAO;
import com.kimchi.biz.matching.MatchingVO;
import com.kimchi.biz.user.UserVO;

public class MatchingDAOImpl implements MatchingDAO{
	// JDBC 관련 변수들
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		
	private final String SENDED_MATCHING_GET="SELECT * FROM matching WHERE seno=?";
	private final String RECEIVED_MATCHING_GET="SELECT * FROM matching WHERE rcno=?";
	private final String WAITING_MATCHING_GET="SELECT * FROM matching WHERE (rcno=? AND mstate=2) OR (seno=? AND mstate=2)";
	private final String PAID_MATCHING_GET="SELECT * FROM matching WHERE (rcno=? AND mstate=3) OR (seno=? AND mstate=3)";
	private final String ENDED_MATCHING_GET="SELECT * FROM matching WHERE (rcno=? AND mstate=4) OR (seno=? AND mstate=4)";
	private final String DENIED_MATCHING_GET="SELECT * FROM matching WHERE (rcno=? AND mstate=5) OR (seno=? AND mstate=5)";
	
	@Override
	public List<MatchingVO> getMatchingList(UserVO vo, int state) { //state에 따라 리스트 리턴해주는 함수
		List<MatchingVO> matchingList=new ArrayList<MatchingVO>();
		try {
			conn = JDBCUtil.getConnection();
			System.out.println(conn.toString());
			switch(state) {
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
				MatchingVO mvo = new MatchingVO();
				mvo.setMno(rs.getInt("mno"));
				mvo.setSeno(rs.getInt("seno"));
				mvo.setRcno(rs.getInt("rcno"));
				mvo.setEno(rs.getInt("eno"));
				mvo.setMdate(rs.getDate("mdate"));
				mvo.setMplace(rs.getInt("mplace"));
				mvo.setMservice(rs.getInt("mservice"));
				mvo.setMstate(rs.getInt("mstate"));
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
		List<MatchingVO> list=getMatchingList(vo, 0);
		session.setAttribute("mstate0", list.size());
		list=getMatchingList(vo, 1);
		session.setAttribute("mstate1", list.size());
		list=getMatchingList(vo, 2);
		session.setAttribute("mstate2", list.size());
		list=getMatchingList(vo, 3);
		session.setAttribute("mstate3", list.size());
		list=getMatchingList(vo, 4);
		session.setAttribute("mstate4", list.size());
		list=getMatchingList(vo, 5);
		session.setAttribute("mstate5", list.size());
	}
}
