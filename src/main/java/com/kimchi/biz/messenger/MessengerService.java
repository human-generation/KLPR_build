package com.kimchi.biz.messenger;

import java.util.List;

public interface MessengerService {
	public MessengerVO getMsg(MessengerVO vo);
	public void helperSendMsg(MessengerVO vo);
	public void helpersMsgRead(MessengerVO vo);
	public void helpeeSendMsg(MessengerVO vo);
	public void helpeesMsgRead(MessengerVO vo);

	public List<MessengerVO> getMessageList(MessengerVO vo);
}
