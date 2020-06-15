package com.kimchi.biz.payment.impl;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.kimchi.biz.payment.PaymentDAO;
import com.kimchi.biz.payment.PaymentService;
import com.kimchi.biz.payment.PaymentVO;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
	
	
	@Autowired
	private PaymentDAO PaymentDAO;	
	private static final String HOST = "https://kapi.kakao.com";
	Gson gson = new Gson();

	//카카오페이 단건 결제 
	//결제준비 단계
	@Override
	public PaymentVO kakaoPayReady(PaymentVO vo) {

		RestTemplate restTemplate = new RestTemplate();

		System.out.println("service----------카카오 페이 단건결제 1단계 : 결제준비 단계----------1");
		
		PaymentDAO.insert_KakaoPayOrder(vo);		//DB 주문서 생성
		vo=PaymentDAO.select_kakaoPayOrder(vo);		//주문번호 가져오기
		
		System.out.println("주문번호 가져온후"+ vo);
		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "bcf2940cead362493e75bd28021e9721");
//		headers.add("Authorization", "KakaoAK " + "admin key를 넣어주세요~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");	
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
//		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);	//<- 이건 왜 안되는지 알아보기
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		// 서버로 요청할 Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME"); 									// 가맹점코드, TC0ONETIME:개발자테스트코드
		params.add("partner_order_id", vo.getPartner_order_id()); 			// 가맹점 주문번호
		params.add("partner_user_id", Integer.toString(vo.getUno()));		//가맹점 회원 id, 최대 100자
		params.add("item_name", "충전금액"); 									// 상품명, 최대 100자
		params.add("quantity", "1"); 										// 상품 수량
		params.add("total_amount", Integer.toString(vo.getPay())); 			// 상품 총액
		params.add("tax_free_amount", "100"); // 상품 비과세 금액
		params.add("approval_url", "http://localhost:9000/KLPR/kakaoPaySuccess.do"); // 결제 성공 시 redirect url, 최대 255자
		params.add("cancel_url", "http://localhost:9000/KLPR/kakaoPayCancel.jsp"); // 결제 취소 시 redirect url, 최대 255자
		params.add("fail_url", "http://localhost:9000/KLPR/kakaoPaySuccessFail.jsp"); // 결제 실패 시 redirect url, 최대 255자

		// 헤더와 바디를 붙여주는 방법
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		try {

			// RestTemplate을 이용한 카카오페이에 결제준비 데이터를 보내기
			String test = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, String.class);
			
			PaymentVO Resultvo = gson.fromJson(test.toString(), PaymentVO.class);
			vo.setTid(Resultvo.getTid());
			vo.setNext_redirect_pc_url(Resultvo.getNext_redirect_pc_url());  //현재는 PC이용한 결제만 가능, 추후 안드로이드/ios추가 바람
					
			PaymentDAO.update_KaKaoPayReady(vo);

			return vo;

		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return vo;
	}

	//결제승인 단계
	@Override
	public PaymentVO kakaoPayApproval(PaymentVO vo, String pg_token) {

		RestTemplate restTemplate = new RestTemplate();

		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "bcf2940cead362493e75bd28021e9721");
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		// 서버로 요청할 Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", vo.getTid());		
		params.add("partner_order_id", vo.getPartner_order_id()); 			// 가맹점 주문번호
		params.add("partner_user_id", Integer.toString(vo.getUno()));		//가맹점 회원 id, 최대 100자
		params.add("pg_token", pg_token);
		params.add("total_amount", Integer.toString(vo.getPay())); 			// 상품 총액

		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		try {

			String test = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, String.class);
			
			PaymentVO Resultvo = gson.fromJson(test.toString(), PaymentVO.class);
			vo.setApproved_at(Resultvo.getApproved_at());		
			PaymentDAO.update_KakaoPayApproval(vo);
			PaymentDAO.update_point(vo);
					
			return vo;

		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {		
			e.printStackTrace();
		}
		return vo;
	}
}