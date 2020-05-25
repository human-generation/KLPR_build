package com.kimchi.biz.helper;

public interface HelperDAO {
	// 헬퍼 존재 여부를 알려줌 
	public HelperVO getHelper(HelperVO vo);
	
	// 헬퍼 등록
	public void insertHelper(HelperVO vo); 
}
