package com.kimchi.biz.helpee;

import java.util.List;

import com.kimchi.biz.e_review.E_ReviewVO;

public interface HelpeeService {
	
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo); // 전체 헬피 리스트 출력 
	public List<HelpeeVO> recentHelpeeList(HelpeeVO vo);	// 헬피 리스트 최신순 정렬
	public List<E_ReviewVO> getReviewCountList(E_ReviewVO vo);	// 헬피 글 개수 출력
	public List<E_ReviewVO> getReviewAvgList(E_ReviewVO vo);	// 헬피 리뷰 평점 출력
}
