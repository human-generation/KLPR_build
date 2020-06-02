package com.kimchi.biz.main;

public class MainVO {
	private int uno;
	private String name;
	
	private int mstate;
	
	private int rno;
	private int rscore;
	
	private int eno;
	private int escore;
	
	private int ranking;	//TOP5 순번 변수
	private int n;			//TOP5 활동 수 count
	
	
	
	
	public int getUno() {
		return uno;
	}
	public MainVO setUno(int uno) {
		this.uno = uno;
		return this;
	}
	public String getName() {
		return name;
	}
	public MainVO setName(String name) {
		this.name = name;
		return this;
	}
	public int getMstate() {
		return mstate;
	}
	public MainVO setMstate(int mstate) {
		this.mstate = mstate;
		return this;
	}
	public int getRno() {
		return rno;
	}
	public MainVO setRno(int rno) {
		this.rno = rno;
		return this;
	}
	public int getRscore() {
		return rscore;
	}
	public MainVO setRscore(int rscore) {
		this.rscore = rscore;
		return this;
	}
	public int getEno() {
		return eno;
	}
	public MainVO setEno(int eno) {
		this.eno = eno;
		return this;
	}
	public int getEscore() {
		return escore;
	}
	public MainVO setEscore(int escore) {
		this.escore = escore;
		return this;
	}
	public int getN() {
		return n;
	}
	public MainVO setN(int n) {
		this.n = n;
		return this;
	}
	public int getRanking() {
		return ranking;
	}
	public MainVO setRanking(int ranking) {
		this.ranking = ranking;
		return this;
	}

}
