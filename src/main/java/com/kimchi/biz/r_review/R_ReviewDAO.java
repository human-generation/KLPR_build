package com.kimchi.biz.r_review;

import java.util.List;

public interface R_reviewDAO {
	public List<R_reviewVO> getR_ReviewCountList(R_reviewVO vo); // 헬퍼 리뷰 개수 세기
	public List<R_reviewVO> getR_ReviewAvgList(R_reviewVO vo); // 헬퍼 평점 계산
}
