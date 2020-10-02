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
 * Servlet implementation class GetOtp
 */
@WebServlet("/GetOtp")
public class GetOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOtp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	//{
/*String jsonObject = request.getReader().readLine();
		
		
		System.out.println("from angular"+jsonObject);
		
		System.out.println("ok");
		
		Login em=(Login) UtilityJsonInfo.getObjectFromJSON(jsonObject, Login.class);
		System.out.println("ok2");
		
		System.out.println("java obj "+em);
		
		int status = 0;
		
		try {
			status = ToDoDAO.chkOtp(em);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("role is "+status);

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		
		if (status == 1) 
		{
			hm.put("status",1);
			
		} 
		
		else
		{
			hm.put("status", 0);
		}
		
		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
		response.getWriter().write(jsonobj);
		response.flushBuffer();

		System.out.println("otp created" + status);


	}*/

	

}
