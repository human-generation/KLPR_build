package com.kimchi.biz.user;

import java.util.List;

// DAO와 Service의 차이
// DAO와 Service는 그 역할이 분명히 다르다.
// DAO - 단일 데이터의 접근과 갱신만 처리한다(CRUD)
// Service - 여러 DAO를 호출하여 사용자의 요구에 맞게 가공한다.
// 즉, Service는 트랜잭션 단위이다.

// DAO와 Service가 완전히 동일해지는 경우도 분명히 발생하지만, 그건 설계를 잘못한 것이다.

// Service에서 관리해주는 메소드는 10개내외가 적당.

public interface UserDAO {
	// 회원 존재 여부를 알려준다
	public UserVO getUser(UserVO vo);

	// 회원을 가입시킨다
	public void insertUser(UserVO vo);

<<<<<<< HEAD
	public void updateUserMoney(UserVO vo, int pay);
	
	public void updateUser(UserVO vo);

=======
	// 회원의 돈 충전(소희)
	public void updateUserMoney(UserVO vo, int pay);

	// 회원 정보 수정(소희)
	public void updateUser(UserVO vo);

	// 회원 목록
	public List<UserVO> getUserList(UserVO vo);

>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
}
