package org.teamup.test;

import java.util.Date;

import javax.inject.Inject;

import org.teamup.domain.BoardVO;
import org.teamup.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {

	@Inject
	private BoardDAO dao;
	
	
	
	@Test
	public void testInsertMember()throws Exception{
		
		BoardVO vo = new BoardVO();
		
		
		vo.setTitle("¸ðÁý");
		vo.setContent("hi");
		vo.setMemCount(4);
		vo.setMemberId(1);
		vo.setUrl("http://naver.com");
		vo.setMemCount(3);
		vo.setdueDate("2016-04-19");


		
		
		dao.insertBoard(vo);
		
	}	

}


