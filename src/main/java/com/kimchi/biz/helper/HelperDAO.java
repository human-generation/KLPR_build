package com.kimchi.biz.helper;

import java.util.List;

import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

public interface HelperDAO {
	public HelperVO getHelper(HelperVO vo);
//	public List<Object> getHelperJoinList(HelperVO vo, UserVO uvo, LanguageVO lvo, SeoulVO svo);
	public List<HelperVO> getHelperList(HelperVO vo);
	public void insertHelper(HelperVO vo); // 헬퍼 글 등록
	public void updateHelper(HelperVO vo); // 헬퍼 글 수정 
	public void deleteHelper(HelperVO vo); // 헬퍼 글 삭제
}
