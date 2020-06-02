package com.kimchi.biz.helper;

import java.util.List;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

public interface HelperService {

<<<<<<< HEAD
	public List<HelperVO> getHelperList(HelperVO vo);	// 전체 헬퍼 리스트 출력
//	public void deleteHelper(HelperVO vo);	// 날짜지난 헬퍼글 삭제하기
	public List<HelperVO> recentHelperList(HelperVO vo);	// 헬퍼 리스트 최신순 정렬
=======
	public HelperVO getHelper(HelperVO vo);
	public List<HelperVO> getHelperList(HelperVO vo);
	void insertHelper(HelperVO vo);
	void updateHelper(HelperVO vo);
	void deleteHelper(HelperVO vo);
	public List<LanguageVO> getLanguageList(LanguageVO vo);
	public List<SeoulVO> getSeoulList(SeoulVO vo);
	public List<UserVO> getUserList(UserVO vo);
>>>>>>> klpr/push_dpk_cstl

}