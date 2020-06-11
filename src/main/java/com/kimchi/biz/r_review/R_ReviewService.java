package com.kimchi.biz.r_review;

import java.util.List;

public interface R_ReviewService {

	public void insertR_review(R_ReviewVO vo);

	public R_ReviewVO getR_Review(R_ReviewVO vo);

	public List<R_ReviewVO> getR_ReviewList(R_ReviewVO vo);
}