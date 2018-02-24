package org.teamup.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.teamup.domain.PrizeVO;
import org.teamup.persistence.PrizeDAO;

@Service("PrizeService")
public class PrizeServiceImpl implements PrizeService {
	@Inject
	private PrizeDAO dao;
	
	@Override
	public void insertPrize(PrizeVO vo) throws Exception {
		dao.insertPrize(vo);	
	}

	@Override
	public List<PrizeVO> readPrize(Integer MemberId) throws Exception {  
		return dao.readPrize(MemberId);
	}

	@Override
	public void updatePrize(PrizeVO vo) throws Exception {
		dao.updatePrize(vo);
	}

	@Override
	public void deletePrize(Integer prizeId) throws Exception {
		dao.deletePrize(prizeId);
	}
}
