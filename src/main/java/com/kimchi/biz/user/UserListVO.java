package com.kimchi.biz.user;

import java.util.List;

public class UserListVO {
	private List<UserVO> userList;
	
	public List<UserVO> getUserList(){
		return userList;
	}
	
	public void setUserList(List<UserVO> userList) {
		this.userList = userList;
	}
}
