package com.servlet;

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

import UtilityJason.UtilityJsonInfo;


@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TaskServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		String jsonObject = request.getReader().readLine();
		//String jsonObject = str;
		
		System.out.println("from angular"+jsonObject);
		
		System.out.println("ok");
		
		
		Task tk=(Task) UtilityJsonInfo.getObjectFromJSON(jsonObject, Task.class);
		System.out.println("ok2");
		
		System.out.println("java obj "+tk);
		int status = ToDoDAO.addTask(tk);

		HashMap<String, String> hm = new HashMap<String, String>();
		if (status == 1) {
			hm.put("Msg", "Task Added successfully");
		} else {
			hm.put("Msg", "Fail to Add task");
		}

		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
		response.getWriter().write(jsonobj);
		response.flushBuffer();

		System.out.println("task Added " + status);
	}

}
