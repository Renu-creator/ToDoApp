package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.Task;
import com.dao.ToDoDAO;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebServlet("/DisplayTaskList")
public class DisplayTaskList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisplayTaskList() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ArrayList<Task> list = ToDoDAO.getTasklist();
		
		System.out.println("list is"+list);
		
		 System.out.println("FinAL nmAP="+list);
		 
		 includeJSONResponse(list, request, response);
	}
		 
		 private void includeJSONResponse(ArrayList<Task> list, HttpServletRequest request,
					HttpServletResponse response)
			{
				String jsonString = getValidJsonFromObject(list);
				try {
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=UTF-8");
					
					

					//System.out.println("before write :: " + response.isCommitted());
					response.getWriter().write(jsonString);
					
					
					System.out.println("jsonString :: " + jsonString);
					
				} catch (Exception e) {
					
					System.err.println("Error in  includeJSONResponse");
				}
			}
			
			private String getValidJsonFromObject(ArrayList<Task> list) {
				if (null == list || list.isEmpty()) {
				    
				list= new ArrayList<Task>();
					
				}
				return getJSONFromObject(list);
			}
			
			
			private String getJSONFromObject(Object object)
			{
				String jsonData = null;
				ObjectMapper writeMapper=new ObjectMapper();
				
				try {
				    jsonData = writeMapper.writeValueAsString(object);
				} catch (Exception e) {
					System.err.println("Error in  getJSONFromObject ");
				}
				return jsonData;
			}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
