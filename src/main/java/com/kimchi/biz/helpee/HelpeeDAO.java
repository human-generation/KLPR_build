package com.kimchi.biz.helpee;

<<<<<<< HEAD
import java.util.List;

public interface HelpeeDAO {
	public HelpeeVO getHelpee(HelpeeVO vo);
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo);
=======

//단일 데이터의 접근과 갱신만 처리
//사용자의 요구에 맞게 가공하는 건 Service 단에서 해야 함

public interface HelpeeDAO {
	
	public void insertHelpee(HelpeeVO vo);
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
}
