package com.kimchi.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// AWS DB 서버 이용하기
			// "jdbc:mysql://ip주소:포트번호/스키마?characterEncoding=UTF-8&serverTimezone=UTC",
			// "아이디", "비밀번호");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/klpr?characterEncoding=UTF-8&serverTimezone=UTC", "klprstaff",
					"qlxmzoavmtmxpq!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		close(stmt, conn);
	}
}
