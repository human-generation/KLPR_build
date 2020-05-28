package com.kimchi.biz.helpee;


//단일 데이터의 접근과 갱신만 처리
//사용자의 요구에 맞게 가공하는 건 Service 단에서 해야 함

public interface HelpeePRDAO {
	
	public void insertEPR(HelpeePRVO vo);
}
