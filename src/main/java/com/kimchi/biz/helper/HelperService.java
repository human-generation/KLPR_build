package com.kimchi.biz.helper;

import java.util.List;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.r_review.R_ReviewVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

public interface HelperService {

	public HelperVO getHelper(HelperVO vo);

	public List<HelperVO> getHelperList(HelperVO vo);
	void insertHelper(HelperVO vo);
	void updateHelper(HelperVO vo);
	void deleteHelper(HelperVO vo);
	public List<LanguageVO> getLanguageList(LanguageVO vo);
	public List<SeoulVO> getSeoulList(SeoulVO vo);
	public List<UserVO> getUserList(UserVO vo);

//	public void deleteDateHelper(HelperVO vo);	// 날짜지난 헬퍼글 삭제하기
	public List<HelperVO> seoulHelperList(HelperVO vo);	// 헬퍼 리스트 지역별로

	public List<HelperVO> recentHelperList(HelperVO vo);	// 헬퍼 리스트 최신순 정렬
//	public List<HelperVO> scoreHelperList(HelperVO vo);	// 헬퍼 리스트 평점순 정렬
	
	public List<HelperVO> moveHelper(HelperVO vo);	// 이사 헬퍼 리스트	
	public List<HelperVO> hospitalHelper(HelperVO vo);	// 병원 헬퍼 리스트
	public List<HelperVO> immigrationHelper(HelperVO vo);	// 출입국 헬퍼 리스트
	
	public List<R_ReviewVO> getR_ReviewCountList(R_ReviewVO vo);	// 헬퍼 리뷰 개수 출력
	public List<R_ReviewVO> getR_ReviewAvgList(R_ReviewVO vo);	// 헬퍼 리뷰 평점 출력
	
}