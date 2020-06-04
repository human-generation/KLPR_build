package com.kimchi.biz.helper;

import java.util.List;

import com.kimchi.biz.seoul.SeoulVO;

public interface HelperDAO {
	public HelperVO getHelper(HelperVO vo);
	public List<HelperVO> getHelperList(HelperVO vo);	// 전체 헬퍼 리스트 출력
	public void deleteHelper(HelperVO vo);	// 날짜지난 헬퍼글 삭제하기
	public List<HelperVO> recentHelperList(HelperVO vo);	// 헬퍼 리스트 최신순 정렬
	public List<HelperVO> scoreHelperList(HelperVO vo);	// 헬퍼 리스트 평점순 정렬
	
	public List<HelperVO> moveHelper(HelperVO vo);	// 이사 헬퍼 리스트	
	public List<HelperVO> hospitalHelper(HelperVO vo);	// 병원 헬퍼 리스트
	public List<HelperVO> immigrationHelper(HelperVO vo);	// 출입국 헬퍼 리스트
	
	public List<HelperVO> seoulHelperList(HelperVO vo);	// 헬퍼 리스트 지역별로
	
	public List<HelperVO> helper_avg(HelperVO vo);	// 평점 담는 리스트?ㅅㅂ

}
