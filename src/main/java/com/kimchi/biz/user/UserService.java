package com.kimchi.biz.user;

//DAO와 Service의 차이
//DAO와 Service는 그 역할이 분명히 다르다.
//DAO - 단일 데이터의 접근과 갱신만 처리한다(CRUD)
//Service - 여러 DAO를 호출하여 사용자의 요구에 맞게 가공한다.
//즉, Service는 트랜잭션 단위이다.

//DAO와 Service가 완전히 동일해지는 경우도 분명히 발생하지만, 그건 설계를 잘못한 것이다.

//Service에서 관리해주는 메소드는 10개내외가 적당.

public interface UserService {
	public UserVO getUser(UserVO vo);

	public void insertUser(UserVO vo);
}
