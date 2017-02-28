package org.teamup.controller;

import java.util.List;

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
import org.teamup.service.MemberService;
import org.teamup.service.PrizeService;

@Controller
@RequestMapping("/account/*")
public class MemberController {
	
	  private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	  private MemberService service;
		
	@Inject
	  private PrizeService service2;
	
	
	

	  @RequestMapping(value = "/modifyInfo", method = RequestMethod.GET)
	  public String modifyInfo(Model model, HttpSession session) throws Exception {

	    logger.info("show all list......................");
	    
	   
	    
	    if(session.getAttribute("member") == null){
	    	return "redirect:/account/login";
	    }else{
	    
    	MemberVO vo = new MemberVO();
 	    vo = service.findByMemberId(((MemberVO)session.getAttribute("member")).getMemberId()); 
 	    Integer MemId = vo.getMemberId(); 	 
	  	model.addAttribute(vo);
	    model.addAttribute("list",  service2.readPrize(MemId));   
	    return "/account/modifyInfo";
	    }
	   
	  }
	  
	  @RequestMapping(value = "/modifyInfo" , method= RequestMethod.POST)
	  public String modifyInfoPOST(@RequestParam("name")String name,@RequestParam("school")String school,
			  @RequestParam("major")String major, HttpSession session)throws Exception{
		  
		  
		  MemberVO vo = (MemberVO)(session.getAttribute("member"));
		  
		
		  vo.setMajor(major);
		  vo.setSchool(school);
		  vo.setName(name);
		  System.out.println(major + name + school);
		  service.update(vo);
		  return "redirect:/account/modifyInfo";
		  
	  }
	  
	  
	  
	  @RequestMapping(value = "/updatePasswd", method = RequestMethod.GET)
	  public void updatePasswd(Model model) throws Exception {

	    logger.info("show all list......................");
	   
	  }
	  
	  @RequestMapping(value = "/updatePasswd", method = RequestMethod.POST)
	  public String updatePasswdPost( Model model,@RequestParam("currentPwd") String currentPwd, @RequestParam("newPassword") String newPasswd,@RequestParam("newPasswordChk") String newPasswdChk, RedirectAttributes rttr, HttpSession session) throws Exception 
	  {	
	  	MemberVO vo1 = service.findByEmail(((MemberVO)session.getAttribute("member")).getEmail()).get(0);
	  	if(currentPwd.equals(vo1.getPassword()))
	  	{
	  		if(newPasswd.equals(newPasswdChk))
	  		{
	  			vo1.setPassword(newPasswd);
	  			service.update(vo1);
	  			rttr.addFlashAttribute("msg", "true");
	  			return "redirect:/account/modifyInfo";
	  		}else
	  		{
	  			rttr.addFlashAttribute("msg","different");
	  			return "redirect:/account/updatePasswd";
	  		}
	  	
	  	}
	  	else{
	  		rttr.addFlashAttribute("msg","false");
	  		return "redirect:/account/updatePasswd";
	  	}
	  }
	  
	 
	  @RequestMapping(value = "/join", method = RequestMethod.GET)
	  public void join(MemberVO vo,Model model) throws Exception {

	    
	    logger.info("show all list......................");
	   
	  }

	  @RequestMapping(value = "/join", method = RequestMethod.POST)
	  public String joinPost(MemberVO vo, RedirectAttributes rttr, 
	  		@RequestParam("password") String password, @RequestParam("passwordChk") String passwordChk) throws Exception {

	  		
	  		List<MemberVO> mList = service.findByEmail(vo.getEmail());
	  		if(mList.isEmpty())
	  		{
	  			if(!password.equals(passwordChk))
	  			{
	  				rttr.addFlashAttribute("msg", "different");
	  				return "redirect:/account/join";
	  			}
	  			rttr.addFlashAttribute("msg","success");
	  			service.join(vo);
	  			return "redirect:/account/login"; 
	  		}
	  		else
	  		{
	  			rttr.addFlashAttribute("msg", "failed");
	  			return "redirect:/account/join";
	  		}
	  		
	  }
	  
	  @RequestMapping(value = "/findPasswd", method = RequestMethod.GET)
	  public void findPasswd(Model model) throws Exception {

	    logger.info("show all list......................");
	   
	  }
	  
	  @RequestMapping(value = "/findPasswd", method = RequestMethod.POST)
	  public String findPasswdPOST(MemberVO vo, RedirectAttributes rttr) throws Exception {
	  	List<MemberVO> mList = service.findByEmail(vo.getEmail());
	  	if(!service.findByEmail(vo.getEmail()).isEmpty()){
	  		String pwd = mList.get(0).getPassword();
	  		String name = mList.get(0).getName();
	  		rttr.addFlashAttribute("pwd", pwd);
	  		rttr.addFlashAttribute("name", name);
	  		return "redirect:/account/findPasswdResult";
	  	}
	  	else
	  	{
	  		rttr.addFlashAttribute("msg2","none");
	  		return "redirect:/account/findPasswdResult";
	  	}
	  }
	  
	  @RequestMapping(value = "/findPasswdResult", method = RequestMethod.GET)
	  public void findPasswdResult(Model model) throws Exception {

	    logger.info("show all list......................");
	   
	  }
	  
	  @RequestMapping(value ="/logout")
	  public String logout(Model model, HttpSession session) throws Exception{		 
		
		session.removeAttribute("member");
		session.invalidate();
		return "redirect:/account/login";
		    
	  }
	  
	  @RequestMapping(value = "/login" , method = RequestMethod.GET)
		public void login( Model model) throws Exception {
		
		  logger.info("show all list......................");
		  
		}
		
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public String loginPOST(RedirectAttributes rttr,@RequestParam("password") String password, MemberVO vo, HttpSession session) throws Exception {
		  		 
		  String email=vo.getEmail();
		  List<MemberVO> list = service.findByEmail(email);
		  
		  if(list.isEmpty())
		  {
			  rttr.addFlashAttribute("msg", "none");
			  return "redirect:/account/login";
		  }
		  else
		  {
			  MemberVO vo1 = list.get(0); 
			  if(vo1.getPassword().equals(password))
			  {
				  if(vo1.getStatus().equals("out"))
		          {
		        		rttr.addFlashAttribute("msg", "alreadyout");
		        		return "redirect:/account/login";
		          }
				  session.setAttribute("member", vo1);
				  return "redirect:/board/itList";
			  }
			  else
			  {
				  rttr.addFlashAttribute("msg", "failed"); 
				  return "redirect:/account/login";
			  }
		  }
	  }
	  
	  @RequestMapping(value = "/withdraw")
	  public String Withdraw(RedirectAttributes rttr, HttpSession session) throws Exception {
	  	logger.info("regist post ...........");
	  	MemberVO vo = (MemberVO)session.getAttribute("member");
	  	vo.setStatus("out");
	  	service.update(vo);
	  	rttr.addFlashAttribute("msg", "out");
	  	return "redirect:/account/login";
	  }
		  
}
