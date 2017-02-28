package org.teamup.service;

import org.teamup.domain.CategoryVO;

public interface CategoryService {
	public void insertCategory(CategoryVO vo)throws Exception;
	public CategoryVO readCategory(Integer categoryId)throws Exception;
	public void updateCategory(CategoryVO vo)throws Exception;
	public void deleteCategory(Integer categoryId)throws Exception;
	public String getCategoryName(Integer categoryId)throws Exception;
}
