package com.kimchi.biz.main.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.main.MainDAO;
import com.kimchi.biz.main.MainVO;

@Repository("MainDAO")
public class MainDAOImpl implements MainDAO {
	
	
	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	//1)헬퍼 평점 리스트
	private final String RSCORE_SEL = "SELECT r.rno , u.name, AVG(r.rscore) AS score FROM r_review AS r JOIN user AS u ON r.rno = u.uno GROUP BY r.rno order by score DESC";
		
	//2)헬피 평점 리스트 
	private final String ESCORE_SEL = "SELECT e.eno, u.name, AVG(e.escore) AS score FROM e_review AS e JOIN user AS u ON e.eno = u.uno GROUP BY e.eno order by score DESC";
	
	//3)헬퍼 평점 전체 평균 
	private final String RSCORE_AVG="SELECT AVG(rscore) FROM r_review";

	//4)헬피 평점 전체 평균 
	private final String ESCORE_AVG="SELECT AVG(escore) FROM e_review"; 

	//5)가장 평점이 높은 헬퍼 NAME, NUM top5 리스트 
	
	private final String BEST_RTOP5 = "SELECT @num:=@num+1 as ranking, rno, name, rscore FROM (select @num:=0) ranking, (SELECT r.rno , u.name, AVG(r.rscore) AS rscore FROM r_review AS r JOIN user AS u ON r.rno = u.uno GROUP BY r.rno LIMIT 5)A ORDER BY rscore DESC";	
	//private final String BEST_RTOP5 = "SELECT @num:=@num+1 as ranking, r.rno , u.name, AVG(r.rscore) AS rscore FROM (select @num:=0) ranking, r_review AS r JOIN user AS u ON r.rno = u.uno GROUP BY r.rno order by AVG(r.rscore) DESC LIMIT 5";

	//6)가장 많은 도움을 준 헬퍼 NAME, NUM top5 리스트 (matching table에서 ,mstate=4)
	private final String GREATEST_RTOP5 = "SELECT @num:=@num+1 as ranking, u.uno, u.name, COUNT(*) AS n FROM (select @num:=0) ranking, user AS u JOIN matching AS m WHERE m.mstate=4 AND u.uno=m.rno GROUP BY u.uno LIMIT 5";
	 
	//7)가장 도움을 많이 받은 헬피 NAME, NUM top5 리스트 (matching table에서 ,mstate=4) 
	private final String GREATEST_ETOP5="SELECT @num:=@num+1 as ranking, u.uno, u.name, COUNT(*) AS n FROM (select @num:=0) ranking, user AS u JOIN matching AS m WHERE m.mstate=4 AND u.uno=m.eno GROUP BY u.uno LIMIT 5";
	
	
	@Override
	public List<MainVO> selectHelperScore() {
		
		System.out.println("------------------MainDAOImpl의 헬퍼 평점 리스트------------------");
		ArrayList<MainVO> vo = new ArrayList<MainVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(RSCORE_SEL);
					
			rs = stmt.executeQuery();
		
			while (rs.next()) {			
				vo.add(new MainVO()
				.setRno(rs.getInt("rno"))			//헬퍼 번호 
				.setName(rs.getString("name"))		//핼퍼 이름
				.setRscore(rs.getInt("rscore")));	//헬퍼 평점				
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		return vo;				
	}

	@Override
	public List<MainVO> selectHelpeeScore() {
		
		System.out.println("------------------MainDAOImpl의 헬피 평점 리스트------------------");
		ArrayList<MainVO> vo = new ArrayList<MainVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ESCORE_SEL);
					
			rs = stmt.executeQuery();
	
			while (rs.next()) {			
				vo.add(new MainVO()
				.setEno(rs.getInt("eno"))			//헬피 번호 
				.setName(rs.getString("name"))		//핼피 이름
				.setEscore(rs.getInt("escore")));	//헬피 평점				
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		return vo;				
	}

	@Override
	public MainVO selectHelperScoreAvg(MainVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MainVO selectHelpeeScoreAvg(MainVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MainVO> selectRScoreTop5() {
		System.out.println("------------------MainDAOImpl의 가장 평점이 높은 헬퍼 NAME, NUM top5 리스트 ------------------");
		ArrayList<MainVO> vo = new ArrayList<MainVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BEST_RTOP5);
			//SELECT r.rno , u.name, AVG(r.rscore) AS score FROM r_review AS r JOIN user AS u ON r.rno = u.uno GROUP BY r.rno order by score DESC LIMIT 5		
			rs = stmt.executeQuery();
	
			while (rs.next()) {			
				vo.add(new MainVO()
				.setRanking(rs.getInt("ranking"))	//순위
				.setRno(rs.getInt("rno"))			//헬퍼 번호 
				.setName(rs.getString("name"))		//핼퍼 이름
				.setRscore(rs.getInt("rscore")));	//헬퍼 평점				
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		return vo;		
	}

	@Override
	public List<MainVO> selectRTop5() {
		System.out.println("------------------MainDAOImpl의 가장 많은 도움을 준 헬퍼 NAME, NUM top5 리스트 ------------------");
		ArrayList<MainVO> vo = new ArrayList<MainVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GREATEST_RTOP5);
			//SELECT u.uno, u.name, COUNT(*) AS n FROM user AS u JOIN matching AS m WHERE m.mstate=4 AND u.uno=m.rno GROUP BY u.uno LIMIT 5
			rs = stmt.executeQuery();
			
			while (rs.next()) {			
				vo.add(new MainVO()
				.setRanking(rs.getInt("ranking"))	//순위		
				.setUno(rs.getInt("uno"))			//헬퍼 번호 
				.setName(rs.getString("name"))		//핼퍼 이름
				.setN(rs.getInt("n")));				//count				
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		return vo;	
	}

	@Override
	public List<MainVO> selectETop5() {
		System.out.println("------------------MainDAOImpl의 가장 많은 도움을 받은 헬피 NAME, NUM top5 리스트 ------------------");
		ArrayList<MainVO> vo = new ArrayList<MainVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GREATEST_ETOP5);
			//"SELECT u.uno, u.name, COUNT(*) AS n FROM user AS u JOIN matching AS m WHERE m.mstate=4 AND u.uno=m.eno GROUP BY u.uno LIMIT 5";	
			rs = stmt.executeQuery();
			
			while (rs.next()) {			
				vo.add(new MainVO()
				.setRanking(rs.getInt("ranking"))	//순위	
				.setUno(rs.getInt("uno"))			//헬피 번호 
				.setName(rs.getString("name"))		//핼피 이름
				.setN(rs.getInt("n")));				//count				
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
		return vo;
	}

	
	
	

	
}
