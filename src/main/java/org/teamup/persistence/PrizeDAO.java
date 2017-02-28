package org.teamup.persistence;
import java.util.List;

import org.teamup.domain.*;

public interface PrizeDAO {
	public void insertPrize(PrizeVO vo)throws Exception;
	public List<PrizeVO> readPrize(Integer MemberId) throws Exception;
	public void updatePrize(PrizeVO vo)throws Exception;
	public void deletePrize(Integer prizeId)throws Exception;
}
