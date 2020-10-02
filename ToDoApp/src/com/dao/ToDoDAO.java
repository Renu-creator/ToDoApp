package com.dao;

import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import com.bean.Employee;
import com.bean.Login;
import com.bean.Mailer;
import com.bean.Otp;
import com.bean.Task;

import com.constants.ToDoAppConst;


import com.service.ToDoService;

public class ToDoDAO 
{

	public static void setValues(PreparedStatement statement,Object...values) throws SQLException
	{
		for(int i=0;i<values.length;i++)
		{
			statement.setObject(i+1,values[i]);
		}
	}

	@SuppressWarnings("deprecation")
	public static int addUser(Employee emp) {
		
		Connection con=ToDoService.getCon();
		int status = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(ToDoAppConst.STR_TODO_INSERT);
			
			String fname=emp.getFname();
			String lname=emp.getLname();
			String gender=emp.getGen();
			Date dob=emp.getDobdate();
			String pass=emp.getPass();
			String cpass=emp.getCpass();

			String email=emp.getEmail();
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
		    Date date = new Date();  
		    System.out.println(formatter.format(date));  
			

		    	Object parameter[]={fname,lname,gender,dob,pass,cpass,date,email,"active"};
		    	setValues(pstmt, parameter);
		    	

			status = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	
	
	
	

		    
	

	public static int chkLogin(Login em) throws SQLException 
	{
		
		String fname1= null,pass1= null,fname2 = null,pass2= null,email= null;
		
		String pwd=em.getPass();
		String email1=em.getEmail();

		
		System.out.println("from java obj:  "+email1+" "+pwd);
		
		Connection con=ToDoService.getCon();
		int status = 0;		
			
		PreparedStatement stmt=con.prepareStatement("select * from emp_signup");  
		ResultSet rs=stmt.executeQuery();  
			while(rs.next())
			{
				

				 pass1=rs.getString(6);
				 email=rs.getString(9);
				 
				 String empstatus=rs.getString(10);
				 				 
				 System.out.println("from db:  "+pass1+" "+email);
				 
				
				if(pwd.equals(pass1) && email1.equals(email) && empstatus.equalsIgnoreCase("active"))
				{
					
					
					System.out.println( " user login successfully...");
					

					status=1;
					break;
					
				}
				else if( pwd.equals("admin123") && email1.equals("admin@gmail.com"))
				{
					System.out.println("admin login");

					
					status=2;
					break;
				}
				else
				{
					System.out.println("invalid");
				}
			  
			}
			
		return status;  		
	}
	

public static int addTask(Task t) {
		
		Connection con=ToDoService.getCon();
		int status = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(ToDoAppConst.STR_TASK_INSERT);
			
			String taskname=t.getTaskname();
			String taskdesc=t.getDesc();
			String em=t.getEmail();
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
		    Date date = new Date();  
		    System.out.println(formatter.format(date));  
			

			Object parameter[]={taskname,taskdesc,"new",em,formatter.format(date)};
			
			setValues(pstmt, parameter);
			
			status = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	


	
public static ArrayList<Task> getTasklist() 
{
	Connection con = null;
	ArrayList<Task> driveList = new ArrayList<Task>();
	// show alt shift r
	try 
	{
		con = ToDoService.getCon();
		driveList = gettask(con);
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			if(con != null) 
			{
				con.close();
			}
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}
	return driveList;

}
	
	
public static ArrayList<Task> gettask(Connection con) 
{
	ArrayList<Task> list = new ArrayList<Task>();
	
	
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		
		pstmt = con.prepareStatement(ToDoAppConst.STR_TASK_GETALLTASK);
		rs = pstmt.executeQuery();
		while (rs.next()) 
		
		{
			Task tt = new Task();
			
			tt.setTaskid(rs.getInt(1));
			tt.setTaskname(rs.getString(2));
			tt.setDesc(rs.getString(3));
			tt.setTaskstatus(rs.getString(4));
			tt.setEmail(rs.getString(5));
			
			list.add(tt);
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	finally {
		try {
			if(rs != null) {
				rs.close();
			}
			//pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return list;
}


public static int edittask(Task t)
{
	Connection con=ToDoService.getCon();
	int status = 0;
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement(ToDoAppConst.STR_TSK_UPDATE);
		
		
		pstmt.setString(1, t.getTaskname());
		pstmt.setString(2, t.getDesc());
		pstmt.setString(3, "new");
		pstmt.setInt(4, t.getTaskid());
		
		
		status = pstmt.executeUpdate();
		
		System.out.println(t);

	} catch (Exception e) {
		System.out.println(e);
	} finally {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return status;
}

public static int deleteTask(Task t) {
	Connection con = null;
	int status = 0;
	try 
	{
		con = ToDoService.getCon();
		status =deleteTask(t, con);
	} catch (Exception e) {
		e.printStackTrace();
	} finally 
	{
		try 
		{
			if (con != null) 
			{
				con.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	return status;
}


private static int deleteTask(Task t, Connection con) 
{
	int status = 0;

	PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(ToDoAppConst.STR_TSK_DELETE);
			pstmt.setInt(1, t.getTaskid());
	//System.out.println(DriveProjConstants.STR_DRIVE_DELETE);
				status = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println(status);
			return status;
}

public static ArrayList<Employee> getEmplist() throws SQLException
{
	Connection con = null;
	
	ArrayList<Employee> list = new ArrayList<Employee>();
	// show alt shift r
	try 
	{
		con = ToDoService.getCon();
		//emplist = getemp(con);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pstmt = con.prepareStatement(ToDoAppConst.STR_TODO_GETALL);
		rs = pstmt.executeQuery();
		
		while (rs.next()) 
		
		{
			Employee emp = new Employee();
			
			emp.setEmpid(rs.getInt(1));
			emp.setFname(rs.getString(2));
			emp.setLname(rs.getString(3));
			emp.setGen(rs.getString(4));
			emp.setDobdate(rs.getDate(5));
			emp.setTdate(rs.getDate(8));
			emp.setEmpstatus(rs.getString(10));
			
			list.add(emp);
			
			System.out.println("in tododao "+list);
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			if(con != null) 
			{
				con.close();
			}
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}
	return list;

}
	
	



public static int addNewTaskStatus(Task tk) throws SQLException {
	int stat=0;
	
	int tid=tk.getTaskid();
	
	Connection con=ToDoService.getCon();
	int status = 0;		
		
	PreparedStatement stmt=con.prepareStatement("select * from tasklist");  
	ResultSet rs=stmt.executeQuery();  
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(4));
			
			int id= rs.getInt(1);
			
			String st=rs.getString(4);
			
			System.out.println(id+" "+st);
			
			if(tid==id)
			{
				
				PreparedStatement pstmt2 = con.prepareStatement(ToDoAppConst.STR_TSKSTATUS_UPDATE);
				
				
				pstmt2.setString(1, "completed");
				pstmt2.setInt(2, tk.getTaskid());
				
				status = pstmt2.executeUpdate();
				
				System.out.println("present");
				
				stat++;
				break;
				
			}
			else
				
			{
				PreparedStatement pstmt2 = con.prepareStatement(ToDoAppConst.STR_TSKSTATUS_UPDATE);
				
				pstmt2.setString(1, tk.getTaskstatus());
				
			}
		  
		}
		
		if (stat == 1) {
			System.out.println( "task status updated successfully...");
		} else {
			System.out.println("Fail to update");
		}
		
		return stat;  
}

public static int addNewEmpStatus(Employee em) throws SQLException {
int stat=0;
	
	int eid=em.getEmpid();
	
	Connection con=ToDoService.getCon();
	int status = 0;		
		
	PreparedStatement stmt=con.prepareStatement("select * from emp_signup");  
	ResultSet rs=stmt.executeQuery();  
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(10));
			
			int id= rs.getInt(1);
			
			String st=rs.getString(10);
			
			System.out.println(id+" "+st);
			
			if(eid==id)
			{
				
				PreparedStatement pstmt2 = con.prepareStatement(ToDoAppConst.STR_EMPSTATUS_UPDATE);
				
				if(st.equals("deactivate"))
				{
				pstmt2.setString(1, "activate");
				pstmt2.setInt(2, em.getEmpid());
				}
				
				else
				{
					pstmt2.setString(1, "deactivate");
					pstmt2.setInt(2, em.getEmpid());
					
				}
				
//				pstmt2.setInt(2, tk.getTaskid());
				
				status = pstmt2.executeUpdate();
				
				System.out.println("present");
				
				stat++;
				break;
				
			}
			
		  
		}
		
		if (stat == 1) {
			System.out.println( "emp status updated successfully...");
		} else {
			System.out.println("Fail to update");
		}
		
		return stat;  
}




public static int getActiveEmplistofLast7Days() throws SQLException
{
		Connection con = null;
		con = ToDoService.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pstmt = con.prepareStatement("select  count(DATEDIFF(CURRENT_DATE(),tdate)) from emp_signup where DATEDIFF(CURRENT_DATE(),tdate)<7 and empstatus='active'");
		 
		rs = pstmt.executeQuery();
		rs.next();
	      int c = rs.getInt(1);
	      System.out.println("Number of active users: "+c);
	      return c;
}



public static int getdeactiveEmplistofLast7Days() throws SQLException
{
	Connection con = null;
	con = ToDoService.getCon();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	pstmt = con.prepareStatement(ToDoAppConst.STR_DATEWISE_GETDEACT);
	 
	rs = pstmt.executeQuery();
	rs.next();
      int c2 = rs.getInt(1);
      System.out.println("Number of active users: "+c2);
      return c2;
}


public static int getTotalTasksOfLast7Days() throws SQLException
{
	Connection con = null;
	con = ToDoService.getCon();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	pstmt = con.prepareStatement(ToDoAppConst.STR_DATEWISE_GETTOTTASK);
	 
	rs = pstmt.executeQuery();
	rs.next();
      int c3 = rs.getInt(1);
      System.out.println("Number of active users: "+c3);
      return c3;
}



public static String genOtp(Otp o)
{
	String email1=o.getEmail();
	
	int len = 4; 
	 
	 //String reciever_email=o.getEmail();

	 String AlphaNumericString = "0123456789";


	 		StringBuilder sb = new StringBuilder(len); 

	 			for (int i = 0; i <len; i++) 
	 			{ 

	 				int index = (int)(AlphaNumericString.length()* Math.random()); 
	 				sb.append(AlphaNumericString.charAt(index)); 
	 			} 

	    System.out.println("otp is "+sb);
	    
	    String newotp=sb.toString();
     
	    Mailer.send("renuka.dandge@gmail.com","RenuRaut@2014",email1,"OTP",newotp);
	    
	return newotp;
	
}
}

























