package com.kimchi.biz.matching;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MatchingVO {
	// 매칭테이블
	@XmlAttribute
	private int mno; // 매칭번호
	private int seno; // 요청한 유저 번호
	private int rcno; // 요청 받은 유저 번호
	private int rno; // 헬퍼 역할의 유저 번호
	private int eno; // 헬피 역할의 유저 번호
	private String mdate; // 서비스 날짜
	private int mplace; // 서비스 장소
	private int mservice; // 서비스 종류(1=이사, 2=병원, 3=출입국)
	private int mstate; // 매칭상태(0=요정받음, 1=요청보냄, 2=결제대기, 3=결제완료(서비스전까지 채팅중), 4=서비스완료(이전내역으로가기), 5=거절

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

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
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
