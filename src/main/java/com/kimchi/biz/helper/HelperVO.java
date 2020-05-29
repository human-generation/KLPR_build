package com.kimchi.biz.helper;

<<<<<<< HEAD
import java.sql.Date;

public class HelperVO {
	private int rno;	// 헬퍼 번호
	private int uno;	// 유저 번호
	private Date sta;	// 가능 시작일
	private Date end;	// 가능 종료일
	private int rplace;	// 가능 지역
	private int moving;	// 이사
	private int hospital;	// 병원
	private int immigration;// 출입국
	private String r_intro;	// 자기소개
	
	private String name;	// 유저이름
	private String language;// 언어
=======

public class HelperVO {
	private int rno;
	private int uno;
	private String sta;
	private String end;
	private int rplace;
	private int moving;
	private int hospital;
	private int immigration;
	private int lno;
	private String r_intro;
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
	
	public int getRno() {
		return rno;
	}
<<<<<<< HEAD

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public Date getSta() {
		return sta;
	}

	public void setSta(Date sta) {
		this.sta = sta;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getRplace() {
		return rplace;
	}

	public void setRplace(int rplace) {
		this.rplace = rplace;
	}

	public int getMoving() {
		return moving;
	}

	public void setMoving(int moving) {
		this.moving = moving;
	}

	public int getHospital() {
		return hospital;
	}

	public void setHospital(int hospital) {
		this.hospital = hospital;
	}

	public int getImmigration() {
		return immigration;
	}

	public void setImmigration(int immigration) {
		this.immigration = immigration;
	}

	public String getR_intro() {
		return r_intro;
	}

	public void setR_intro(String r_intro) {
		this.r_intro = r_intro;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "HelperListVO [rno=" + rno + ", uno=" + uno + ", sta=" + sta + ", end=" + end + ", rplace=" + rplace
				+ ", moving=" + moving + ", hospital=" + hospital + ", immigration=" + immigration + ", r_intro="
				+ r_intro + ", name=" + name + ", language=" + language + "]";
	}
	
}
=======
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getRplace() {
		return rplace;
	}
	public void setRplace(int rplace) {
		this.rplace = rplace;
	}
	public int getMoving() {
		return moving;
	}
	public void setMoving(int moving) {
		this.moving = moving;
	}
	public int getHospital() {
		return hospital;
	}
	public void setHospital(int hospital) {
		this.hospital = hospital;
	}
	public int getImmigration() {
		return immigration;
	}
	public void setImmigration(int immigration) {
		this.immigration = immigration;
	}
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getR_intro() {
		return r_intro;
	}
	public void setR_intro(String r_intro) {
		this.r_intro = r_intro;
	}
	
	@Override
	public String toString() {
		return "HelperVO [rno=" + rno + ", uno=" + uno + ", sta=" + sta + ", end=" + end + ", rplace=" + rplace
				+ ", moving=" + moving + ", hospital=" + hospital + ", immigration=" + immigration + ", lno=" + lno
				+ ", r_intro=" + r_intro + "]";
	}

	
	}
	

>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
