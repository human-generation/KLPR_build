package com.kimchi.view.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.messenger.MessengerService;
import com.kimchi.biz.messenger.MessengerVO;

@Controller
public class MessengerController {

	@Autowired
	private MessengerService messengerService;
	
	@RequestMapping(value = "/helperMsg.do", method = {RequestMethod.GET})
	public String getHelperMsgView(@ModelAttribute("msg") MessengerVO vo, Model model) {
		
		return "MyPageDetailProcess.jsp";
	}
	
	@RequestMapping(value = "/getMessageList.do", method = {RequestMethod.GET})
	public String getMessageList(@ModelAttribute("msg") MessengerVO vo, Model model) {
		System.out.println("리스트 메시지 보여주기(controller)");
		
		// 모델에 메시지 리스트 담기
		model.addAttribute("msgList", messengerService.getMessageList(vo));

		return "getHelperList.jsp";
	}
	
	
}
