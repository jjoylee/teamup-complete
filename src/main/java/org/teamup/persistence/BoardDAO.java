package org.teamup.persistence;
import java.util.List;

import org.teamup.domain.*;

public interface BoardDAO {
	public void insertBoard(BoardVO vo)throws Exception;
	public BoardVO readBoard(Integer boardId)throws Exception;
	public void updateBoard(BoardVO vo)throws Exception;
	public void deleteBoard(Integer boardId)throws Exception;
	public List<BoardVO> listAll()throws Exception;
	public List<BoardVO> listPage(int page)throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	public int countPaging(Criteria cri)throws Exception;
	public List<BoardVO> listCategory(Integer categoryId) throws Exception;
	public void addCount(Integer boardId) throws Exception;
	public void minusCount(Integer boardId) throws Exception;
	public List<BoardVO> findByMemberId(Integer memberId) throws Exception;
    public List<MemberVO> memberList(Integer boardId) throws Exception;
    public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
    public int listSearchCount(SearchCriteria cri) throws Exception;
}
