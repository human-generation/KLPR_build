package com.kimchi.biz.matching;

import java.util.List;

<<<<<<< HEAD
import com.kimchi.biz.user.UserVO;

public interface MatchingService {
	public List<MatchingVOExtra> getMatchingList(UserVO vo, int state);
	public void updateState(MatchingVOExtra mvo) ;
=======
public interface MatchingService {
	// 매칭리스트를 추가한다(state=1, 요청보내서 받음.)
	public void insertMatchingState1(MatchingVO vo);

	// 매칭리스트의 state를 업데이트 한다(state=2, 요청확인을 해서 결제대기 상태)
	public void updateMatchingState2(MatchingVO vo);

	// 매칭리스트의 state를 업데이트 한다(state=3, 결제완료~서비스이용직전까지 상태)
	public void updateMatchingState3(MatchingVO vo);

	// 매칭리스트의 state를 업데이트 한다(state=4, 서비스이용 후 리뷰까지 작성함. 이전내역에서 볼수있음.)
	public void updateMatchingState4(MatchingVO vo);

	// 매칭리스트의 state를 업데이트 한다(state=5, 요청단계에서 거절했을시)
	public void updateMatchingState5(MatchingVO vo);

	// 매칭리스트 상세보기
	public MatchingVO getMatching(MatchingVO vo);

	// 매칭리스트(내가 보낸 요청 매칭 리스트 : seno == 유저번호, state=1)
	public List<MatchingVO> getMatchingSenderList(MatchingVO vo);

	// 매칭리스트(내가 받은 요청 매칭 리스트 : rcno == 유저번호, state=1)
	public List<MatchingVO> getMatchingReceiverList(MatchingVO vo);

	// 매칭리스트(결제 대기 중인 매칭 리스트 : seno == 유저번호 || rcno == 유저번호 , state=2)
	public List<MatchingVO> getMatchingState2List(MatchingVO vo);

	// 매칭리스트(결제완료 후 서비스 전인 매칭 리스트 : seno == 유저번호 || rcno == 유저번호 , state=3)
	public List<MatchingVO> getMatchingState3List(MatchingVO vo);

	// 매칭리스트(서비스완료, 리뷰작성 후 이전내역에 보여지는 매칭리스트 : seno == 유저번호 || rcno == 유저번호 ,state=4)
	public List<MatchingVO> getMatchingState4List(MatchingVO vo);

	// 매칭리스트(거절당한 매칭 리스트 : seno == 유저번호, state=5)
	public List<MatchingVO> getMatchingSenderState5List(MatchingVO vo);

	// 매칭리스트(거절한 매칭 리스트 : rcno == 유저번호, state=5)
	public List<MatchingVO> getMatchingReceiverState5List(MatchingVO vo);
>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
}
