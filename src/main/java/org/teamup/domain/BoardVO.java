package org.teamup.domain;

import java.util.Date;

public class BoardVO {
	private int boardId;
	private int categoryId;
	private String title;
	private String content;
	private int memberId;
	private String url;
	private int memCount;
	private int curCount;
	private Date date;
	private String dueDate;
	private String name;
	
	
	public void setName(String name){this.name = name;}
	public String getName(){return name;}
	
	public void setBoardId(int boardId)
	{
		this.boardId = boardId;
	}
	
	public int getBoardId()
	{
		return boardId;
	}
	
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}
	public int getCategoryId()
	{
		return categoryId;
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}

	public int getMemberId()
	{
		return memberId;
	}
	public void setMemberId(int memberId)
	{
		this.memberId = memberId;
	}
	
	public String getUrl()	
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	public int getMemCount()
	{
		return memCount;
	}
	public void setMemCount(int count)
	{
		this.memCount = count;
	}
	
	public int getcurCount()
	{
		return curCount;
	}
	public void setcurCount(int curCount)
	{
		this.curCount = curCount;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{   
		
		this.date = date;
	}
	
	public String getdueDate()
	{
		return dueDate;
	}
	public void setdueDate(String dueDate)
	{
		this.dueDate = dueDate;
	}
	
	
}
