package org.teamup.controller;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;



import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.teamup.domain.BoardVO;
import org.teamup.domain.Criteria;
import org.teamup.domain.MemberVO;
import org.teamup.domain.PageMaker;
import org.teamup.domain.PrtcMember;
import org.teamup.domain.SearchCriteria;
import org.teamup.service.BoardService;
import org.teamup.service.MemberService;
import org.teamup.service.PrizeService;
import org.teamup.service.PrtcMemberService;

@Controller
@RequestMapping("/board")
public class BoardController {

private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Inject
	private BoardService service;
	
	@Inject
	private PrtcMemberService service2;
	
	@Inject
	  private PrizeService service3;
	
	@Inject
	private MemberService service4;

	@RequestMapping(value = "/etcList", method = RequestMethod.GET)
	public void etcList(Model model,  @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		logger.info("Welcome etcList.");
		
		cri.setCategoryId(4);
		model.addAttribute("list", service.listSearchCriteria(cri));		
		
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    
	    pageMaker.setTotalCount(service.listSearchCount(cri));

	    model.addAttribute("pageMaker", pageMaker);		

	    
	}
		
		 	
	
	@RequestMapping(value = "/designList", method = RequestMethod.GET)
	public void	designList(Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
		logger.info("Welcome designList.");
		
		cri.setCategoryId(3);
		model.addAttribute("list", service.listSearchCriteria(cri));		
		
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    
	    pageMaker.setTotalCount(service.listSearchCount(cri));

	    model.addAttribute("pageMaker", pageMaker);


		
	}
	
	
	@RequestMapping(value = "/itList", method = RequestMethod.GET)
	public void itList(Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		logger.info("Welcome itList.");
		
		cri.setCategoryId(1);
		model.addAttribute("list", service.listSearchCriteria(cri));		
		
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    
	    pageMaker.setTotalCount(service.listSearchCount(cri));

	    model.addAttribute("pageMaker", pageMaker);
		
	}
	
	@RequestMapping(value = "/marketingList", method = RequestMethod.GET)
	public void marketingList(Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
		logger.info("Welcome marketingList");
		
		
		cri.setCategoryId(2);
		model.addAttribute("list", service.listSearchCriteria(cri));		
		
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    
	    pageMaker.setTotalCount(service.listSearchCount(cri));

	    model.addAttribute("pageMaker", pageMaker);

	}
	
	
	
	
	@RequestMapping(value = "/readWrite", method = RequestMethod.GET)
	public void readWrite(Model model, @RequestParam("boardId") Integer boardId, HttpSession session) throws Exception {
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
		model.addAttribute("sessionid", vo.getMemberId());
		logger.info("Welcome readWrite.");		
		model.addAttribute("board",service.read(boardId));
		
		PrtcMember pm = new PrtcMember();
		pm.setMemberId(((MemberVO)session.getAttribute("member")).getMemberId());
		pm.setBoardId(boardId);
		if(service2.check(pm) == null)
		{
			model.addAttribute("check", "in");
		}
		else model.addAttribute("check", "alreadyin");
	}
	
	@RequestMapping(value= "/readWrite", method = RequestMethod.POST)
	public String readWritePOST(Model model, @RequestParam("boardId") Integer boardId ){
		
		
		return "redirect:/board/updateWrite";
	}
	
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void writet(Model model) {
		logger.info("Welcome write.");		
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePost(Model model, @RequestParam("categoryId") int categoryId,BoardVO vo, HttpSession session) throws Exception{
		logger.info("Welcome write.");
		MemberVO member = (MemberVO)session.getAttribute("member");
		vo.setMemberId(member.getMemberId());
		service.insert(vo);
		if(categoryId == 1) return "redirect:/board/itList";
		else if(categoryId == 2)return "redirect:/board/marketingList";
		else if(categoryId == 3)return "redirect:/board/designList";
		else return "redirect:/board/etcList";
		
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(Model model, HttpSession session)throws Exception { 
		logger.info("Welcome write.");
		
		 if(session.getAttribute("member")==null)
			 System.out.println("no session");
		 else
			 System.out.println("session");

	}
	
	@RequestMapping(value = "/updateWrite", method = RequestMethod.GET)
	public void updateWrite(Model model, int boardId) throws Exception{
		logger.info("Welcome updateWrite.");
	
		model.addAttribute(service.read(boardId));
			}
	
	@RequestMapping(value = "/updateWrite", method = RequestMethod.POST)
	public String updateWritePOST(Model model,  BoardVO vo) throws Exception{
		logger.info("Welcome updateWrite.");
	   
		service.update(vo);
		return "redirect:/board/itList";
	}
	

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("boardId") int boardId) throws Exception{
		logger.info("Welcome updateWrite.");
	
		service2.deleteByBoardId(boardId);
		service.delete(boardId);
		return "redirect:/board/itList";
	}
	
	@RequestMapping(value = "/participate", method = RequestMethod.POST)
	public String participate(@RequestParam("boardId") int boardId, HttpSession session, RedirectAttributes rttr) throws Exception{
		logger.info("Welcome updateWrite.");
		PrtcMember pm = new PrtcMember();
		pm.setMemberId(((MemberVO)session.getAttribute("member")).getMemberId());
		pm.setBoardId(boardId);
		service.curCount(boardId);
		service2.insertPrtcMember(pm);
		return "redirect:/board/readWrite?boardId=" + boardId;
	}
	

	@RequestMapping(value = "/participate_out", method = RequestMethod.POST)
	public String participate_out(@RequestParam("boardId") int boardId, HttpSession session, RedirectAttributes rttr) throws Exception{
		logger.info("Welcome updateWrite.");
		PrtcMember pm = new PrtcMember();
		pm.setMemberId(((MemberVO)session.getAttribute("member")).getMemberId());
		pm.setBoardId(boardId);
		service.curCount2(boardId);
		service2.deletePrtcMember(pm);
		return "redirect:/board/readWrite?boardId=" + boardId;
	}
	
	@RequestMapping(value = "/myWriting", method = RequestMethod.GET)
	public void myWriting(Model model, HttpSession session) throws Exception {
		logger.info("Welcome myWriting.");
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
		int memberId = vo.getMemberId();
		model.addAttribute("list", service.findByMemId(memberId));
	}
	
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public void memberList(Model model,@RequestParam("boardId") int boardId) throws Exception {
		logger.info("Welcome myWriting.");
		model.addAttribute("list", service.memberList(boardId));
	}
	
	@RequestMapping(value = "/readMember", method = RequestMethod.GET)
	public void myWriting(Model model, @RequestParam("memberId") int memberId) throws Exception {
		logger.info("Welcome myWriting.");
		model.addAttribute("list",  service3.readPrize(memberId)); 
		model.addAttribute(service4.findByMemberId(memberId));
		String url = "D:\\upload\\" + service4.findByMemberId(memberId).getPortfolio();
		model.addAttribute("url", url);
	}
	
	
	
}
