package com.kimchi.biz.e_review;

public interface E_ReviewDAO {
	public E_ReviewVO countE_vno(E_ReviewVO vo);	// 헬피 리뷰 개수 세기
	public E_ReviewVO avgEscore(E_ReviewVO vo);		// 헬피 평점 계산
}
