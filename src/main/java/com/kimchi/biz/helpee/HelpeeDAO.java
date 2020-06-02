package com.kimchi.biz.helpee;

import java.util.List;

public interface HelpeeDAO {
<<<<<<< HEAD
	public HelpeeVO getHelpee(HelpeeVO vo); 
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo); // 전체 헬퍼 리스트 출력
	public void deleteHelpee(HelpeeVO vo);	// 날짜지난 헬피글 삭제하기
	public List<HelpeeVO> recentHelpeeList(HelpeeVO vo);	// 헬피 리스트 최신순 정렬
	public List<HelpeeVO> getReviewCountList(HelpeeVO vo);	// 헬피 글 개수 출력
=======
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
	public void insertHelpee(HelpeeVO vo);
	public void updateHelpee(HelpeeVO vo);
	public void deleteHelpee(HelpeeVO vo);
>>>>>>> klpr/push_dpk_cstl
}
