package com.kimchi.biz.helpee;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class HelpeeVO {
	@XmlAttribute
	private int eno;
	private int uno;
	private Date edate;
	private int eplace;
	private int moving;
	private int hospital;
	private int immigration;
	private int lno;
	private String e_intro;
	
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
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
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
				+ e_intro + "]";
	}
	
	
	
}
