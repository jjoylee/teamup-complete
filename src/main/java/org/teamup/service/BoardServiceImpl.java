package org.teamup.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.teamup.domain.BoardVO;
import org.teamup.domain.Criteria;
import org.teamup.domain.MemberVO;
import org.teamup.domain.SearchCriteria;
import org.teamup.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	private BoardDAO dao;
	
	@Override
	public void insert(BoardVO vo) throws Exception {
		dao.insertBoard(vo);	
	}

	@Override
	public BoardVO read(Integer boardId) throws Exception {
		return dao.readBoard(boardId);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		dao.updateBoard(vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		dao.deleteBoard(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		return dao.listPage(page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
	   return dao.countPaging(cri);
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<BoardVO> listCategory(Integer categoryId) throws Exception {	
		return dao.listCategory(categoryId);
	}
	
	@Override
	public void addCount(Integer boardId) throws Exception {
		dao.addCount(boardId);
	}
	
	@Override
	public void minusCount(Integer boardId) throws Exception {
		dao.minusCount(boardId);
	}

	@Override
	public List<BoardVO> findByMemId(Integer memberId) throws Exception {
		return dao.findByMemberId(memberId);
	}

	@Override
	public List<MemberVO> memberList(Integer boardId) throws Exception {
		return dao.memberList(boardId);
	}
	
	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
	    return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
	    return dao.listSearchCount(cri);
	}
}

	