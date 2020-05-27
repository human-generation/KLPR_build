package com.kimchi.biz.helper;

import java.util.List;

public interface HelperService {

	// 헬퍼 리스트 가져오기
	List<HelperVO> getHelperList(HelperVO vo);

	// 이사서비스 헬퍼 보여주기
	List<HelperVO> getMoving(HelperVO vo);

	// 병원서비스 헬퍼 보여주기
	List<HelperVO> getHospital(HelperVO vo);

	// 출입국서비스 헬퍼 보여주기
	List<HelperVO> getImmigration(HelperVO vo);

}