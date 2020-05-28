package com.kimchi.biz.helpee_review.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeVO;
import com.kimchi.biz.helpee_review.HelpeeReviewService;
import com.kimchi.biz.helpee_review.ReviewVO;

@Service("helpeeReviewService")
public class HelpeeReviewServiceImpl implements HelpeeReviewService{
	@Autowired
	HelpeeDAO hDao;
	
	@Autowired
	ReviewDAO rDao;

	@Override
	public List<Object> getHelpeeList(HelpeeVO hVo, ReviewVO rVo) {
		List<Object> list = new ArrayList<Object>();
		return list;
	}
	
//	if(obj instanceof HelpeeVO) {
//		
//	}else if(obj instanceof ReviewVO) {
//		
//	}

}
