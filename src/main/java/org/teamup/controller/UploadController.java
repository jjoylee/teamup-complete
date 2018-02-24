package org.teamup.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.teamup.domain.MemberVO;
import org.teamup.service.MemberService;
import org.teamup.service.PrtcMemberService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/account/*")
public class UploadController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value = "/uploadForm" , method = RequestMethod.GET)
	public void uploadForm(HttpSession session){
		logger.info("uploadForm - GET");
		String[] file = getUser(session).getPortfolio().split("_");
		System.out.println(file[file.length-1]);
	}
	
	@RequestMapping(value = "/uploadForm" , method = RequestMethod.POST)
	public String uploadForm(MultipartFile file, Model model, HttpSession session) throws Exception{
		logger.info("uploadForm - POST");
		if(getUser(session).getPortfolio() != null){
			File uploaded = new File("E:\\upload\\" + getUser(session).getPortfolio());
			uploaded.delete();
		}
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		MemberVO vo = new MemberVO();
		vo.setPortfolio(savedName);
		vo.setMemberId(getUser(session).getMemberId());
		memberService.fileUpload(vo);
		model.addAttribute("savedName", savedName);
		return "/account/uploadResult";
	}
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	private String uploadFile(String originalName, byte[] fileData ) throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_"+originalName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
}
