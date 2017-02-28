package org.teamup.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.teamup.domain.MemberVO;

@Service
public interface MemberService {

	public String findMember(MemberVO member) throws Exception;
	
	public void join(MemberVO member) throws Exception;
	
	public MemberVO read(Integer userid) throws Exception; //¹¹¿¡¾²Áö?
	
	public void update(MemberVO member) throws Exception;
	
	public void delete(MemberVO member) throws Exception;
	
	public List<MemberVO> selectMember() throws Exception;
	
	public String findPasswd(MemberVO member) throws Exception;
	
	public void changePasswd(MemberVO member) throws Exception;
	
	public List<MemberVO> prizeList() throws Exception;
	
	public List<MemberVO> findByEmail(String email)throws Exception;
	
	public MemberVO login(MemberVO vo) throws Exception;
	
	public void fileUpload(MemberVO vo) throws Exception;
	
	public MemberVO findByMemberId(int memberId)throws Exception;
	
}
