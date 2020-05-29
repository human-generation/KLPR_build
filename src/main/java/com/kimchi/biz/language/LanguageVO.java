package com.kimchi.biz.language;

<<<<<<< HEAD
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class LanguageVO {
	@XmlAttribute
	private int lno;
	private String language;
	
	public int getLno() {
		return lno;
	}
=======
public class LanguageVO {
	private int lno;
	private String language;
	
	
	public int getLno() {
		return lno;
	}
	
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
<<<<<<< HEAD
=======
	@Override
	public String toString() {
		return "LanguageVO [lno=" + lno + ", language=" + language + "]";
	}
	
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
	
}
