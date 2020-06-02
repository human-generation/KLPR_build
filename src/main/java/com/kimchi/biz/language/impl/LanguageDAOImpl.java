package com.kimchi.biz.language.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.language.LanguageDAO;
import com.kimchi.biz.language.LanguageVO;

@Repository("LanguageDAO")
public class LanguageDAOImpl implements LanguageDAO{
	
	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 문
	private final String LANGUAGELIST_GET = "SELECT lno, language FROM language ORDER BY lno";

	@Override
	public List<LanguageVO> getLanguageList(LanguageVO vo) {
		System.out.println("===> JDBC로 getLanguageList() 기능 처리");
		
		List<LanguageVO> languageList = new ArrayList<LanguageVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(LANGUAGELIST_GET);
			rs = stmt.executeQuery(); 
			while(rs.next()) {
				LanguageVO language = new LanguageVO();
				language.setLno(rs.getInt("lno"));
				language.setLanguage(rs.getString("language"));
				languageList.add(language);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return languageList;
	} 
}
