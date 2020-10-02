package com.bean;

public class Otp {
	
	private String email;
	private String otp;
	
	
	public Otp()
	{
		
	}
	
	public Otp(String email, String otp) {
		super();
		this.email = email;
		this.otp = otp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "Otp [email=" + email + ", otp=" + otp + "]";
	}
	
	
	

}
