package com.constants;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ToDoAppConst {
	

	public static String STR_TODO_INSERT = "insert into emp_signup(emp_fname,emp_lname,emp_gen,emp_dob,emp_pwd,emp_cpwd,tdate,emp_email,empstatus) values(?,?,?,?,?,?,?,?,?)";
	
	public static String STR_TODO_GETALL = "select * from emp_signup";
	
	public static String STR_DATEWISE_GETACT ="select  count(DATEDIFF(CURRENT_DATE(),tdate)) from emp_signup where DATEDIFF(CURRENT_DATE(),tdate)<7 and empstatus='active'";
	
	public static String STR_DATEWISE_GETDEACT ="select  count(DATEDIFF(CURRENT_DATE(),tdate)) from emp_signup where DATEDIFF(CURRENT_DATE(),tdate)<7 and empstatus='deactivate'";
	
	public static String STR_DATEWISE_GETTOTTASK ="select  count(*) from tasklist where DATEDIFF(CURRENT_DATE(),Date)<7";
			
	public static String STR_TASK_INSERT = "insert into tasklist(taskname,taskdesc,taskstatus,email,Date) values(?,?,?,?,?)";
	
	public static String STR_TASK_GETALLTASK = "select * from tasklist";
	
	
	
	public static final String STR_TSK_UPDATE = "update tasklist set taskname=?,taskdesc=?,taskstatus=? where taskid=?";
	
	public static final String STR_TSKSTATUS_UPDATE = "update tasklist set taskstatus=? where taskid=?";
	
	public static final String STR_EMPSTATUS_UPDATE = "update emp_signup set empstatus=? where empid=?";
	
	public static String STR_TSK_DELETE = "delete from tasklist where taskid=?";
	

	
	public static String STR_OTP_INSERT = "insert into otps(email,otp) values(?,?)";
	
	
	public static  ObjectMapper mapper=new ObjectMapper();
	
	
	

}
