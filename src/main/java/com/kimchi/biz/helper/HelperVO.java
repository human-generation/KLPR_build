package com.kimchi.biz.helper;

import java.sql.Date;

public class HelperVO {
	private Date sta;	// 가능 시작일
	private Date end;	// 가능 종료일
	private int rplace;	// 헬퍼의 지역
	private int moving;	// 이사
	private int hospital;	// 병원
	private int immigration;// 출입국
	private int lno;	// 언어 번호
	private int rscore;	// 리뷰 점수
	private String name;// 이름
	private String ucomment;	// 자기소개
	
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
	public int getRscore() {
		return rscore;
	}
	public void setRscore(int rscore) {
		this.rscore = rscore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUcomment() {
		return ucomment;
	}
	public void setUcomment(String ucomment) {
		this.ucomment = ucomment;
	}
	@Override
	public String toString() {
		return "HelperVO [sta=" + sta + ", end=" + end + ", rplace=" + rplace + ", moving=" + moving + ", hospital="
				+ hospital + ", immigration=" + immigration + ", lno=" + lno + ", rscore=" + rscore + ", name=" + name
				+ ", ucomment=" + ucomment + "]";
	}
	
	
	
}
