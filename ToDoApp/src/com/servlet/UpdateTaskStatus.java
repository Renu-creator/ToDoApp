package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Task;
import com.dao.ToDoDAO;

import UtilityJason.UtilityJsonInfo;


@WebServlet("/UpdateTaskStatus")
public class UpdateTaskStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateTaskStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonObject = request.getReader().readLine();
		//String jsonObject = str;
		
		System.out.println("from angular"+jsonObject);
		
		System.out.println("ok");
		
		//Employee ur=(Employee) UtilityJsonInfo.getObjectFromJSON(jsonObject, Employee.class);
		
		Task tk=(Task) UtilityJsonInfo.getObjectFromJSON(jsonObject, Task.class);
		System.out.println("ok2");
		
		System.out.println("java obj "+tk);
		int status = 0;
		try {
			status = ToDoDAO.addNewTaskStatus(tk);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashMap<String, String> hm = new HashMap<String, String>();
		if (status == 1) {
			hm.put("Msg", "Task status updated successfully");
		} else {
			hm.put("Msg", "Fail to update task status");
		}

		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
		response.getWriter().write(jsonobj);
		response.flushBuffer();

		System.out.println("task status updated " + status);
	}

	

}
