package com.kimchi.view.payment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimchi.biz.payment.PaymentVO;
import com.kimchi.biz.payment.impl.PaymentServiceImpl;

@Controller
public class PaymentController {

	
	
	@Autowired
	private PaymentServiceImpl PSI;
	private static PaymentVO staticVo;
	

	@RequestMapping(value = "/kakaoPay.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String kakaoPayReady(HttpSession session, PaymentVO vo) {
		
		System.out.println("kakaoPay 결제");
		staticVo=vo;	//컨트롤러에서 존재할 객체 생성		
		staticVo=PSI.kakaoPayReady(vo);
		
		//카카오페이와 고객간의 결제페이지로 이동
		return "redirect:"+staticVo.getNext_redirect_pc_url();

	}

	//결제준비 단계 후 pg_token 성공적으로 받아오면 자동으로 kakaoPaySuccess 리다이렉트됬을 때
	//반환받은 pg_token 을 VO 객체에 넣어줘야한다?
	@RequestMapping(value = "/kakaoPaySuccess.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        
		//pg_token get
		staticVo.setPg_token(pg_token);
		//model.addAttribute("info", PSI.kakaoPayApproval(vo2, pg_token));

		return "kakaoPaySuccess.jsp";
	}
	
	//결제 승인 단계 전 사용자가 결제완료 버튼을 눌렀을 때
	@RequestMapping(value = "/kakaoPayApproval.do",method = { RequestMethod.GET, RequestMethod.POST })
	public String kakaoPayApproval(PaymentVO vo, Model model) {
		
		//결제 승인 단계 입니다!
		model.addAttribute("info", PSI.kakaoPayApproval(staticVo, staticVo.getPg_token()));

		return "kakaoPayApproval.jsp";		
	}
}
