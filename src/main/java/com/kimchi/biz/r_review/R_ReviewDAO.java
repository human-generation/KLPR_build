package com.kimchi.biz.r_review;

import java.util.List;

public interface R_ReviewDAO {

	public void insertR_review(R_ReviewVO vo);

	// 헬피가 받은 리뷰 보기
	public R_ReviewVO getR_Review(R_ReviewVO vo);

	// 헬피들이 받은 리뷰 리스트
	public List<R_ReviewVO> getR_ReviewList(R_ReviewVO vo);	// 헬퍼 리뷰 리스트

	public List<R_ReviewVO> getR_ReviewCountList(R_ReviewVO vo); // 헬퍼 리뷰 개수 세기

	public List<R_ReviewVO> getR_ReviewAvgList(R_ReviewVO vo); // 헬퍼 평점 계산
}
