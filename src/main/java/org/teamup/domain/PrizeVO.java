package org.teamup.domain;

public class PrizeVO {
	private int prizeId;
	private int memberId;
	private String title;
	private String year;
	
	public int getPrizeId()
	{
		return prizeId;
	}
	public void setPrizeId(int prizeId)
	{
		this.prizeId = prizeId;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public int getMemberId()
	{
		return memberId;
	}
	public void setMemberId(int memberId)
	{
		this.memberId = memberId;
	}
	public String getyear()
	{
		return year;
	}
	public void setyear(String year)
	{
		this.year = year;
	}
}
