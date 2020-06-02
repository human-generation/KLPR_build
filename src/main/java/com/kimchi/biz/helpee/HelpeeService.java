package com.kimchi.biz.helpee;

import java.util.List;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;

public interface HelpeeService {
<<<<<<< HEAD
	
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo); // 전체 헬피 리스트 출력 
	public List<HelpeeVO> recentHelpeeList(HelpeeVO vo);	// 헬피 리스트 최신순 정렬
	public List<HelpeeVO> getReviewCountList(HelpeeVO vo);	// 헬피 글 개수 출력
=======
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
	void insertHelpee(HelpeeVO vo);
	void updateHelpee(HelpeeVO vo);
	void deleteHelpee(HelpeeVO vo);
	public List<LanguageVO> getLanaguageList(LanguageVO vo);
	public List<SeoulVO> getSeoulList(SeoulVO vo);

>>>>>>> klpr/push_dpk_cstl
}
