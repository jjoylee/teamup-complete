package org.teamup.domain;

public class MemberVO {
	
	private Integer memberId;
	private String email;
	private String name;
	private String password;
	private String school;
	private String major;
	private String status;
	private String portfolio;
	private String photo;
	private int boardId;
	
	public Integer getMemberId() {return memberId;}
	public void setMemberId(Integer memberId) {this.memberId = memberId;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public String getSchool() {return school;}
	public void setSchool(String school) {this.school = school;}

	public String getMajor() {return major;}
	public void setMajor(String major) {this.major = major;}
	
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
	
	public String getPortfolio() {return portfolio;}
	public void setPortfolio(String portfolio) {this.portfolio = portfolio;}

	public String getPhoto() {return photo;}
	public void setPhoto(String photo) {this.photo = photo;}
    
	public Integer getBoardId() {return boardId;}
	public void setBoardId(Integer boardId) {this.boardId = boardId;}
}
