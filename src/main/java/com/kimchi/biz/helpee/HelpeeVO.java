package com.kimchi.biz.helpee;

import com.kimchi.biz.e_review.E_ReviewVO;
import com.kimchi.biz.language.LanguageVO;
import com.kimchi.biz.seoul.SeoulVO;
import com.kimchi.biz.user.UserVO;

public class HelpeeVO {
	private int eno;
	private int uno;
	private String edate;
	private int eplace;
	private int moving;
	private int hospital;
	private int immigration;
	private int lno;
	private String e_intro;
	
	private UserVO userVO;
	private LanguageVO languageVO;
	private SeoulVO seoulVO;
	private E_ReviewVO e_reviewVO;
	
	
	public E_ReviewVO getE_reviewVO() {
		return e_reviewVO;
	}
	public void setE_reviewVO(E_ReviewVO e_reviewVO) {
		this.e_reviewVO = e_reviewVO;
	}
	public SeoulVO getSeoulVO() {
		return seoulVO;
	}
	public void setSeoulVO(SeoulVO seoulVO) {
		this.seoulVO = seoulVO;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public LanguageVO getLanguageVO() {
		return languageVO;
	}
	public void setLanguageVO(LanguageVO languageVO) {
		this.languageVO = languageVO;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public int getEplace() {
		return eplace;
	}
	public void setEplace(int eplace) {
		this.eplace = eplace;
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
	
	public String getE_intro() {
		return e_intro;
	}
	public void setE_intro(String e_intro) {
		this.e_intro = e_intro;
	}
	
	@Override
	public String toString() {
		return "HelpeeVO [eno=" + eno + ", uno=" + uno + ", edate=" + edate + ", eplace=" + eplace + ", moving="
				+ moving + ", hospital=" + hospital + ", immigration=" + immigration + ", lno=" + lno + ", e_intro="
				+ e_intro + ", userVO=" + userVO + ", languageVO=" + languageVO + ", seoulVO=" + seoulVO + "]";
	}
	
	
	
}
