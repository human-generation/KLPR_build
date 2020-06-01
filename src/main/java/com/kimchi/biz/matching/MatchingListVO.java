package com.kimchi.biz.matching;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "matchingList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MatchingListVO {

	@XmlElement(name = "matching")
	private List<MatchingVO> matchingList;

	public List<MatchingVO> getMatchingList() {
		return matchingList;
	}

	public void setMatchingList(List<MatchingVO> matchingList) {
		this.matchingList = matchingList;
	}

}
