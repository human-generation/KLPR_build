package com.kimchi.biz.e_review;

import java.util.List;

public interface E_ReviewDAO {
	// 헬피가 받는 리뷰를 추가한다
	public void insertE_Review(E_ReviewVO vo);

	// 헬피가 받은 리뷰 보기
	public E_ReviewVO getE_Review(E_ReviewVO vo);

	// 헬피들이 받은 리뷰 리스트
	public List<E_ReviewVO> getE_ReviewList(E_ReviewVO vo); // 헬피 리뷰 리스트
	
	public List<E_ReviewVO> getE_ReviewCountList(E_ReviewVO vo); // 헬피 리뷰 개수 세기
	public List<E_ReviewVO> getE_ReviewAvgList(E_ReviewVO vo); // 헬피 평점 계산

	
}
