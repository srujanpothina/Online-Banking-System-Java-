package DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("hidden");
		PrintWriter out= response.getWriter();
		System.out.println(name+"-------getBalance");
		String feedback=request.getParameter("feedback");



		int flag = DataAccess.feedback(name,feedback);


		if(flag>0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('We received your feeedback, Thank you !');");
			out.println("location='Home.jsp';");
			out.println("</script>");
			response.sendRedirect("Home.jsp");
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Something went wrong, please give your feedback again !');");
			out.println("location='Feedback.jsp';");
			out.println("</script>");

		}
		doGet(request, response);
	}

}
