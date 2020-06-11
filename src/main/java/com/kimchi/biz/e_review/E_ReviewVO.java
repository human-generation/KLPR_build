package com.kimchi.biz.e_review;

public class E_ReviewVO {
	// 헬퍼가 헬피에게 쓰는 리뷰 = 헬피가 받는 리뷰
	private int e_vno; // 헬피가 받는 리뷰 번호
	private int eno; // 헬피 번호
	private int rno; // 리뷰 쓴 헬퍼 번호
	private String ecomment; // 헬피에게 쓴 코멘트
	private int escore; // 헬피에게 준 평점

	// 희성
	private int uno;
	// 나영
	private String e_avg;
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

	public int getEscore() {
		return escore;
	}

	public void setEscore(int escore) {
		this.escore = escore;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getE_avg() {
		return e_avg;
	}

	public void setE_avg(String e_avg) {
		this.e_avg = e_avg;
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
				+ escore + ", uno=" + uno + ", e_avg=" + e_avg + ", count=" + count + "]";
	}

}
