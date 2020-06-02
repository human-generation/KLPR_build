package com.kimchi.biz.e_review;

import java.util.List;

public interface E_ReviewService {
	public List<E_ReviewVO> getReviewCountList(E_ReviewVO vo); 
	public List<E_ReviewVO> getReviewAvgList(E_ReviewVO vo);
}
