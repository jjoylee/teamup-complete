package org.teamup.domain;

public class JsonResponse {
	private String result;
	private String message;
	
	public String getResult(){	return result;	}
	public void setResult(String result){
		this.result = result;
	}
	public String getMessage(){	return message;	}
	public void setMessage(String message){
		this.message = message;
	}
	public void setResults(String result, String message){
		this.result = result;
		this.message = message;
	}
}
