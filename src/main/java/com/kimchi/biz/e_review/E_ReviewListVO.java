package com.kimchi.biz.e_review;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="e_reviewList")
@XmlAccessorType(XmlAccessType.FIELD)
public class E_ReviewListVO {
	
	@XmlElement(name="e_review")
	private List<E_ReviewVO> e_reviewList;

	public List<E_ReviewVO> getE_reviewList() {
		return e_reviewList;
	}

	public void setE_reviewList(List<E_ReviewVO> e_reviewList) {
		this.e_reviewList = e_reviewList;
	}
	
	
}
