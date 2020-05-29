package com.kimchi.biz.language;

import java.util.List;

<<<<<<< HEAD
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="languageList")
@XmlAccessorType(XmlAccessType.FIELD)
public class LanguageListVO {
	
	@XmlElement(name="language")
	private List<LanguageVO> languageList;

	public List<LanguageVO> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<LanguageVO> languageList) {
		this.languageList = languageList;
	}
	
	
	
=======
public class LanguageListVO {

	private List<LanguageVO> languageList;
	
	public List<LanguageVO> getLanguageList(){
		return languageList;
	}
	
	public void setLanguageList(List<LanguageVO> languageList) {
		this.languageList = languageList;
	}
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
}
