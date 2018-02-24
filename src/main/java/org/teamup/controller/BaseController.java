package org.teamup.controller;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.teamup.domain.JsonResponse;
import org.teamup.domain.MemberVO;
import org.teamup.service.BoardService;
import org.teamup.service.MemberService;
import org.teamup.service.PrizeService;
import org.teamup.service.PrtcMemberService;

@Controller
public class BaseController {
	@Inject
	protected BoardService boardService;
	
	@Inject
	protected PrtcMemberService prtcMemberService;
	
	@Inject
	protected PrizeService prizeService;
	
	@Inject
	protected MemberService memberService;

	protected JsonResponse res;
	
	protected MemberVO getUser(HttpSession session){
		return (MemberVO)session.getAttribute("member");
	}
}
