package com.kimchi.biz.helpee;

import java.util.List;

import com.kimchi.biz.e_review.E_ReviewVO;
import com.kimchi.biz.seoul.SeoulVO;

public interface HelpeeService {
	
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo); // 전체 헬피 리스트 출력 
	public List<HelpeeVO> recentHelpeeList(HelpeeVO vo);	// 헬피 리스트 최신순 정렬
	
	public List<HelpeeVO> moveHelpee(HelpeeVO vo);	// 이사 헬퍼 리스트	
	public List<HelpeeVO> hospitalHelpee(HelpeeVO vo);	// 병원 헬퍼 리스트
	public List<HelpeeVO> immigrationHelpee(HelpeeVO vo);	// 출입국 헬퍼 리스트
	public List<HelpeeVO> seoulHelpeeList(HelpeeVO vo);	// 헬퍼 리스트 지역별로
	
	public List<E_ReviewVO> getE_ReviewCountList(E_ReviewVO vo);	// 헬피 글 개수 출력
	public List<E_ReviewVO> getE_ReviewAvgList(E_ReviewVO vo);	// 헬피 리뷰 평점 출력
	public List<SeoulVO> getSeoulList(SeoulVO vo);	// 지역 리스트 받아오기
}
