package com.bean;

public class Login 
{
	
	private String fname;
	private String pass;
	private String email;
	private String otp;
	
	public Login()
	{
		
	}

	public Login(String fname, String pass, String email, String otp) {
		super();
		this.fname = fname;
		this.pass = pass;
		this.email = email;
		this.otp = otp;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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
		return "Login [fname=" + fname + ", pass=" + pass + ", email=" + email + ", otp=" + otp + "]";
	}

	
	

}
