package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.bean.Task;
import com.dao.ToDoDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import UtilityJason.UtilityJsonInfo;


@WebServlet("/DisplayEmp")
public class DisplayEmp extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
    public DisplayEmp() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ArrayList<Employee> list1 = null;
		try {
			list1 = ToDoDAO.getEmplist();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		 
		 String jsonString = UtilityJsonInfo.getJSONFromObject(list1);
		 response.getWriter().write(jsonString);
		 
		 System.out.println("jsonString :: " + jsonString);
		 
		 
	
}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

	
}
