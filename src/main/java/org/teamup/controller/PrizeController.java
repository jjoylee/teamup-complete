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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.teamup.domain.JsonResponse;
import org.teamup.domain.MemberVO;
import org.teamup.domain.PrizeVO;
import org.teamup.service.PrizeService;

@Controller
@RequestMapping("/account/*")
public class PrizeController extends BaseController{
	
	  private static final Logger logger = LoggerFactory.getLogger(PrizeController.class);
	
	  @RequestMapping(value = "/prizeList", method = RequestMethod.GET)
	  public void prizeList(Model model, HttpSession session) throws Exception {
		  logger.info("prizeList - GET");
		  model.addAttribute("list",  prizeService.readPrize(getUser(session).getMemberId()));   
	  }

	  @RequestMapping(value="/prizeList" , method  = RequestMethod.POST)
	  public @ResponseBody JsonResponse prizeList(PrizeVO vo, HttpSession session) throws Exception{
		  logger.info("prizeList - POST");
		  res = new JsonResponse();
		  try{
			  vo.setMemberId(getUser(session).getMemberId());
			  prizeService.insertPrize(vo);
			  res.setResult("success");
			  return res;
		  }catch(Exception e){
			  res.setResults("fail", e.getMessage());
			  return res;
		  }
	  }
	  
	  @RequestMapping(value="/removePrize/{prizeId}")
	  public @ResponseBody JsonResponse removePrize(@PathVariable("prizeId") Integer prizeId) throws Exception{
		  logger.info("removePrize - POST");
		  res = new JsonResponse();
		  try{
			  prizeService.deletePrize(prizeId);
			  res.setResult("success");
			  return res;
		  }catch(Exception e){
			  res.setResults("fail", e.getMessage());
			  return res;
		  }
	  }	 
}
