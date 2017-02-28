package org.teamup.persistence;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.teamup.domain.MemberVO;


public interface MemberDAO {

	public String findMember(MemberVO vo);
	

	public void insertMember(MemberVO vo);
	
	public void updateMember(MemberVO vo);
	
	public void updatePrizeList(MemberVO vo); 
	
	public void changePasswd(MemberVO vo);
	
	public void deleteMember(MemberVO vo);
	
	public String findPasswd(MemberVO vo);
	
	public List<MemberVO> memberList() throws Exception;
	
	public List<MemberVO> prizeList() throws Exception;
	
	public List<MemberVO> findByEmail(String email)throws Exception;
	
	public MemberVO findByMemberId(int memberId)throws Exception;
	
	public MemberVO login(MemberVO vo) throws Exception;
	
	public void fileUpload(MemberVO vo) throws Exception;
	
}
