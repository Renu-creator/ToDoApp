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
import com.bean.Login;
import com.dao.ToDoDAO;

import UtilityJason.UtilityJsonInfo;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
//		String jsonObject = request.getReader().readLine();
//		
//		System.out.println("from angular"+jsonObject);
//		
//		System.out.println("ok");
//		
//		Login admin=(Login) UtilityJsonInfo.getObjectFromJSON(jsonObject, Login.class);
//		System.out.println("ok2");
//		
//		System.out.println("java obj "+admin);
//		int status = 0;
		//try {
////			status = ToDoDAO.chkLogin(admin);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		HashMap<String, String> hm = new HashMap<String, String>();
//		if (status == 1) {
//			hm.put("Msg", "Admin login successfully....wow");
//		} else {
//			hm.put("Msg", "Admin Fail to login");
//		}
//
//		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
//		response.getWriter().write(jsonobj);
//		response.flushBuffer();
//
//		System.out.println("Admin Authenticated " + status);
//
//
	}
	

}
