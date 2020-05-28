package com.kimchi.biz.helpee_review;

import java.util.List;

import com.kimchi.biz.helpee.HelpeeVO;

public interface HelpeeReviewService {
	public List<Object> getHelpeeList(HelpeeVO hVo, ReviewVO rVo);
}
