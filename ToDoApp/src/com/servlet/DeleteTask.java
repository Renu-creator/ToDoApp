package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.json.JSONException;
import org.json.JSONObject;
*/

import com.bean.Task;
import com.constants.ToDoAppConst;
import com.dao.ToDoDAO;
import com.fasterxml.jackson.core.JsonProcessingException;

import UtilityJason.UtilityJsonInfo;

@WebServlet("/DeleteTask")
public class DeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		String jsonObject = request.getReader().readLine();
		//String jsonObject = str;
		
		System.out.println("from angular"+jsonObject);
		
		System.out.println("ok");
		
		Task t=(Task) UtilityJsonInfo.getObjectFromJSON(jsonObject, Task.class);
		System.out.println("ok2");
		System.out.println("java obj "+t);
		int status=ToDoDAO.deleteTask(t);
		HashMap<String,String> hm=new HashMap<String, String>();
		
		System.out.println("Task Deleted " + status);
		
		
		if(status==1)
		{
			hm.put("Msg","task Deleted successfully");
		}
		else
		{
			hm.put("Msg","Fail to Delete");
		}
		
		
		
		String jsonobj = UtilityJsonInfo.getJSONFromObject(hm);
		response.getWriter().write(jsonobj);
		response.flushBuffer();

		System.out.println("Employee deleted " + status);


	}

}

		
		
	
