package org.teamup.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.teamup.domain.JsonResponse;
import org.teamup.domain.MemberVO;
import org.teamup.service.MemberService;
import org.teamup.service.PrizeService;

@Controller
@RequestMapping("/account/*")
public class MemberController extends BaseController{
	
	  private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	  
	  //완료
	  @RequestMapping(value = "/modifyInfo", method = RequestMethod.GET)
	  public String modifyInfo(Model model, HttpSession session) throws Exception {
	    logger.info("modifyInfo - GET");
	    if(getUser(session) == null) return "redirect:/account/login";

	    MemberVO member = memberService.findByMemberId(getUser(session).getMemberId()); 
		model.addAttribute(member);
		model.addAttribute("list",  prizeService.readPrize(member.getMemberId()));   
		return "/account/modifyInfo";
	  }
	  
	  //완료
	  @RequestMapping(value = "/modifyInfo" , method= RequestMethod.POST)
	  public @ResponseBody JsonResponse modifyInfo(MemberVO vo, HttpSession session)throws Exception{
		  logger.info("modifyInfo - POST");
		  res = new JsonResponse();
		  try{
			  MemberVO member = getUser(session);
			  member.setMajor(vo.getMajor());
			  member.setSchool(vo.getSchool());
			  member.setName(vo.getName());
			  memberService.update(member);
			  res.setResult("success");
			  return res;
		  }catch(Exception e){
			  res.setResults("fail", e.getMessage());
			  return res;
		  }
	  }
	  
	  @RequestMapping(value = "/updatePasswd", method = RequestMethod.GET)
	  public void updatePasswd(Model model) throws Exception {
		  logger.info("updatePasswd - GET");  
	  }
	  
	  @RequestMapping(value = "/updatePasswd", method = RequestMethod.POST)
	  public @ResponseBody JsonResponse updatePasswd(@RequestParam("currentPwd") String currentPwd, @RequestParam("newPassword") String newPwd, HttpSession session) throws Exception 
	  {
		  logger.info("updatePasswd - POST");  
		  res = new JsonResponse();
		  try{
			  MemberVO member = memberService.findByEmail(getUser(session).getEmail());
			  if(currentPwd.equals(member.getPassword()))
		  	  {
		  		  member.setPassword(newPwd);
		  		  memberService.changePasswd(member);
		  		  session.setAttribute("member", member);
		  		  res.setResult("success");
		  		  return res;
		  	  }
		  	  res.setResults("fail", "비밀번호가 틀립니다.");
		  	  return res;
		  }catch(Exception e){
				res.setResults("fail", e.getMessage());
				return res;
		  }
	  }
	  
	  @RequestMapping(value = "/join", method = RequestMethod.GET)
	  public void join(MemberVO vo,Model model) throws Exception {
		  logger.info("join - GET");
	  }
	  
	  //완료
	  @RequestMapping(value = "/join", method = RequestMethod.POST)
	  public @ResponseBody JsonResponse join(MemberVO vo) throws Exception {
		  logger.info("join - POST");
		  res = new JsonResponse();
		  try{
			  if(!isMemberExist(vo.getEmail()))
			  {
				  res.setResult("success");
				  memberService.join(vo);
				  return res;
			  }
			  res.setResults("fail","이미 가입되어있는 이메일입니다.");
			  return res;
		  }catch(Exception e){
			  res.setResults("fail", e.getMessage());
			  return res;
		  }
	  }
	  
	  @RequestMapping(value = "/findPasswd", method = RequestMethod.GET)
	  public void findPasswd(Model model) throws Exception {
		  logger.info("findPasswd - GET");
	  }
	  
	  @RequestMapping(value = "/findPasswd", method = RequestMethod.POST)
	  public @ResponseBody JsonResponse findPasswd(MemberVO vo, RedirectAttributes rttr) throws Exception {
		  logger.info("findPasswd - POST");
		  res = new JsonResponse();
		  try{
			  if(isMemberExist(vo.getEmail())){
		  		  MemberVO member = memberService.findByEmail(vo.getEmail());
		  		  if(member.getStatus().equals("out"))
				  {
					  res.setResults("fail","탈퇴한 사용자입니다.");
					  return res;
			      }
		  		  res.setResults("success", member.getMemberId().toString());
		  		  return res;
		  	  }
			  res.setResults("fail", "존재하지 않는 사용자입니다.");
			  return res;
		  }catch(Exception e){
			  res.setResults("fail", e.getMessage());
			  return res;
		  }
	  }
	  
	  @RequestMapping(value = "/findPasswdResult", method = RequestMethod.GET)
	  public void findPasswdResult(Model model, @RequestParam("memberId") int memberId) throws Exception {
		  logger.info("findPasswdResult - GET");
		  model.addAttribute("member",memberService.findByMemberId(memberId));
	  }
	  
	  @RequestMapping(value ="/logout")
	  public String logout(Model model, HttpSession session) throws Exception{		 
		  logger.info("logout");
		  return logoutProcess(session);   
	  }
	  
	  @RequestMapping(value = "/login" , method = RequestMethod.GET)
	  public void login(Model model) throws Exception {
		  logger.info("login - GET");
		  System.out.println("hello");
	  }
		
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public  @ResponseBody JsonResponse login(MemberVO vo, HttpSession session) throws Exception {
		  logger.info("login - POST");
		  res = new JsonResponse();
		  try{
			  if(!isMemberExist(vo.getEmail())) {
				  res.setResults("fail", "등록된 사용자가 아닙니다.");
				  return res;
			  }
			  
			  MemberVO member = memberService.findByEmail(vo.getEmail()); 
			  if(member.getPassword().equals(vo.getPassword()))
			  {
				  if(member.getStatus().equals("out"))
				  {
					  res.setResults("fail","탈퇴한 사용자입니다.");
					  return res;
			      }
				  res.setResult("success");
				  session.setAttribute("member", member);
				  return res;
			  }
			  res.setResults("fail", "비밀번호가 맞지 않습니다."); 
			  return res;
		  }catch(Exception e){
			  res.setResults("fail", e.getMessage());
			  return res;
		  }
	  }
	  
	  @RequestMapping(value = "/withdraw")
	  public String withdraw(HttpSession session) throws Exception {
		  logger.info("withdraw");
		  MemberVO vo = getUser(session);
		  vo.setStatus("out");
	      memberService.update(vo);
	      return logoutProcess(session);   
	  }
	  
	  public boolean isMemberExist(String email) throws Exception{
		 return (memberService.findByEmail(email) != null);
	  }
	  
	  public String logoutProcess(HttpSession session){
		  session.removeAttribute("member");
		  session.invalidate();
		  return "redirect:/account/login";   
	  }
}
