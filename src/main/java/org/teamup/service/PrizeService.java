package org.teamup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.teamup.domain.PrizeVO;

@Service
public interface PrizeService {
	
	public void insertPrize(PrizeVO vo) throws Exception;
	
	public List<PrizeVO> readPrize(Integer MemberId) throws Exception;
	
	public void updatePrize(PrizeVO vo)throws Exception;
	
	public void deletePrize(Integer prizeId)throws Exception;
	
}
