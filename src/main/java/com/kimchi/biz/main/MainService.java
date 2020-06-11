package com.kimchi.biz.main;

import java.util.List;

public interface MainService {
	
	
	//헬퍼 평점 리스트
	public List<MainVO> selectHelperScore();

	//헬피 평점 리스트
	public List<MainVO> selectHelpeeScore();

		
	//헬퍼 평점 전체 평균;
	public MainVO selectHelperScoreAvg(MainVO vo);
		
	//헬피 평점 전체 평균;
	public MainVO selectHelpeeScoreAvg(MainVO vo);
		
		
	//가장 평점이 높은 헬퍼 top5 리스트 
	public List<MainVO> selectRScoreTop5();
		
	//가장 많은 도움을 준 헬퍼 top5 리스트 
	public List<MainVO> selectRTop5();
		
	//가장 도움을 많이 받은 헬피 top5 리스트 
	public List<MainVO> selectETop5();

	
	
}
