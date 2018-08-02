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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.teamup.domain.BoardVO;
import org.teamup.domain.Criteria;
import org.teamup.domain.JsonResponse;
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
public class BoardController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private void setList(Model model, SearchCriteria cri, int categoryId) throws Exception{
		cri.setCategoryId(categoryId);
		model.addAttribute("list", boardService.listSearchCriteria(cri));		
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    pageMaker.setTotalCount(boardService.listSearchCount(cri));
	    model.addAttribute("pageMaker", pageMaker);	
	}

	@RequestMapping(value = "/itList", method = RequestMethod.GET)
	public void itList(Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		logger.info("itList - GET");
		setList(model, cri, 1);	 
	}
	
	@RequestMapping(value = "/marketingList", method = RequestMethod.GET)
	public void marketingList(Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
		logger.info("marketingList - GET");
		setList(model, cri, 2);	 
	}
	
	@RequestMapping(value = "/designList",method = RequestMethod.GET)
	public void	designList(Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
		logger.info("designList-GET.");
		setList(model, cri, 3);	 
	}
	
	@RequestMapping(value = "/etcList", method = RequestMethod.GET)
	public void etcList(Model model,  @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		logger.info("ectList-GET");
		setList(model, cri, 4);	    
	}
	
	@RequestMapping(value = "/readWrite", method = RequestMethod.GET)
	public void readWrite(Model model, @RequestParam int boardId, HttpSession session) throws Exception {
		logger.info("readWrite - GET");	
		model.addAttribute("sessionid", getUser(session).getMemberId());	
		model.addAttribute("board",boardService.read(boardId));
		PrtcMember pm = new PrtcMember();
		pm.setMemberId(getUser(session).getMemberId());
		pm.setBoardId(boardId);
		if(prtcMemberService.checkPrtcMember(pm) == null) model.addAttribute("msg", "success");
		else model.addAttribute("msg", "alreadyin");
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write(Model model) {
		logger.info("write - GET");		
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public @ResponseBody JsonResponse write(BoardVO vo, HttpSession session) throws Exception{
		logger.info("write - POST");
		res= new JsonResponse();
		try{
			vo.setMemberId(getUser(session).getMemberId());
			boardService.insert(vo);
			res.setResult("success");
			return res;
		}
		catch(Exception e){
			res.setResults("fail", e.getMessage());
			return res;
		}
	}
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public void test(Model model, HttpSession session)throws Exception { 
//		logger.info("Welcome write.");
//		
//		 if(session.getAttribute("member")==null)
//			 System.out.println("no session");
//		 else
//			 System.out.println("session");
//
//	}
	
	@RequestMapping(value = "/updateWrite", method = RequestMethod.GET)
	public void updateWrite(Model model, @RequestParam int boardId) throws Exception{
		logger.info("updateWrite - GET");
		model.addAttribute(boardService.read(boardId));
	}
	
	@RequestMapping(value = "/updateWrite", method = RequestMethod.POST)
	public @ResponseBody JsonResponse updateWrite(Model model, BoardVO vo) throws Exception{
		logger.info("updateWrite - POST");
		res = new JsonResponse();
		try{
			boardService.update(vo);
			res.setResult("success");
			return res;
		}catch(Exception e){
			res.setResults("fail", e.getMessage());
			return res;
		}
	}
	
	@RequestMapping(value = "/delete/{boardId}")
	public @ResponseBody JsonResponse delete(@PathVariable("boardId") int boardId) throws Exception{
		logger.info("delete - POST");
		res = new JsonResponse();
		try{
			prtcMemberService.deleteByBoardId(boardId);
			boardService.delete(boardId);
			res.setResult("success");
			return res;
		}catch(Exception e){
			res.setResults("fail", e.getMessage());
			return res;
		}
	}
	
	@RequestMapping(value = "/participate/{boardId}")
	public @ResponseBody JsonResponse participate(@PathVariable("boardId") int boardId, HttpSession session) throws Exception{
		logger.info("participate");
		res = new JsonResponse();
		try{
			PrtcMember pm = new PrtcMember();
			pm.setMemberId(getUser(session).getMemberId());
			pm.setBoardId(boardId);
			boardService.addCount(boardId);
			prtcMemberService.insertPrtcMember(pm);
			res.setResult("success");
			return res;
		}catch(Exception e){
			res.setResults("fail", e.getMessage());
			return res;
		}
	}
	
	@RequestMapping(value = "/participate_out/{boardId}")
	public @ResponseBody JsonResponse participate_out(@PathVariable("boardId") int boardId, HttpSession session) throws Exception{
		logger.info("participate_out - POST");
		try{
			res = new JsonResponse();
			PrtcMember pm = new PrtcMember();
			pm.setMemberId(getUser(session).getMemberId());
			pm.setBoardId(boardId);
			boardService.minusCount(boardId);
			prtcMemberService.deletePrtcMember(pm);			
			res.setResult("success");
			return res;
		}catch(Exception e){
			res.setResults("fail", e.getMessage());
			return res;
		}
	}
	
	@RequestMapping(value = "/myWriting", method = RequestMethod.GET)
	public void myWriting(Model model, HttpSession session) throws Exception {
		logger.info("myWriting - GET");
		model.addAttribute("list", boardService.findByMemId(getUser(session).getMemberId()));
	}
	
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public void memberList(Model model,@RequestParam("boardId") int boardId) throws Exception {
		logger.info("memberList - GET");
		model.addAttribute("list", boardService.memberList(boardId));
	}
	
	@RequestMapping(value = "/readMember", method = RequestMethod.GET)
	public void readMember(Model model, @RequestParam("memberId") int memberId) throws Exception {
		logger.info("readMember - GET");
		model.addAttribute("list",  prizeService.readPrize(memberId)); 
		model.addAttribute(memberService.findByMemberId(memberId));
		String url = "D:\\upload\\" + memberService.findByMemberId(memberId).getPortfolio();
		model.addAttribute("url", url);
	}

}
