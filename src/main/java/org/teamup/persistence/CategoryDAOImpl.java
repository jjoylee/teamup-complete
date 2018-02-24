package org.teamup.persistence;
import javax.inject.*;

import org.apache.ibatis.session.*;
import org.springframework.stereotype.*;
import org.teamup.domain.BoardVO;
import org.teamup.domain.CategoryVO;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.teamup.mapper.CategoryMapper";

	@Override
	public void insertCategory(CategoryVO vo) throws Exception {
		session.insert(namespace + ".insertCategory", vo);
	}

	@Override
	public CategoryVO readCategory(Integer categoryId) throws Exception {
		return session.selectOne(namespace + ".readCategory", categoryId);
	}

	@Override
	public void updateCategory(CategoryVO vo) throws Exception {
		session.update(namespace + ".updateCategory", vo);
	}

	@Override
	public void deleteCategory(Integer categoryId) throws Exception {
		session.delete(namespace + ".deleteCategory", categoryId);
	}

	@Override
	public String getCategoryName(Integer categoryId) throws Exception {
		return session.selectOne(namespace + ".getCategoryName", categoryId) ;
	}
}
