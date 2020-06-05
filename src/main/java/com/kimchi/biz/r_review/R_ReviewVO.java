package com.kimchi.biz.r_review;

public class R_ReviewVO {

	private int r_vno;
	private int rno;
	private int eno;
	private String rcomment;
	private int rscore;
	private int uno;

	// 다원
	private String r_avg;
	private int count;

	public int getR_vno() {
		return r_vno;
	}

	public void setR_vno(int r_vno) {
		this.r_vno = r_vno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
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

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getR_avg() {
		return r_avg;
	}

	public void setR_avg(String r_avg) {
		this.r_avg = r_avg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "R_reviewVO [r_vno=" + r_vno + ", rno=" + rno + ", eno=" + eno + ", rcomment=" + rcomment + ", rscore="
				+ rscore + ", uno=" + uno + ", r_avg=" + r_avg + ", count=" + count + "]";
	}

}