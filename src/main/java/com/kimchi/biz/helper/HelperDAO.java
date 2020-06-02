package com.kimchi.biz.helper;

import java.util.List;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

public interface HelperDAO {
	public HelperVO getHelper(HelperVO vo);
<<<<<<< HEAD
	public List<HelperVO> getHelperList(HelperVO vo);	// 전체 헬퍼 리스트 출력
	public void deleteHelper(HelperVO vo);	// 날짜지난 헬퍼글 삭제하기
	public List<HelperVO> recentHelperList(HelperVO vo);	// 헬퍼 리스트 최신순 정렬

=======
//	public List<Object> getHelperJoinList(HelperVO vo, UserVO uvo, LanguageVO lvo, SeoulVO svo);
	public List<HelperVO> getHelperList(HelperVO vo);
	public void insertHelper(HelperVO vo); // 헬퍼 글 등록
	public void updateHelper(HelperVO vo); // 헬퍼 글 수정 
	public void deleteHelper(HelperVO vo); // 헬퍼 글 삭제
>>>>>>> klpr/push_dpk_cstl
}
