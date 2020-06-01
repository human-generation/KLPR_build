package com.kimchi.biz.seoul;

public class SeoulVO {
	private int dno;
	private String district;
	
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "SeoulVO [dno=" + dno + ", district=" + district + "]";
	}
	
	
}
