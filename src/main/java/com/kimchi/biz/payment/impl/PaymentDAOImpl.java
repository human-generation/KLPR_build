package com.kimchi.biz.payment.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.common.JDBCUtil;
import com.kimchi.biz.payment.PaymentDAO;
import com.kimchi.biz.payment.PaymentVO;
import com.kimchi.biz.r_review.R_ReviewVO;

@Repository("PaymentDAO")
public class PaymentDAOImpl implements PaymentDAO {

	// JDBC 관련 변수들
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어	
	//카카오페이 결제 시 결제 정보 데이터 생성
	
	
	//카카오페이 주문서 생성
	private final String KakaoPayInfo_INSERT= "INSERT INTO kakaopay (uno, pay, state_code) VALUES(?,?,0)";
	
	//카카오페이 주문번호 가져오기
	private final String kakaoPayOrder_SELECT="SELECT pno FROM kakaopay WHERE uno=? AND state_code=0";
	
	//카카오페이 결제 시 결제 준비 데이터 추가 입력
	private final String kakaoPayReadyInfo_UPDATE="UPDATE kakaopay SET tid=?, state_code=1 WHERE uno=? AND state_code=0";
	
	//카카오페이 결제 시 결제 승인 데이터 추가 입력	
	private final String KakaoPayApprovalInfo_UPDATE="UPDATE kakaopay SET approved_at=? ,pg_token=?, state_code=2 WHERE uno=? AND tid=? AND state_code=1";
	
	//포인트 충전 금액 입력
	private final String POINT_UPDATE="UPDATE user SET money=money+? WHERE uno=?";

	
	//카카오페이 주문번호 생성
	@Override
	public void insert_KakaoPayOrder(PaymentVO vo) {
		System.out.println("------PaymentDAOImlp의-insert_KakaoPayOrder 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(KakaoPayInfo_INSERT);
			stmt.setInt(1, vo.getUno()); 	// 아이디
			stmt.setInt(2, vo.getPay()); // 충전금액
			
			stmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	@Override
	public PaymentVO select_kakaoPayOrder(PaymentVO vo) {
		System.out.println("------PaymentDAOImlp의-select_kakaoOrder 기능 처리");
		//PaymentVO vo = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(kakaoPayOrder_SELECT);
			stmt.setInt(1, vo.getUno()); 	// 아이디
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				//vo = new PaymentVO();
				vo.setPartner_order_id(Integer.toString(rs.getInt("pno")));	//우리 DB에서 int형이지만 카카오페이는 String형으로 보내야되서
			
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return vo;
	}
	
	@Override
	public void update_KaKaoPayReady(PaymentVO vo) {
		System.out.println("------PaymentDAOImlp의-update_KaKaoPayReady() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(kakaoPayReadyInfo_UPDATE);
			stmt.setString(1, vo.getTid()); 		// 회원 번호
//			stmt.setString(2, vo.getPg_token()); 		// 결제 고유 번호
			stmt.setInt(2, vo.getUno());	// 결제 인증 토큰
			
			stmt.executeUpdate();
					
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public void update_KakaoPayApproval(PaymentVO vo) {
		System.out.println("------PaymentDAOImlp의-update_KaKaoPayApproval() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(KakaoPayApprovalInfo_UPDATE);
			stmt.setString(1, vo.getApproved_at()); 	// 결제 일시
			stmt.setString(2, vo.getPg_token()); 		// 결제 인증 토큰
			stmt.setInt(3, vo.getUno()); 				// 회원 번호
			stmt.setString(4, vo.getTid());				// 결제 고유 번호
				
			stmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//결제완료 후 포인트 업데이트
	@Override
	public void update_point(PaymentVO vo) {
		System.out.println("------PaymentDAOImlp의-update_point() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(POINT_UPDATE);		
			stmt.setInt(1, vo.getPay()); 				// 충전금액
			stmt.setInt(2, vo.getUno()); 				// 회원 번호
			
			stmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}

}
