package com.kimchi.biz.helpee;

public class HelpeePRVO {
	private String edate;		// 가능 날짜
	private int eplace;		// 헬피 지역
	private int moving;		// 이사
	private int hospital;	// 병원
	private int immigration;// 출입국
	private int lno;		// 언어
	private String eIntro;  // 헬피 자기소개 (e_intro)
	
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public int getEplace() {
		return eplace;
	}
	public void setEplace(int eplace) {
		this.eplace = eplace;
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
	public String getEIntro() {
		return eIntro;
	}
	public void setEIntro(String eIntro) {
		this.eIntro = eIntro;
	}
	
	@Override
	public String toString() {
		return "HelpeePRVO [uno=" + ", edate=" + edate + ", eplace=" + eplace + ", moving=" + moving
				+ ", hospital=" + hospital + ", immigration=" + immigration + ", lno=" + lno + ", eIntro=" + eIntro
				+ "]";
	}
	
}
