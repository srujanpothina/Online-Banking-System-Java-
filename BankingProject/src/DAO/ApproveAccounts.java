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
 * Servlet implementation class ApproveAccounts
 */
@WebServlet("/ApproveAccounts")
public class ApproveAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TransferObj> list=new ArrayList<TransferObj>();


		list = DataAccess.approveRequired();
		PrintWriter out= response.getWriter();
		if(list!=null) {
			HttpSession session = request.getSession();

			session.setAttribute("approveList", list);
			response.sendRedirect("ApproveAccounts.jsp");
		}
		else 
		{
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('No accounts available to approve.');");
			out.println("location='Home.jsp';");
			out.println("</script>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
