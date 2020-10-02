package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/UpdateEmpStatus")
public class UpdateEmpStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateEmpStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonObject = request.getReader().readLine();
		//String jsonObject = str;
		
		System.out.println("from angular"+jsonObject);
		
		System.out.println("ok");
		
		
		
		Employee em=(Employee) UtilityJsonInfo.getObjectFromJSON(jsonObject, Employee.class);
		System.out.println("ok2");
		
		System.out.println("java obj "+em);
		int status = 0;
		try {
			status = ToDoDAO.addNewEmpStatus(em);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashMap<String, String> hm = new HashMap<String, String>();
		if (status == 1) {
			hm.put("Msg", "Emp status updated successfully");
		} else {
			hm.put("Msg", "Fail to update emp status");
		}

		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
		response.getWriter().write(jsonobj);
		response.flushBuffer();

		System.out.println("emp status updated " + status);
	}

	

}
