package DAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkUsername
 */
@WebServlet("/checkUsername")
public class checkUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String username=request.getParameter("username");
		PrintWriter out= response.getWriter();
		System.out.println(username+"-------get");
		String hidden=request.getParameter("hidden");
		boolean result=false;
		boolean email=false;
		HttpSession session1 = request.getSession();
		System.out.println("hidden--"+hidden);
		if(hidden!=null)
		{
			result=DataAccess.checkEmail(hidden.trim());
			if(result) {
				response.getWriter().write("success");
			}
			else {
				response.getWriter().write("error");
			}
		}
		else {
			result=DataAccess.checkUsername(username);
			if(result)
			{
				response.getWriter().write("error");
			}
			else {
				response.getWriter().write("success");
			}	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet post");

		doGet(request, response);
	}

}
