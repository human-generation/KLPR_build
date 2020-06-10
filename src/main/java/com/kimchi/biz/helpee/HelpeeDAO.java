package com.kimchi.biz.helpee;

import java.util.List;

public interface HelpeeDAO {
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
	public void insertHelpee(HelpeeVO vo);
	public void updateHelpee(HelpeeVO vo);
	public void deleteHelpee(HelpeeVO vo);
	
	public void deleteDateHelpee(HelpeeVO vo);	// 날짜지난 헬피글 삭제하기
	public List<HelpeeVO> recentHelpeeList(HelpeeVO vo);	// 헬피 리스트 최신순 정렬
	public List<HelpeeVO> scoreHelpeeList(HelpeeVO vo);	// 헬피 리스트 평점순 정렬
	
	public List<HelpeeVO> moveHelpee(HelpeeVO vo);	// 이사 헬퍼 리스트	
	public List<HelpeeVO> hospitalHelpee(HelpeeVO vo);	// 병원 헬퍼 리스트
	public List<HelpeeVO> immigrationHelpee(HelpeeVO vo);	// 출입국 헬퍼 리스트
	
	public List<HelpeeVO> seoulHelpeeList(HelpeeVO vo);	// 헬퍼 리스트 지역별로
}
