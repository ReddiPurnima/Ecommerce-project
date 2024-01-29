package com.example.project.DTO;


public class NewpasswordRequest {
	
	private String newpassword;
	private String confirmedpassword;
	public NewpasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewpasswordRequest(String newpassword, String confirmedpassword) {
		super();
		this.newpassword = newpassword;
		this.confirmedpassword = confirmedpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmedpassword() {
		return confirmedpassword;
	}
	public void setConfirmedpassword(String confirmedpassword) {
		this.confirmedpassword = confirmedpassword;
	}
	
	 

}
