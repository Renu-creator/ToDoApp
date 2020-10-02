package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.bean.Login;
import com.bean.Mailer;
import com.bean.Otp;
import com.dao.ToDoDAO;

import UtilityJason.UtilityJsonInfo;

@WebServlet("/GenerateOtp")
public class GenerateOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerateOtp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String jsonObject = request.getReader().readLine();
		
		
		System.out.println("from angular"+jsonObject);
		
		System.out.println("ok");
		
		Otp o=(Otp) UtilityJsonInfo.getObjectFromJSON(jsonObject, Otp.class);
		System.out.println("ok2");
		
		System.out.println("java obj "+o);
		
		String otp = null;
		

		
		otp = ToDoDAO.genOtp(o);


		HashMap<String, String> hm = new HashMap<String, String>();
		
		

			hm.put("status",otp);
			

		
		
		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
		response.getWriter().write(jsonobj);
		response.flushBuffer();

		System.out.println("otp has been mailed" + otp);
		
		

	}

}
