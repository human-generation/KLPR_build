package com.kimchi.biz.e_review;

import java.util.List;

public interface E_ReviewService {
	public void insertE_Review(E_ReviewVO vo);

	public E_ReviewVO getE_Review(E_ReviewVO vo);

	public List<E_ReviewVO> getE_ReviewList(E_ReviewVO vo);
	
	public void E_countNum(E_ReviewVO vo);
}
