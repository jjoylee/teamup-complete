package org.teamup.test;
import java.util.List;

import javax.inject.*;

import org.teamup.domain.*;
import org.teamup.persistence.*;
import org.teamup.service.PrizeService;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class PrizeDAOTest {
	@Inject
	private PrizeDAO dao;
	
	
	@Test
	public void testReadPrize() throws Exception{
		
		dao.readPrize(1);
		
	}
	
	
//	@Test
//	public void testInsertPrize()throws Exception{
//		PrizeVO vo = new PrizeVO();
//		vo.setMemberId(1);
//		vo.setTitle("경진대회");
//		vo.setComment("소프트웨어1등");
//		dao.insertPrize(vo);
//	}
//	
//	@Test
//	public void testUpdatePrize()throws Exception{
//		PrizeVO vo = new PrizeVO();
//		vo.setPrizeId(2);
//		vo.setMemberId(1);
//		vo.setTitle("경진대회");
//		vo.setComment("금상");
//		dao.updatePrize(vo);
//	}
//	
//	@Test
//	public void testDeletePrize()throws Exception{
//		dao.deletePrize(2);
//	}
}
