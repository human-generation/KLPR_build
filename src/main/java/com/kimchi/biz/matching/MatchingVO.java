package com.kimchi.biz.matching;

import java.sql.Date;

public class MatchingVO {
	private int mno;
	private int seno;
	private int rcno;
	private int rno;
	private int eno;
	private Date mdate;
	private int mplace;
	private int mservice;
	private int mstate;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getSeno() {
		return seno;
	}
	public void setSeno(int seno) {
		this.seno = seno;
	}
	public int getRcno() {
		return rcno;
	}
	public void setRcno(int rcno) {
		this.rcno = rcno;
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
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public int getMplace() {
		return mplace;
	}
	public void setMplace(int mplace) {
		this.mplace = mplace;
	}
	public int getMservice() {
		return mservice;
	}
	public void setMservice(int mservice) {
		this.mservice = mservice;
	}
	public int getMstate() {
		return mstate;
	}
	public void setMstate(int mstate) {
		this.mstate = mstate;
	}
	@Override
	public String toString() {
		return "MatchingVO [mno=" + mno + ", seno=" + seno + ", rcno=" + rcno + ", rno=" + rno + ", eno=" + eno
				+ ", mdate=" + mdate + ", mplace=" + mplace + ", mservice=" + mservice + ", mstate=" + mstate + "]";
	}
	
	
}

