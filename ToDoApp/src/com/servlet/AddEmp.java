package com.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.JSONObject;

import com.bean.Employee;

import com.dao.ToDoDAO;

import UtilityJason.UtilityJsonInfo;


@WebServlet("/AddEmp")
public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsonObject = request.getReader().readLine();
		
		System.out.println("from angular"+jsonObject);
		
		System.out.println("ok");
		
		
		
		Employee em=(Employee) UtilityJsonInfo.getObjectFromJSON(jsonObject, Employee.class);
		System.out.println("ok2");
		
		System.out.println("java obj "+em);
		int status = ToDoDAO.addUser(em);

		HashMap<String, String> hm = new HashMap<String, String>();
		if (status == 1) {
			hm.put("Msg", "Employee Added successfully");
		} else {
			hm.put("Msg", "Fail to Add Employee");
		}

		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
		response.getWriter().write(jsonobj);
		response.flushBuffer();

		System.out.println("Employee Added " + status);


	}

}
