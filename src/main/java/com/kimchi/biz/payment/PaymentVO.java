package com.kimchi.biz.payment;

import lombok.Data;

@Data
public class PaymentVO {

	private int pay;				//충전금액, 카카오페이 Amount와 충돌이 나기때문에 변수명을 pay라 명명
	private int uno;				//회원번호

	//REQUEST
	//필수
	private String cid;					//가맹점 코드, 10자
	private String partner_order_id; 	//가맹점 주문번호, 최대 100자
	private String partner_user_id;		//가맹점 회원 id, 최대 100자
	private String item_name;			//상품명, 최대 100자
	private Integer quantity;			//상품 수량
	private String total_amount;		//상품 총액---------------카카오페이 서버에서 String으로 요청하므로 String으로 만들어 줬습니다.		
	private int inner_total_amount;		//상품 총액---------------우리 서버에 넣을 값은 int

	private Integer tax_free_amount;	//상품 비과세 금액
	private String approval_url;		//결제 성공 시 redirect url, 최대 255자
	private String cancel_url;			//결제 취소 시 redirect url, 최대 255자
	private String fail_url;			//결제 실패 시 redirect url, 최대 255자
	
	//금액
	
	
	//선택
	private String cid_secret;			//가맹점 코드 인증키, 24자, 숫자와 영문 소문자 조합
	private String item_code;			//상품코드, 최대 100자
	private Integer vat_amount;			//상품 부가세 금액
										//값을 보내지 않을 경우 다음과 같이 VAT 자동 계산
										//(상품총액 - 상품 비과세 금액)/11 : 소숫점 이하 반올림
	
	//private JSON Array available_cards; //결제 수단으로써 사용 허가할 카드사 목록, 지정하지 않으면 모든 카드사 허용
	//현재 SHINHAN, KB, HYUNDAI, LOTTE, SAMSUNG, NH, BC, HANA, CITI, KAKAOBANK, KAKAOPAY, WOORI, GWANGJU, SUHYUP, SHINHYUP, JEONBUK, JEJU, SC 지원
	//ex) [“HANA”, “BC”]
	
	//private String payment_method_type;	//사용 허가할 결제 수단, 지정하지 않으면 모든 결제 수단 허용, CARD 또는 MONEY 중 하나
	//private Integer install_month;		//카드 할부개월, 0~12
	//private JSON Map {String:String} custom_json; //결제 화면에 보여줄 사용자 정의 문구, 카카오페이와 사전 협의 필요
	
	
	
	//RESPONSE
	private String tid;						//결제 고유 번호, 20자
	private String next_redirect_app_url;	//요청한 클라이언트(Client)가 모바일 앱일 경우, 카카오톡 결제 페이지 Redirect URL
	private String next_redirect_mobile_url;//요청한 클라이언트가 모바일 웹일 경우, 카카오톡 결제 페이지 Redirect URL
	private String next_redirect_pc_url;	//요청한 클라이언트가 PC 웹일 경우, 카카오톡으로 결제 요청 메시지(TMS)를 보내기 위한 사용자 정보 입력 화면 Redirect URL
	
	private String android_app_scheme;		//카카오페이 결제 화면으로 이동하는 Android 앱 스킴(Scheme)
	private String ios_app_scheme;			//카카오페이 결제 화면으로 이동하는 iOS 앱 스킴	
	private String created_at;				//결제 준비 요청 시간
	
	private String tms_result;	
	private String pg_token;				//결제승인 요청을 인증하는 토큰, 사용자 결제 수단 선택 완료 시, approval_url로 redirection해줄 때 pg_token을 query string으로 전달
	
	private String approved_at;				//결제 승인 시간
	
	

	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getInner_total_amount() {
		return inner_total_amount;
	}
	public void setInner_total_amount(int inner_total_amount) {
		this.inner_total_amount = inner_total_amount;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPartner_order_id() {
		return partner_order_id;
	}
	public void setPartner_order_id(String partner_order_id) {
		this.partner_order_id = partner_order_id;
	}
	public String getPartner_user_id() {
		return partner_user_id;
	}
	public void setPartner_user_id(String partner_user_id) {
		this.partner_user_id = partner_user_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public Integer getTax_free_amount() {
		return tax_free_amount;
	}
	public void setTax_free_amount(Integer tax_free_amount) {
		this.tax_free_amount = tax_free_amount;
	}
	public String getApproval_url() {
		return approval_url;
	}
	public void setApproval_url(String approval_url) {
		this.approval_url = approval_url;
	}
	public String getCancel_url() {
		return cancel_url;
	}
	public void setCancel_url(String cancel_url) {
		this.cancel_url = cancel_url;
	}
	public String getFail_url() {
		return fail_url;
	}
	public void setFail_url(String fail_url) {
		this.fail_url = fail_url;
	}
	public String getCid_secret() {
		return cid_secret;
	}
	public void setCid_secret(String cid_secret) {
		this.cid_secret = cid_secret;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public Integer getVat_amount() {
		return vat_amount;
	}
	public void setVat_amount(Integer vat_amount) {
		this.vat_amount = vat_amount;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getNext_redirect_app_url() {
		return next_redirect_app_url;
	}
	public void setNext_redirect_app_url(String next_redirect_app_url) {
		this.next_redirect_app_url = next_redirect_app_url;
	}
	public String getNext_redirect_mobile_url() {
		return next_redirect_mobile_url;
	}
	public void setNext_redirect_mobile_url(String next_redirect_mobile_url) {
		this.next_redirect_mobile_url = next_redirect_mobile_url;
	}
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
	public String getAndroid_app_scheme() {
		return android_app_scheme;
	}
	public void setAndroid_app_scheme(String android_app_scheme) {
		this.android_app_scheme = android_app_scheme;
	}
	public String getIos_app_scheme() {
		return ios_app_scheme;
	}
	public void setIos_app_scheme(String ios_app_scheme) {
		this.ios_app_scheme = ios_app_scheme;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getTms_result() {
		return tms_result;
	}
	public void setTms_result(String tms_result) {
		this.tms_result = tms_result;
	}
	public String getPg_token() {
		return pg_token;
	}
	public void setPg_token(String pg_token) {
		this.pg_token = pg_token;
	}	
	public String getApproved_at() {
		return approved_at;
	}
	public void setApproved_at(String approved_at) {
		this.approved_at = approved_at;
	}
	@Override
	public String toString() {
		return "PaymentVO [pay=" + pay + ", uno=" + uno + ", cid=" + cid + ", partner_order_id=" + partner_order_id
				+ ", partner_user_id=" + partner_user_id + ", item_name=" + item_name + ", quantity=" + quantity
				+ ", total_amount=" + total_amount + ", inner_total_amount=" + inner_total_amount + ", tax_free_amount="
				+ tax_free_amount + ", approval_url=" + approval_url + ", cancel_url=" + cancel_url + ", fail_url="
				+ fail_url + ", cid_secret=" + cid_secret + ", item_code=" + item_code + ", vat_amount=" + vat_amount
				+ ", tid=" + tid + ", next_redirect_app_url=" + next_redirect_app_url + ", next_redirect_mobile_url="
				+ next_redirect_mobile_url + ", next_redirect_pc_url=" + next_redirect_pc_url + ", android_app_scheme="
				+ android_app_scheme + ", ios_app_scheme=" + ios_app_scheme + ", created_at=" + created_at
				+ ", tms_result=" + tms_result + ", pg_token=" + pg_token + ", approved_at=" + approved_at + "]";
	}
	
	
}
