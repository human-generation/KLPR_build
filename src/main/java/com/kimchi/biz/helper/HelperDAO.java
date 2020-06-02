package com.kimchi.biz.helper;

import java.util.List;

public interface HelperDAO {
	public HelperVO getHelper(HelperVO vo);
	public void insertHelper(HelperVO vo); // 헬퍼 글 등록
	public void updateHelper(HelperVO vo); // 헬퍼 글 수정 
	public void deleteHelper(HelperVO vo); // 헬퍼 글 삭제
	public List<HelperVO> getHelperList(HelperVO vo);

}
