package com.kimchi.biz.helper;

import java.util.List;

public interface HelperDAO {
	
	// 헬퍼 정보 가져오기
	public HelperVO getHelper(HelperVO vo);
	
	// 이사서비스 헬퍼 보여주기
	public HelperVO getMoving(HelperVO vo);
	
	// 병원서비스 헬퍼 보여주기
	public HelperVO getHospital(HelperVO vo);

	// 출입국서비스 헬퍼 보여주기
	public HelperVO getImmigration(HelperVO vo);
	
	// 평점순 정렬하기
	public List<HelperVO> getHelperList(HelperVO vo);
}
