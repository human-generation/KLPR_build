package com.kimchi.biz.helper;

public interface HelperDAO {
	 
	public HelperVO getHelper(HelperVO vo);	// 상세 헬퍼 글 보기 
	public void insertHelper(HelperVO vo); // 헬퍼 글 등록
	public void updateHelper(HelperVO vo); // 헬퍼 글 수정 
	public void deleteHelper(HelperVO vo); // 헬퍼 글 삭제
	
	
	
}
