package com.kimchi.biz.helpee;

import java.util.List;


//@XmlRootElement(name="helpeeList")
//@XmlAccessorType(XmlAccessType.FIELD)
public class HelpeeListVO {
	
	//@XmlElement(name="helpee")
	private List<HelpeeVO> helpeeList;
	
	public List<HelpeeVO> getHelpeeList(){
		return helpeeList;
	}
	
	public void setHelpeeList(List<HelpeeVO> helpeeList) {
		this.helpeeList = helpeeList;
	}
}
