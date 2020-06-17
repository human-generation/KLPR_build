package com.kimchi.biz.messenger.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.messenger.MessengerDAO;
import com.kimchi.biz.messenger.MessengerVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

@Repository("messengerDAO")
public class MessengerDAOImpl implements MessengerDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL문
	// 1. 메시지 불러오기
	private final String MSG_GET = "SELECT msgno, rno, eno, rmsg, emsg, DATE_FORMAT(msgdate,'yyyy-MM-dd HH:mm') AS msgdate, rstate, estate FROM messenger WHERE (rno=? OR eno=?)";

	// 2. [Helper] - 메시지 보내기
	private final String HELPER_SENDMSG = "INSERT INTO messenger (rno, eno, rmsg, emsg, rstate, estate) VALUES (?,?,?,null,1,0)";

	// 3. [Helper] - 메시지 읽음 처리 (Helpee가 확인하면)
	private final String HELPER_SENDMSGREAD = "UPDATE messenger SET rstate=0 WHERE DATE_FORMAT(msgdate,'yyyy-MM-dd HH:mm') < DATE_FORMAT(NOW(), 'yyyy-MM-dd HH:mm') AND rno=?";

	// 4. [Helpee] - 메시지 보내기
	private final String HELPEE_SENDMSG = "INSERT INTO messenger (rno, eno, rmsg, emsg, rstate, estate) VALUES(?,?,null,?,0,1)";

	// 5. [Helpee] - 메시지 읽음 처리 (Helper가 확인하면)
	private final String HELPEE_SENDMSGREAD = "UPDATE messenger SET estate=0 WHERE DATE_FORMAT(msgdate, 'yyyy-MM-dd HH:mm') < DATE_FORMAT(NOW(), 'yyyy-MM-dd HH:mm') AND eno=?";

	// 6. 메시지 리스트
	private final String MSGLIST_GET = "SELECT msgno, rno, eno, rmsg, emsg, msgdate, rstate, estate FROM messenger";

	@Override
	public MessengerVO getMsg(MessengerVO vo) {
		System.out.println("---- MessengerDAOImpl의 메신저 불러오기 기능");
		MessengerVO msg = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MSG_GET);
			stmt.setInt(1, vo.getRno());
			stmt.setInt(2, vo.getEno());
			rs = stmt.executeQuery();
			if (rs.next()) {
				msg = new MessengerVO();
				msg.setMsgno(rs.getInt("msgno"));
				msg.setRno(rs.getInt("rno"));
				msg.setEno(rs.getInt("eno"));
				msg.setRmsg(rs.getString("rmsg"));
				msg.setEmsg(rs.getString("emsg"));
				msg.setMsgdate(rs.getString("msgdate"));
				msg.setRstate(rs.getInt("rstate"));
				msg.setEstate(rs.getInt("estate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return msg;
	}

	@Override
	public void helperSendMsg(MessengerVO vo) {
		System.out.println("---- MessengerDAOImpl의  Helper 메시지 보내기 기능");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_SENDMSG);
			stmt.setInt(1, vo.getRno());
			stmt.setInt(2, vo.getEno());
			stmt.setString(3, vo.getRmsg());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public void helpersMsgRead(MessengerVO vo) {
		System.out.println("---- MessengerDAOImpl의  Helper가 보낸 메시지 읽음 처리 기능");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPER_SENDMSGREAD);
			stmt.setInt(1, vo.getRno());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	@Override
	public void helpeeSendMsg(MessengerVO vo) {
		System.out.println("---- MessengerDAOImpl의  Helpee 메시지 보내기 기능");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_SENDMSG);
			stmt.setInt(1, vo.getRno());
			stmt.setInt(2, vo.getEno());
			stmt.setString(3, vo.getEmsg());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}

	}

	@Override
	public void helpeesMsgRead(MessengerVO vo) {
		System.out.println("---- MessengerDAOImpl의  Helpee가 보낸 메시지 읽음 처리 기능");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(HELPEE_SENDMSGREAD);
			stmt.setInt(1, vo.getEno());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public List<MessengerVO> getMessageList(MessengerVO vo) {
		System.out.println("---- MessengerDAOImpl의 메시지 리스트 처리 기능");

		List<MessengerVO> msgList = new ArrayList<MessengerVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MSGLIST_GET);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MessengerVO msg = new MessengerVO();

				msg.setMsgno(rs.getInt("msgno"));
				msg.setRno(rs.getInt("rno"));
				msg.setEno(rs.getInt("eno"));
				msg.setRmsg(rs.getString("rmsg"));
				msg.setEmsg(rs.getString("emsg"));
				msg.setMsgdate(rs.getString("msgdate"));
				msg.setRstate(rs.getInt("rstate"));
				msg.setEstate(rs.getInt("estate"));
				
				msgList.add(msg);
				
			}
			System.out.println("getMessageList 값 확인: " + msgList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return msgList;
	}

}
