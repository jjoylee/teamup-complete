package org.teamup.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.activation.CommandMap;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.teamup.domain.MemberVO;
import org.teamup.service.MemberService;

@Controller
@RequestMapping("/account/*")
public class DownloadController extends BaseController{
	
	@RequestMapping(value="/download")
	public void downloadFile(HttpServletResponse response,@RequestParam("memberId") int memberId) throws Exception{
		MemberVO vo = memberService.findByMemberId(memberId);
		byte fileByte[] = FileUtils.readFileToByteArray(new File("E:\\upload\\"+ vo.getPortfolio()));
	    
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(vo.getPortfolio(),"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
}
