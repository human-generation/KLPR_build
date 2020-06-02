package com.kimchi.biz.e_review;

public class E_ReviewVO {
	private int e_vno;
	private int eno;
	private int rno;
	private String ecomment;
	private double escore;
	private int count;

	public int getE_vno() {
		return e_vno;
	}

	public void setE_vno(int e_vno) {
		this.e_vno = e_vno;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getEcomment() {
		return ecomment;
	}

	public void setEcomment(String ecomment) {
		this.ecomment = ecomment;
	}

	public double getEscore() {
		return escore;
	}

	public void setEscore(double escore) {
		this.escore = escore;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "E_ReviewVO [e_vno=" + e_vno + ", eno=" + eno + ", rno=" + rno + ", ecomment=" + ecomment + ", escore="
				+ escore + ", count=" + count + "]";
	}

}
