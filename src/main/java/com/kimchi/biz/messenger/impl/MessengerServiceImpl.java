package com.kimchi.biz.messenger.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimchi.biz.messenger.MessengerDAO;
import com.kimchi.biz.messenger.MessengerService;
import com.kimchi.biz.messenger.MessengerVO;

@Service
public class MessengerServiceImpl implements MessengerService{
	
	@Autowired
	private MessengerDAO messengerDAO; 

	@Override
	public MessengerVO getMsg(MessengerVO vo) {
		return messengerDAO.getMsg(vo);
	}

	@Override
	public void helperSendMsg(MessengerVO vo) {
		messengerDAO.helperSendMsg(vo);
	}

	@Override
	public void helpersMsgRead(MessengerVO vo) {
		messengerDAO.helpersMsgRead(vo);
	}

	@Override
	public void helpeeSendMsg(MessengerVO vo) {
		messengerDAO.helpeeSendMsg(vo);
	}

	@Override
	public void helpeesMsgRead(MessengerVO vo) {
		messengerDAO.helpeesMsgRead(vo);
		
	}

	@Override
	public List<MessengerVO> getMessageList(MessengerVO vo) {
		return messengerDAO.getMessageList(vo);
	}

}
