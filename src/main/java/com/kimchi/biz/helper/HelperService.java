package com.kimchi.biz.helper;

import java.util.List;

public interface HelperService {
	public HelperVO getHelper(HelperVO vo);
	public List<HelperVO> getHelperList(HelperVO vo);	// 전체 헬퍼 리스트 출력
	public void deleteHelper(HelperVO vo);	// 날짜지난 헬퍼글 삭제하기
	public List<HelperVO> recentHelperList(HelperVO vo);	// 헬퍼 리스트 최신순 정렬
	public List<HelperVO> scoreHelperList(HelperVO vo);	// 헬퍼 리스트 평점순 정렬

}