package com.kimchi.biz.r_review;

public class R_reviewVO {
	private int r_vno;		
	private int rno;		
	private int eno;		 
	private String rcomment;
	private double rscore;
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
	public double getRscore() {
		return rscore;
	}
	public void setRscore(double rscore) {
		this.rscore = rscore;
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
				+ rscore + ", count=" + count + "]";
	}
	
}
