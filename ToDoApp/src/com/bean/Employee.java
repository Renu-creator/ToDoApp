package com.bean;

import java.util.Date;

public class Employee {
	
	private int empid;
	private String fname;
	private String lname;
	private String gen;
	private Date dobdate;
	private String pass;
	private String cpass;
	private Date tdate;
	private String email;
	private String empstatus;
	private String otp;
	
	public Employee()
	{
		
	}

	public Employee(int empid, String fname, String lname, String gen, Date dobdate, String pass, String cpass,
			Date tdate, String email, String empstatus, String otp) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		this.gen = gen;
		this.dobdate = dobdate;
		this.pass = pass;
		this.cpass = cpass;
		this.tdate = tdate;
		this.email = email;
		this.empstatus = empstatus;
		this.otp = otp;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public Date getDobdate() {
		return dobdate;
	}

	public void setDobdate(Date dobdate) {
		this.dobdate = dobdate;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpstatus() {
		return empstatus;
	}

	public void setEmpstatus(String empstatus) {
		this.empstatus = empstatus;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", fname=" + fname + ", lname=" + lname + ", gen=" + gen + ", dobdate="
				+ dobdate + ", pass=" + pass + ", cpass=" + cpass + ", tdate=" + tdate + ", email=" + email
				+ ", empstatus=" + empstatus + ", otp=" + otp + "]";
	}

	

	

	
	
	
	

}
