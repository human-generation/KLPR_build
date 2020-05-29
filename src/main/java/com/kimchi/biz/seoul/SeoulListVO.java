package com.kimchi.biz.seoul;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="seoulList")
@XmlAccessorType(XmlAccessType.FIELD)
public class SeoulListVO {
	
	@XmlElement(name="language")
	private List<SeoulVO> seoulList;

	public List<SeoulVO> getSeoulList() {
		return seoulList;
	}

	public void setSeoulList(List<SeoulVO> seoulList) {
		this.seoulList = seoulList;
	}
	
	
}
