package com.example.project.Entity;



public class OTPVerificationRequest {
	
	private String otp;
	private String email;
	public OTPVerificationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OTPVerificationRequest(String otp, String email) {
		super();
		this.otp = otp;
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
