package org.teamup.domain;

public class Criteria {

  private int page;
  private int perPageNum;
  private int categoryId;

  public Criteria() {
    this.page = 1;
    this.perPageNum = 10;
    this.categoryId = 1;
  }
  public void setPage(int page) {

    if (page <= 0) {
      this.page = 1;
      return;
    }

    this.page = page;
  }

  public void setPerPageNum(int perPageNum) {

    if (perPageNum <= 0 || perPageNum > 100) {
      this.perPageNum = 10;
      return;
    }

    this.perPageNum = perPageNum;
  }

  public int getPage() {
    return page;
  }

  // method for MyBatis SQL Mapper -
  public int getPageStart() {

    int pageStart = (this.page -1) * perPageNum;
    return pageStart;
  }

  // method for MyBatis SQL Mapper
  public int getPerPageNum() {

    return this.perPageNum;
  }
  
  public int getCategoryId(){
	  return categoryId;
  }
  
  public void setCategoryId(int categoryId){
	  this.categoryId = categoryId;
  }

  @Override
  public String toString() {
    return "Criteria [page=" + page + ", "
        + "perPageNum=" + perPageNum + "]";
  }
}
