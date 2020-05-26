package com.kimchi.biz.helper;

import java.util.List;

public interface HelperDAO {
	
	// 헬퍼 리스트 가져오기
	public List<HelperVO> getHelperList(HelperVO vo);
	
	// 이사서비스 헬퍼 보여주기
	public List<HelperVO> getMoving(HelperVO vo);
	
	// 병원서비스 헬퍼 보여주기
	public List<HelperVO> getHospital(HelperVO vo);
	
	// 출입국서비스 헬퍼 보여주기
	public List<HelperVO> getImmigration(HelperVO vo);
}
