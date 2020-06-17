package com.kimchi.biz.messenger;

import java.util.List;

public interface MessengerDAO {
	public MessengerVO getMsg(MessengerVO vo);
	public void helperSendMsg(MessengerVO vo);
	public void helpersMsgRead(MessengerVO vo);
	public void helpeeSendMsg(MessengerVO vo);
	public void helpeesMsgRead(MessengerVO vo);
	
	public List<MessengerVO> getMessageList(MessengerVO vo);	// 메시지 담는 기능
}
