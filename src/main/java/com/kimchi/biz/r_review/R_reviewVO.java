package com.kimchi.biz.r_review;

public class R_reviewVO {
	private int rno;		 // 헬퍼번호
	private int r_vno;		 // 머더라?
	private int eno;		 // 헬피번호
	private String rcomment; // 줄리뷰
	private int rscore;		 // 평점
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getR_vno() {
		return r_vno;
	}
	public void setR_vno(int r_vno) {
		this.r_vno = r_vno;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getRcomment() {
		return rcomment;
	}
	public void setRcomment(String rcomment) {
		this.rcomment = rcomment;
	}
	public int getRscore() {
		return rscore;
	}
	public void setRscore(int rscore) {
		this.rscore = rscore;
	}
	
	@Override
	public String toString() {
		return "R_reviewVO [rno=" + rno + ", r_vno=" + r_vno + ", eno=" + eno + ", rcomment=" + rcomment + ", rscore="
				+ rscore + "]";
	}
	
}
