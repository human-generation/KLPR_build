package com.kimchi.biz.helper.impl;

<<<<<<< HEAD
import java.util.List;
=======
import javax.servlet.http.HttpSession;
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.helper.HelperDAO;
<<<<<<< HEAD
import com.kimchi.biz.helper.HelperVO;
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;

@Service("HelperService")
public class HelperServiceImpl implements HelperService {
	
	@Autowired
	private HelperDAO helperDAO;

	@Override
	public List<HelperVO> getHelperList(HelperVO vo) {
		return helperDAO.getHelperList(vo);
	}

	@Override
	public HelperVO getHelper(HelperVO vo) {
		return helperDAO.getHelper(vo);
	}
	
=======
import com.kimchi.biz.helper.HelperService;
import com.kimchi.biz.helper.HelperVO;

@Service("helperService")
public class HelperServiceImpl implements HelperService{

	@Autowired
	private HelperDAO helperDAO;
	
	@Autowired
	HttpSession httpSession;

	@Override
	public HelperVO getHelper(HelperVO vo) {
		return helperDAO.getHelper(vo);
	}

	@Override
	public void insertHelper(HelperVO vo) {
		helperDAO.insertHelper(vo);
	}

	@Override
	public void updateHelper(HelperVO vo) {
		helperDAO.updateHelper(vo);
	}

	@Override
	public void deleteHelper(HelperVO vo) {
		helperDAO.deleteHelper(vo);
	}
		
>>>>>>> 6778bb1ad86d5a0cec3043efbda5ced9d3eff51a
}
