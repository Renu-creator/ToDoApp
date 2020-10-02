package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.bean.Task;

import com.dao.ToDoDAO;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.service.ToDoService;

import UtilityJason.UtilityJsonInfo;


@WebServlet("/UpdateTask")
public class UpdateTask extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String jsonObject = request.getReader().readLine();
		//String jsonObject = str;
		
		System.out.println("from angular"+jsonObject);
		
		System.out.println("ok");
		
		Task t=(Task) UtilityJsonInfo.getObjectFromJSON(jsonObject, Task.class);
		//System.out.println("ok2");
		
		System.out.println("java obj "+t);
		int status = ToDoDAO.edittask(t);

		HashMap<String, String> hm = new HashMap<String, String>();
		if (status == 1) {
			hm.put("Msg", "Employee updated successfully");
		} else {
			hm.put("Msg", "Fail to update Employee");
		}

		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
		response.getWriter().write(jsonobj);
		response.flushBuffer();

		System.out.println("Employee updated " + status);


	}

		
		
	
}


