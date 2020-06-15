package com.kimchi.biz.payment;

public interface PaymentService {
	
	//결제준비
	public PaymentVO kakaoPayReady(PaymentVO vo);

	//결제승인
	public PaymentVO kakaoPayApproval(PaymentVO vo, String pg_token);
}
