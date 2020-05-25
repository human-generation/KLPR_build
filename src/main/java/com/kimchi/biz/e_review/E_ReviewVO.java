package com.kimchi.biz.e_review;

public class E_ReviewVO {
	private int e_vno;
	private int eno;
	private int rno;
	private String ecomment;
	private int escore;

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

	public int getEscore() {
		return escore;
	}

	public void setEscore(int escore) {
		this.escore = escore;
	}

	@Override
	public String toString() {
		return "E_ReviewVO [e_vno=" + e_vno + ", eno=" + eno + ", rno=" + rno + ", ecomment=" + ecomment + ", escore="
				+ escore + "]";
	}
}
