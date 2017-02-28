package org.teamup.persistence;

import java.util.*;

import org.teamup.domain.BoardVO;
import org.teamup.domain.Criteria;
import org.teamup.domain.MemberVO;
import org.teamup.domain.PrtcMember;
import org.teamup.domain.SearchCriteria;

import javax.inject.*;
import org.apache.ibatis.session.*;
import org.springframework.stereotype.*;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.teamup.mapper.BoardMapper";
	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		session.insert(namespace + ".insertBoard", vo); 
	}

	@Override
	public BoardVO readBoard(Integer boardId) throws Exception {
		return session.selectOne(namespace + ".readBoard", boardId);
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		session.update(namespace + ".updateBoard", vo);
	}

	@Override
	public void deleteBoard(Integer boardId) throws Exception {
		session.delete(namespace + ".deleteBoard", boardId);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if(page <= 0)
		{
			page = 1;
		}
		
		page = (page - 1) * 10;
		return session.selectList(namespace+".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace+".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<BoardVO> listCategory(Integer categoryId) throws Exception {
		
		return session.selectList(namespace+ ".listCategory", categoryId);
	}

	@Override
	public void curCount(Integer boardId) throws Exception {
		session.update(namespace+ ".participate" , boardId);
		
	}
	
	@Override
	public void curCount2(Integer boardId) throws Exception {
		session.update(namespace+ ".participate_out" , boardId);
		
	}

	@Override
	public List<BoardVO> findByMemId(Integer memberId) throws Exception {
		return session.selectList(namespace + ".findByMemId", memberId);
		
	}

	@Override
	public List<MemberVO> memberList(Integer boardId) throws Exception {
		
		return session.selectList(namespace+ ".memberList", boardId);
	}
	
	
	 @Override
	  public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {

	    return session.selectList(namespace + ".listSearch", cri);
	  }
	 
	 

	 @Override
	  public int listSearchCount(SearchCriteria cri) throws Exception {

	    return session.selectOne(namespace + ".listSearchCount", cri);
	  }
	 
}
