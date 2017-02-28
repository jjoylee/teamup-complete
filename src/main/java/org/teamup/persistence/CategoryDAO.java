package org.teamup.persistence;

import org.teamup.domain.*;

public interface CategoryDAO {
	public void insertCategory(CategoryVO vo)throws Exception;
	public CategoryVO readCategory(Integer categoryId)throws Exception;
	public void updateCategory(CategoryVO vo)throws Exception;
	public void deleteCategory(Integer categoryId)throws Exception;
	public String getCategoryName(Integer categoryId)throws Exception;
}
