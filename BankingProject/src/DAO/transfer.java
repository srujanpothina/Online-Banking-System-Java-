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
 * Servlet implementation class transfer
 */
@WebServlet("/transfer")
public class transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name=request.getParameter("hidden");
		PrintWriter out= response.getWriter();
		System.out.println(name+"-------getBalance");
		String email=request.getParameter("email");
		String emailSender=request.getParameter("emailSender");
		Double amount=Double.parseDouble(request.getParameter("amount"));

		System.out.println(email+emailSender);
		HttpSession session1 = request.getSession();

		int val = DataAccess.transfer(name,email,emailSender,amount);
		System.out.println("Value"+val);
		if(val==-1) {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Your email Id entered does not match our records');");
			out.println("location='Transfer.jsp';");
			out.println("</script>");
		}
		else if(val==-2) {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Sorry, you do not have sufficient funds to perform this transfer.');");
			out.println("location='Transfer.jsp';");
			out.println("</script>");
		}
		else if(val==-3) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Recievers email Id entered does not match our records');");
			out.println("location='Transfer.jsp';");
			out.println("</script>");
		}
		else if(val==-4) {

			out.println("<script type=\"text/javascript\">");
			out.println("Sorry, Transfer Failed. Try Again.');");
			out.println("location='Transfer.jsp';");
			out.println("</script>");
		}
		else if(val==1) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Amount successfully transferred.');");
			out.println("location='Home.jsp';");
			out.println("</script>");

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
