package org.teamup.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.teamup.domain.BoardVO;
import org.teamup.domain.PrtcMember;
import org.teamup.persistence.PrtcMemberDAO;

@Service
public class PrtcMemberServiceImpl implements PrtcMemberService {

	@Inject
	private PrtcMemberDAO dao;
	
	@Override
	public void insertPrtcMember(PrtcMember pm) throws Exception {
		dao.insertPrtcMember(pm);
		
	}

	@Override
	public List<BoardVO> readPrtcMember(Integer memberId) throws Exception {
		// TODO Auto-generated method stub
		return dao.readPrtcMember(memberId);
	}

	@Override
	public void updatePrtcMember(PrtcMember pm) throws Exception {
		dao.updatePrtcMember(pm);
	}

	@Override
	public void deletePrtcMember(PrtcMember pm) throws Exception {
		dao.deletePrtcMember(pm);
		
	}

	@Override
	public PrtcMember check(PrtcMember pm) throws Exception {
		// TODO Auto-generated method stub
		return dao.check(pm);
	}

	@Override
	public void deleteByBoardId(Integer boardId) throws Exception {
		dao.deleteByBoardId(boardId);
		
	}
	
	
}
