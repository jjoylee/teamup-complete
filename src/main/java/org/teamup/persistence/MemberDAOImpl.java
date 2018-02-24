package org.teamup.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.teamup.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace ="org.teamup.mapper.MemberMapper";

	@Override
	public String findMember(MemberVO vo){				
		if(sqlSession.selectOne(namespace+".getEmail", vo) == null) //먼저 이메일을 확인한다. 없으면 등록되지않은 사용자.
			return "none";
		else if(sqlSession.selectOne(namespace+".getPasswd", vo) == null)//이메일이 맞다면 비밀번호와 일치하는지 확인한다. 
		   return "failed";
		else
			return "success";
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace + ".insertMember", vo);	
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update(namespace + ".updateMember" , vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		sqlSession.delete(namespace + ".deleteMember", vo);
	}

	@Override
	public String findPasswdByEmail(MemberVO vo) {
		return sqlSession.selectOne(namespace+".findPasswd");
	}

	@Override
	public void changePasswd(MemberVO vo) {
		sqlSession.update(namespace + ".changePasswd", vo);
	}

	@Override
	public List<MemberVO> memberList() throws Exception {
		 return sqlSession.selectList(namespace + ".memberList");
	}

	@Override
	public void updatePrizeList(MemberVO vo) {
		sqlSession.update(namespace + ".updatePrize", vo);
	}

	@Override
	public List<MemberVO> prizeList() throws Exception {
		return sqlSession.selectList(namespace + ".selectPrize");
	}

	@Override
	public MemberVO findByEmail(String email) throws Exception {
		return sqlSession.selectOne(namespace+".findByEmail", email);
	}

	@Override
	public void fileUpload(MemberVO vo) throws Exception {
		sqlSession.update(namespace +".fileUpload", vo);
	}

	@Override
	public MemberVO findByMemberId(int memberId) throws Exception {
		return sqlSession.selectOne(namespace +".findByMemberId", memberId);
	}
}
