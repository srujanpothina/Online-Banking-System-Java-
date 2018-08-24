package DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckAccounts
 */
@WebServlet("/CheckAccounts")
public class CheckAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TransferObj> list=new ArrayList<TransferObj>();

		list = DataAccess.getLowBalanceAccounts();
		PrintWriter out= response.getWriter();
		if(list!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("lowBalanceList", list);
			response.sendRedirect("CheckAccountsAdmin.jsp");
		}
		else 
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('All account holder have sufficient balance. Thats Great.! ');");
			out.println("location='Home.jsp';");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
