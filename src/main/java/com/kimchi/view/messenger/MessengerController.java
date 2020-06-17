package com.kimchi.view.messenger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimchi.biz.messenger.MessengerVO;

@Controller
public class MessengerController {

	@RequestMapping(value = "/helperMsg.do", method = {RequestMethod.GET})
	public String getHelperMsgView(@ModelAttribute("msg") MessengerVO vo, Model model) {
		
		return "MyPageDetailProcess.jsp";
	}
	
}
