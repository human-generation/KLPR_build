package com.kimchi.biz.helper;

<<<<<<< HEAD
import java.util.List;

public interface HelperDAO {
	public HelperVO getHelper(HelperVO vo);
	public List<HelperVO> getHelperList(HelperVO vo);

=======
public interface HelperDAO {
	 
	public HelperVO getHelper(HelperVO vo);	// 상세 헬퍼 글 보기 
	public void insertHelper(HelperVO vo); // 헬퍼 글 등록
	public void updateHelper(HelperVO vo); // 헬퍼 글 수정 
	public void deleteHelper(HelperVO vo); // 헬퍼 글 삭제
	
	
	
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
}
