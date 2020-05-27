package com.kimchi.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.user.UserDAO;
import com.kimchi.biz.user.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String USER_GET = "SELECT * FROM user WHERE email=? AND pw=?";
	private final String USER_INSERT = "INSERT INTO user(email, pw, name, gender, money, phone) VALUES(?, ?, ?, ?, 0, ?)";
	private final String UPDATE_USER_MONEY="UPDATE user SET money=? WHERE UNO=?";
	private final String UPDATE_USER="UPDATE user SET name=?, WHERE UNO=?";
	
	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("------UserDAOImlp의-getUser() 기능 처리");

		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			System.out.println(conn.toString());
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getEmail());
			stmt.setString(2, vo.getPw());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setUno(rs.getInt("uno"));
				user.setEmail(rs.getString("email"));
				user.setPw(rs.getString("pw"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getInt("gender"));
				user.setMoney(rs.getInt("money"));
				user.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}

	@Override
	public void insertUser(UserVO vo) {
		System.out.println("------UserDAOImlp의-insertUser() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getEmail());
			stmt.setString(2, vo.getPw());
			stmt.setString(3, vo.getName());
			stmt.setInt(4, vo.getGender());
			stmt.setString(5, vo.getPhone());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	@Override
	public void updateUserMoney(UserVO vo, int pay) {
		System.out.println("------UserDAOImpl의-updateUserMoney() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE_USER_MONEY);
			stmt.setInt(1, vo.getMoney()+pay);
			stmt.setInt(2, vo.getUno());
			stmt.executeUpdate();
			getUser(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	@Override
	public void updateUser(UserVO vo) {
		System.out.println("------UserDAOImpl의-updateUser() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE_USER);
			stmt.setInt(1, vo.getMoney());
			stmt.setInt(2, vo.getUno());
			stmt.executeUpdate();
			getUser(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
