package com.kimchi.biz.e_review;

import java.util.List;

public interface E_ReviewDAO {
	public List<E_ReviewVO> getE_ReviewCountList(E_ReviewVO vo); // 헬피 리뷰 개수 세기
	public List<E_ReviewVO> getE_ReviewAvgList(E_ReviewVO vo); // 헬피 평점 계산
}
