package org.teamup.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.teamup.domain.MemberVO;
import org.teamup.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public String findMember(MemberVO member) throws Exception {
				
		if(dao.findMember(member) == "none")
			return "none";
		else if(dao.findMember(member) == "failed")
			return "failed";
		else
			return "success";
	}
	
	@Override
	public void join(MemberVO member) throws Exception {
		dao.insertMember(member);
	}

	@Override
	public MemberVO read(Integer memberId) throws Exception {
		
		return null;
	}

	@Override
	public void update(MemberVO member) throws Exception {
		dao.updateMember(member);
	}

	@Override
	public void delete(MemberVO member) throws Exception {
		dao.deleteMember(member);
	}

	@Override
	public List<MemberVO> selectMember() throws Exception {
		// TODO Auto-generated method stub
		return dao.memberList();
	}

	@Override
	public String findPasswd(MemberVO member) throws Exception {
		
		return dao.findPasswd(member);
	}

	@Override
	public void changePasswd(MemberVO member) throws Exception {
		dao.changePasswd(member);
		
	}

	@Override
	public List<MemberVO> prizeList() throws Exception {
		
		return dao.prizeList();
	}

	
	@Override
	public List<MemberVO> findByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		// TODO Auto-generated method stubs
		return dao.login(vo);
	}

	@Override
	public void fileUpload(MemberVO vo) throws Exception {
		dao.fileUpload(vo);		
	}

	@Override
	public MemberVO findByMemberId(int memberId) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByMemberId(memberId);
	}
}
