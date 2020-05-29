package com.kimchi.biz.seoul;

<<<<<<< HEAD
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class SeoulVO {
	@XmlAttribute
=======
public class SeoulVO {
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
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
	
<<<<<<< HEAD
=======
	@Override
	public String toString() {
		return "SeoulVO [dno=" + dno + ", district=" + district + "]";
	}
	
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
	
}
