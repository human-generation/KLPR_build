package com.kimchi.biz.helpee;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class HelpeeListVO {
	
	private List<HelpeeVO> helpeeList;
	
	public List<HelpeeVO> getHelpeeList(){
		return helpeeList;
	}
	
	public void setHelpeeList(List<HelpeeVO> helpeeList) {
		this.helpeeList = helpeeList;
	}
}
