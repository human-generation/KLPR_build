package com.kimchi.biz.helper;

import java.util.List;

public interface HelperService {

	public HelperVO getHelper(HelperVO vo);
	public List<HelperVO> getHelperList(HelperVO vo);
	void insertHelper(HelperVO vo);
	void updateHelper(HelperVO vo);
	void deleteHelper(HelperVO vo);
}

