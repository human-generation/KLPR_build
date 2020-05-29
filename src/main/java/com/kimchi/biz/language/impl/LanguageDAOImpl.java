package com.kimchi.biz.language.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimchi.biz.language.LanguageDAO;
import com.kimchi.biz.language.LanguageVO;

@Repository("languageDAO")
public class LanguageDAOImpl implements LanguageDAO{

	@Override
	public List<LanguageVO> getLanguageList(LanguageVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
