package com.kimchi.biz.payment;

public interface PaymentDAO {

	//카카오페이 주문 생성(주문번호 생성)
	public void insert_KakaoPayOrder(PaymentVO vo);
		
	//카카오페이 주문번호 가져오기(결제승인을 위한)
	public PaymentVO select_kakaoPayOrder(PaymentVO vo);
	
	//카카오페이 결제준비 데이터 추가
	public void update_KaKaoPayReady(PaymentVO vo);
			
	//카카오페이 결제승인 데이터 추가
	public void update_KakaoPayApproval(PaymentVO vo);
	
	//결제 완료 후 충전금액 업데이트
	public void update_point(PaymentVO vo);
	
}
