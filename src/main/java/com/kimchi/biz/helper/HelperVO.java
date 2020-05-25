package com.kimchi.biz.helper;

import java.sql.Date;

public class HelperVO {
	private int rno;	// 헬퍼 번호
	private int uno;	// 사용자 번호
	private Date sta;	// 가능 시작일
	private Date end;	// 가능 종료일
	private int rplace;	// 헬퍼의 지역
	private int moving;	// 이사
	private int hospital;	// 병원
	private int immigration;// 출입국
	private int lno;	// 언어 번호
	
	public int getRno() {
		return rno;
	}
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
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	@Override
	public String toString() {
		return "helperVO [rno=" + rno + ", uno=" + uno + ", sta=" + sta + ", end=" + end + ", rplace=" + rplace
				+ ", moving=" + moving + ", hospital=" + hospital + ", immigration=" + immigration + ", lno=" + lno
				+ "]";
	}
	
}
