package com.kimchi.biz.helper;

import java.util.List;

import com.kimchi.biz.r_review.R_reviewVO;
import com.kimchi.biz.seoul.SeoulVO;

public interface HelperService {
	public HelperVO getHelper(HelperVO vo);
	public List<HelperVO> getHelperList(HelperVO vo);	// 전체 헬퍼 리스트 출력
	public List<HelperVO> recentHelperList(HelperVO vo);	// 헬퍼 리스트 최신순 정렬
	public List<HelperVO> scoreHelperList(HelperVO vo);	// 헬퍼 리스트 평점순 정렬
	
	public List<HelperVO> moveHelper(HelperVO vo);	// 이사 헬퍼 리스트	
	public List<HelperVO> hospitalHelper(HelperVO vo);	// 병원 헬퍼 리스트
	public List<HelperVO> immigrationHelper(HelperVO vo);	// 출입국 헬퍼 리스트
	public List<HelperVO> seoulHelperList(HelperVO vo);	// 헬퍼 리스트 지역별로
	
	public List<HelperVO> helper_avg(HelperVO vo);	// 평점 담는 리스트?ㅅㅂ
	
	public List<R_reviewVO> getR_ReviewCountList(R_reviewVO vo);	// 헬퍼 글 개수 출력
	public List<R_reviewVO> getR_ReviewAvgList(R_reviewVO vo);	// 헬퍼 글 개수 출력
	public List<SeoulVO> getSeoulList(SeoulVO vo);	// 지역 리스트 받아오기
	

}