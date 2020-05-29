package com.kimchi.biz.helpee.impl;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helpee.HelpeeDAO;
import com.kimchi.biz.helpee.HelpeeService;
import com.kimchi.biz.helpee.HelpeeVO;

@Service("helpeeService")
<<<<<<< HEAD
public class HelpeeServiceImpl implements HelpeeService{
=======
public class HelpeeServiceImpl implements HelpeeService {

>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
	@Autowired
	private HelpeeDAO helpeeDAO;
	
	@Autowired
<<<<<<< HEAD
	HttpSession session;

	@Override
	public HelpeeVO getHelpee(HelpeeVO vo) {
		return helpeeDAO.getHelpee(vo);
	}

	@Override
	public List<HelpeeVO> getHelpeeList(HelpeeVO vo) {
		System.out.println("HelpeeServiceImpl의 getHelpeeList() 실행...");
		return helpeeDAO.getHelpeeList(vo);
	}
	
	
=======
	HttpSession httpSession;

	@Override
	public void insertHelpee(HelpeeVO vo) {
		helpeeDAO.insertHelpee(vo);
	}
	
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
}
