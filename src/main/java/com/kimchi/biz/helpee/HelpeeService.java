package com.kimchi.biz.helpee;

import java.util.List;

import com.kimchi.biz.e_review.E_ReviewVO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

public interface HelpeeService {
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
	void insertHelpee(HelpeeVO vo);
	void updateHelpee(HelpeeVO vo);
	void deleteHelpee(HelpeeVO vo);
	public List<LanguageVO> getLanguageList(LanguageVO vo);
	public List<SeoulVO> getSeoulList(SeoulVO vo);
	public List<UserVO> getUserList(UserVO vo);

	public List<HelpeeVO> recentHelpeeList(HelpeeVO vo);	// 헬피 리스트 최신순 정렬
	public List<HelpeeVO> seoulHelpeeList(HelpeeVO vo);	// 헬퍼 리스트 지역별로
	
	public List<HelpeeVO> moveHelpee(HelpeeVO vo);	// 이사 헬퍼 리스트	
	public List<HelpeeVO> hospitalHelpee(HelpeeVO vo);	// 병원 헬퍼 리스트
	public List<HelpeeVO> immigrationHelpee(HelpeeVO vo);	// 출입국 헬퍼 리스트
	
	public List<E_ReviewVO> getE_ReviewCountList(E_ReviewVO vo);	// 헬피 글 개수 출력
	public List<E_ReviewVO> getE_ReviewAvgList(E_ReviewVO vo);	// 헬피 리뷰 평점 출력
	
}
