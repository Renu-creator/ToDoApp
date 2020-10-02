package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.dao.ToDoDAO;

import UtilityJason.UtilityJsonInfo;

/**
 * Servlet implementation class CountEmp
 */
@WebServlet("/CountEmp")
public class CountEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CountEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	ArrayList<Integer> list1 = new ArrayList<>();
		int c=0,c1=0,c2=0;
	
		
			try {
				c = ToDoDAO.getActiveEmplistofLast7Days();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				c1 = ToDoDAO.getdeactiveEmplistofLast7Days();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				c2= ToDoDAO.getTotalTasksOfLast7Days();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		System.out.println(c+" " +c1+" " +c2);
		
		 list1.add(c);
		 list1.add(c1);
		 list1.add(c2);
		 
		 System.out.println(list1);
		 
		 String jsonString = UtilityJsonInfo.getJSONFromObject(list1);
		 response.getWriter().write(jsonString);
		 
		 System.out.println("jsonString :: " + jsonString);
		 
		 
	
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
