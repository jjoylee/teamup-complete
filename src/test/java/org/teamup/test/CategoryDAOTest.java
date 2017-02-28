package org.teamup.test;
import java.util.List;

import javax.inject.*;

import org.teamup.domain.*;
import org.teamup.persistence.*;
import org.junit.*;
import org.junit.runner.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class CategoryDAOTest {
	@Inject
	private CategoryDAO dao;
	
	@Inject
	private BoardDAO dao2;
//	@Test
//	public void testInsertCategory()throws Exception{
//		CategoryVO vo = new CategoryVO();
//		vo.setCategoryName("디자인");
//		dao.insertCategory(vo);
//	}
	
//	@Test
//	public void testUpdateCategory()throws Exception{
//		CategoryVO vo = new CategoryVO();
//		vo.setCategoryId(2);
//		vo.setCategoryName("마케팅");
//		dao.updateCategory(vo);
//	}
	
//	@Test
//	public void testDeleteCategory()throws Exception{
//		
//		dao.deleteCategory(1);
//	}
//	
	
	private static Logger logger = LoggerFactory.getLogger(CategoryDAOTest.class);
	
	 @Test
	  public void testListCriteria() throws Exception {

	    Criteria cri = new Criteria();
	    cri.setPage(1);
	    cri.setPerPageNum(11);

	    List<BoardVO> list = dao2.listCriteria(cri);

	    for (BoardVO boardVO : list) {
	      logger.info(boardVO.getBoardId() + ":" + boardVO.getTitle());
	    }
	  }
}
