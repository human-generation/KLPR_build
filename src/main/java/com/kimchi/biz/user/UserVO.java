package com.kimchi.biz.user;

public class UserVO {
	private int uno;
	private String email;
	private String pw;
	private String name;
	private int gender;
	private int money;
	private String phone;
	private String ucomment;

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUcomment() {
		return ucomment;
	}

	public void setUcomment(String ucomment) {
		this.ucomment = ucomment;
	}

	@Override
	public String toString() {
		return "UserVO [uno=" + uno + ", email=" + email + ", pw=" + pw + ", name=" + name + ", gender=" + gender
				+ ", money=" + money + ", phone=" + phone + ", ucomment=" + ucomment + "]";
	}

}
