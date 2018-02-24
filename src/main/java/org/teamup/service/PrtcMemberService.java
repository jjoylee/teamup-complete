package org.teamup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.teamup.domain.BoardVO;
import org.teamup.domain.PrtcMember;

@Service
public interface PrtcMemberService {

	public void insertPrtcMember(PrtcMember pm)throws Exception;
	public  List<BoardVO> readPrtcMember(Integer memberId)throws Exception;
	public void updatePrtcMember(PrtcMember pm)throws Exception;
	public void deletePrtcMember(PrtcMember pm)throws Exception;
	public PrtcMember checkPrtcMember(PrtcMember pm)throws Exception;
	public void deleteByBoardId(Integer boardId) throws Exception;
}
