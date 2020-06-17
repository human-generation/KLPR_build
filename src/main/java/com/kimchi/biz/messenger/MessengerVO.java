package com.kimchi.biz.messenger;

public class MessengerVO {
	
	private int msgno;
	private int rno;
	private int eno;
	private String rmsg;
	private String emsg;
	private String msgdate;
	private int rstate;
	private int estate;
	
	public int getMsgno() {
		return msgno;
	}
	public void setMsgno(int msgno) {
		this.msgno = msgno;
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
	public String getRmsg() {
		return rmsg;
	}
	public void setRmsg(String rmsg) {
		this.rmsg = rmsg;
	}
	public String getEmsg() {
		return emsg;
	}
	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}
	public String getMsgdate() {
		return msgdate;
	}
	public void setMsgdate(String msgdate) {
		this.msgdate = msgdate;
	}
	public int getRstate() {
		return rstate;
	}
	public void setRstate(int rstate) {
		this.rstate = rstate;
	}
	public int getEstate() {
		return estate;
	}
	public void setEstate(int estate) {
		this.estate = estate;
	}
	
	@Override
	public String toString() {
		return "MessengerVO [msgno=" + msgno + ", rno=" + rno + ", eno=" + eno + ", rmsg=" + rmsg + ", emsg=" + emsg
				+ ", msgdate=" + msgdate + ", rstate=" + rstate + ", estate=" + estate + "]";
	}
	
	
	
	
}

