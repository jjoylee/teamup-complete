package org.teamup.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.teamup.domain.CategoryVO;
import org.teamup.persistence.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Inject
	private CategoryDAO dao;
	@Override
	public void insertCategory(CategoryVO vo) throws Exception {
		dao.insertCategory(vo);
	}

	@Override
	public CategoryVO readCategory(Integer categoryId) throws Exception {
		return dao.readCategory(categoryId);
	}

	@Override
	public void updateCategory(CategoryVO vo) throws Exception {
		dao.updateCategory(vo);
	}

	@Override
	public void deleteCategory(Integer categoryId) throws Exception {
		dao.deleteCategory(categoryId);
	}

	@Override
	public String getCategoryName(Integer categoryId) throws Exception {
		return dao.getCategoryName(categoryId);
	}
}
