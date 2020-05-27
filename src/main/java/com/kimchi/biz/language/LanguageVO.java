package com.kimchi.biz.language;

public class LanguageVO {
	private int lno;
	private String language;
	public int getLno() {
		return lno;
	}
	
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return "LanguageVO [lno=" + lno + ", language=" + language + "]";
	}
	
	
}
