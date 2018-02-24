package org.teamup.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamup.domain.MemberVO;
import org.teamup.service.PrtcMemberService;

@Controller
@RequestMapping("/board")
public class PrtcMemberController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(PrtcMemberController.class);
	
	@RequestMapping(value = "/myParticipation", method = RequestMethod.GET)
	public void myParticipation(Model model, HttpSession session) throws Exception{
		logger.info("myParticipation - GET");
		model.addAttribute("list", prtcMemberService.readPrtcMember(((MemberVO)session.getAttribute("member")).getMemberId()));
	}	
}
