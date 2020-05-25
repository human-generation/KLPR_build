package com.kimchi.biz.helper;

import java.util.Date;

public class HelperVO {
	private int rno;
	private int uno;
	private Date sta;
	private Date end;
	private int rplace;
	private int moving;
	private int hospital;
	private int immigration;
	private int lno;
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
		return "HelperVO [rno=" + rno + ", uno=" + uno + ", sta=" + sta + ", end=" + end + ", rplace=" + rplace
				+ ", moving=" + moving + ", hospital=" + hospital + ", immigration=" + immigration + ", lno=" + lno
				+ "]";
	}
	
	
}
