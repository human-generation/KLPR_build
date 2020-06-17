package com.kimchi.biz.messenger;

public interface MessengerService {
	public MessengerVO getMsg(MessengerVO vo);
	public void helperSendMsg(MessengerVO vo);
	public void helpersMsgRead(MessengerVO vo);
	public void helpeeSendMsg(MessengerVO vo);
	public void helpeesMsgRead(MessengerVO vo);
}
