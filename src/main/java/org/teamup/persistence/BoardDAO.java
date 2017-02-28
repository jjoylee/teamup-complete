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
	public void curCount(Integer boardId) throws Exception;
	public void curCount2(Integer boardId) throws Exception;
	public List<BoardVO> findByMemId(Integer memberId) throws Exception;
    public List<MemberVO> memberList(Integer boardId) throws Exception;
    public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
    public int listSearchCount(SearchCriteria cri) throws Exception;
}
