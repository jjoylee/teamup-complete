package org.teamup.domain;

public class PrtcMember {
	private int prtcMemberId;
	private int memberId;
	private int boardId;
	
	public int getPrtcMemberId(){	return prtcMemberId;	}
	public void setPrtcMemberId(int prtcMemberId){	this.prtcMemberId = prtcMemberId;	}	
	public int getMemberId(){	return memberId;	}
	public void setMemberId(int memberId){	this.memberId = memberId;	}
	public int getBoardId(){   return boardId;	}
	public void setBoardId(int boardId){   this.boardId = boardId;	}
}	
