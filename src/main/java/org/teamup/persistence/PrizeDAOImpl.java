package org.teamup.persistence;
import java.util.List;

import javax.inject.*;

import org.apache.ibatis.session.*;
import org.springframework.stereotype.*;
import org.teamup.domain.BoardVO;
import org.teamup.domain.PrizeVO;

@Repository
public class PrizeDAOImpl implements PrizeDAO{
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.teamup.mapper.PrizeMapper";

	@Override
	public void insertPrize(PrizeVO vo) throws Exception {
		session.insert(namespace + ".insertPrize", vo); 
	}

	@Override
	public List<PrizeVO> readPrize(Integer memberId) throws Exception {
		return session.selectList(namespace + ".readPrize", memberId);
	}

	@Override
	public void updatePrize(PrizeVO vo) throws Exception {
		session.update(namespace + ".updatePrize", vo); 
	}

	@Override
	public void deletePrize(Integer prizeId) throws Exception {
		session.delete(namespace + ".deletePrize", prizeId); 
	}
}
