package DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Approved
 */
@WebServlet("/Approved")
public class Approved extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] results = request.getParameterValues("checked");
		ArrayList<String> email=new ArrayList<String>();
		PrintWriter out= response.getWriter();
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]); 
			email.add(results[i]);
		}
		
		int flag=DataAccess.approveAccounts(email);
		if(flag>0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Accounts Approved');");
			out.println("location='ApproveAccounts';");
			out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Could not approve accounts');");
			out.println("location='ApproveAccounts.jsp';");
			out.println("</script>");
		}
		doGet(request, response);
	}

}
