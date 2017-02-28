package org.teamup.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.teamup.domain.MemberVO;
import org.teamup.domain.PrizeVO;
import org.teamup.service.PrizeService;

@Controller
@RequestMapping("/account/*")
public class PrizeController {
	
	  private static final Logger logger = LoggerFactory.getLogger(PrizeController.class);

	
	@Inject
	  private PrizeService service;
	
	
	
	
	
	  
	  @RequestMapping(value = "/prizeList", method = RequestMethod.GET)
	  public void prizeList(Model model, HttpSession session) throws Exception {

	    logger.info("show all prize list......................");
	    MemberVO vo = new MemberVO();
	    vo = (MemberVO)session.getAttribute("member"); 
	    Integer MemId = vo.getMemberId(); 	    
	    System.out.println(MemId);
	    
	   
	  	   
	    model.addAttribute("list",  service.readPrize(MemId));   
	    
	  }


	  @RequestMapping(value="/prizeList" , method  = RequestMethod.POST)
	  public String updatePrize(PrizeVO vo, Model model, HttpSession session, HttpServletRequest request) throws Exception{
		  logger.info("update prize list.....................");
		  vo.setMemberId(((MemberVO)session.getAttribute("member")).getMemberId());
		  service.insertPrize(vo);
		  return "redirect:/account/prizeList";
	  }
	  
	  @RequestMapping(value="/removePrize" , method = RequestMethod.POST)
	  public String removePrize(@RequestParam("prizeId") Integer prizeId) throws Exception{
		  System.out.println(prizeId);
		  service.deletePrize(prizeId);
		  return "redirect:/account/prizeList";
	  }
	  
	 
}
