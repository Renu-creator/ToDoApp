package com.bean;

import java.util.Date;

public class Task {
	
	private int taskid;
	private String taskname;
	private String desc;
	private String taskstatus;
	private String email;
	
	
	public Task()
	{
		
	}

	public Task(int taskid, String taskname, String desc, String taskstatus, String email) {
		
		this.taskid = taskid;
		this.taskname = taskname;
		this.desc = desc;
		this.taskstatus = taskstatus;
		this.email = email;
		
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", taskname=" + taskname + ", desc=" + desc + ", taskstatus=" + taskstatus
				+ ", email=" + email + "]";
	}

	
	
	
	

}
