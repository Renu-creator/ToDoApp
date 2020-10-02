package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Login;
import com.dao.ToDoDAO;

import UtilityJason.UtilityJsonInfo;

/**
 * Servlet implementation class LoginSystemServlet
 */
@WebServlet("/LoginSystemServlet")
public class LoginSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginSystemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
		/*String jsonObject = request.getReader().readLine();
		
		
		System.out.println("from angular"+jsonObject);
		
		System.out.println("ok");
		
		
		
		Login em=(Login) UtilityJsonInfo.getObjectFromJSON(jsonObject, Login.class);
		System.out.println("ok2");
		
		System.out.println("java obj "+em);
		
		//String empname=em.
		
	int status = 0;
		
		//String role = null;
		
		try {
			status = ToDoDAO.chkLogin2(em);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		System.out.println("role is "+status);

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		if (role == "admin") {
			hm.put("Msg", "admin");
		} else {
			hm.put("Msg", "employee");
		}
		
		if (status == 1) 
		{
			hm.put("status",1);
			
		} 
		else if(status== 2)
		{
			hm.put("status", 2);
		}

		else
		{
			hm.put("status", 0);
		}
		
		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
		response.getWriter().write(jsonobj);
		response.flushBuffer();

		System.out.println("user auntenticted " + status);


	}
*/	
	//}

}
