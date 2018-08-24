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
 * Servlet implementation class statement
 */
@WebServlet("/statement")
public class statement extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("hidden");
		PrintWriter out= response.getWriter();
		System.out.println(name+"-------getBalance");
		String email=request.getParameter("email");


		String startDateStr = request.getParameter("startDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate=new Date();
		try {
			startDate = sdf.parse(startDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String endDateStr = request.getParameter("endDate");

		SimpleDateFormat edf = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate=new Date();
		try {
			endDate = edf.parse(endDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Data--"+name+email+startDate+endDate);
		ArrayList<TransferObj> list=new ArrayList<TransferObj>();

		list = DataAccess.statement(name,startDate,endDate,email);


		if(list!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("statementList", list);

			out.println("<script type=\"text/javascript\">");
			out.println("location='StatementGenerated.jsp';");
			out.println("</script>");
		}
		else {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('No transactions available for selected dates.');");
			out.println("location='Home.jsp';");
			out.println("</script>");
		}
		doGet(request, response);
	}

}
