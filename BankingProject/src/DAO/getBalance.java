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
 * Servlet implementation class getBalance
 */
@WebServlet("/getBalance")
public class getBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String name=request.getParameter("fullname");
		PrintWriter out= response.getWriter();
		System.out.println(name+"-------getBalance");
		String email=request.getParameter("email");
		
		
		HttpSession session1 = request.getSession();
		
		double balance=DataAccess.getBalance(name,email);
		if(balance>-1) {
			System.out.println("Balance--"+balance);
			response.getWriter().write(String.valueOf(balance));
		}
		else {
			response.getWriter().write("error");
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
