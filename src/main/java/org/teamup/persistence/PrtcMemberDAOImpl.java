package org.teamup.persistence;
import java.util.List;

import javax.inject.*;

import org.apache.ibatis.session.*;
import org.springframework.stereotype.*;
import org.teamup.domain.BoardVO;
import org.teamup.domain.PrtcMember;

@Repository
public class PrtcMemberDAOImpl implements PrtcMemberDAO{
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.teamup.mapper.PrtcMemberMapper";

	@Override
	public void insertPrtcMember(PrtcMember pm) throws Exception {
		session.insert(namespace + ".insertPrtcMember", pm); 
	}

	@Override
	public  List<BoardVO> readPrtcMember(Integer memberId) throws Exception {
		return session.selectList(namespace + ".readPrtcMember", memberId);
	}

	@Override
	public void updatePrtcMember(PrtcMember pm) throws Exception {
		session.update(namespace + ".updatePrtcMember", pm); 
	}

	@Override
	public void deletePrtcMember(PrtcMember pm) throws Exception {
		session.delete(namespace + ".deletePrtcMember", pm); 
	}

	@Override
	public PrtcMember check(PrtcMember pm) throws Exception {
		return session.selectOne(namespace + ".check", pm);
	}
	
	@Override
	public void deleteByBoardId(Integer boardId) throws Exception{
		session.delete(namespace+".deleteByBoardId", boardId);
	}

}
