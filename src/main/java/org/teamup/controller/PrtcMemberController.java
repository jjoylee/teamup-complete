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
public class PrtcMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(PrtcMemberController.class);


	@Inject
	private PrtcMemberService service;
	
	@RequestMapping(value = "/myParticipation", method = RequestMethod.GET)
	public void myParticipation(Model model, HttpSession session) throws Exception{
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
		int memberId = vo.getMemberId();
		
		model.addAttribute("list", service.readPrtcMember(memberId));
		logger.info("Welcome myParticipation.");
		
	}
	
}
