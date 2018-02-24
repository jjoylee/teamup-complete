package org.teamup.persistence;
import java.util.List;

import org.teamup.domain.*;
public interface PrtcMemberDAO {
	public void insertPrtcMember(PrtcMember pm)throws Exception;
	public List<BoardVO> readPrtcMember(Integer memberId)throws Exception;
	public void updatePrtcMember(PrtcMember pm)throws Exception;
	public void deletePrtcMember(PrtcMember pm)throws Exception;
	public PrtcMember checkPrtcMember(PrtcMember pm)throws Exception;
	public void deleteByBoardId(Integer boardId) throws Exception;

}
