package org.teamup.test;
import javax.inject.*;

import org.teamup.domain.*;
import org.teamup.persistence.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class PrtcMemberDAOTest {
	@Inject
	private PrtcMemberDAO dao;
	
	@Test
	public void testInsertPrtcMember()throws Exception{
		PrtcMember pm = new PrtcMember();
		pm.setBoardId(1);
		pm.setMemberId(1);
		dao.insertPrtcMember(pm);
	}
	
//	@Test
//	public void testUpdatePrtcMember()throws Exception{
//		PrtcMember pm = new PrtcMember();
//		pm.setPrtcMemberId(1);
//		pm.setBoardId(2);
//		pm.setMemberId(2);
//		dao.updatePrtcMember(pm);
//	}
	
//	@Test
//	public void testDeletePrtcMember()throws Exception{
//		dao.deletePrtcMember(1);
//	}
}
