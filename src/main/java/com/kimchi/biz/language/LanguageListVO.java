package com.kimchi.biz.language;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class LanguageListVO {

	private List<LanguageVO> languageList;

	public List<LanguageVO> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<LanguageVO> languageList) {
		this.languageList = languageList;
	}

}
