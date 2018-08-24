package DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("logout--"+request.getParameter("logout"));
		HttpSession session = request.getSession();
		if(!request.isRequestedSessionIdValid())
		{
			request.getSession().invalidate();
		}
		if(request.getParameter("logout")!=null) {

			session.removeAttribute("username");
			//session.invalidate();
			HttpServletResponse httpResponse = (HttpServletResponse)response;

			httpResponse.setDateHeader ("Expires", 0); 
			if (session.getAttribute("username") == null ) { 
				System.out.println("not equal");
				session.invalidate();
				response.setHeader("Cache-Control","no-cache"); 
				response.setHeader("Cache-Control","no-store"); 
				response.setDateHeader("Expires", 0);

				response.sendRedirect("Index.jsp");
				return;
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HttpSession session1 = request.getSession();
		if(session1!=null) {
			System.out.println("invalidate");

		}
		PrintWriter out= response.getWriter();
		String page=request.getParameter("hidden");
		//System.out.println("login"+request.getParameter("loginSubmit"));
		//System.out.println("register"+request.getParameter("loginSubmit"));
		if(request.getParameter("loginSubmit")!=null)
		{
			//System.out.println(request.getParameter("usernameLogin"));
			//System.out.println(request.getParameter("passwordLogin"));
			String type=request.getParameter("type");
			System.out.println(type);
			if(type.trim().equals("user")) {	
				type="user";
			}
			else {
				type="admin";
			}
			String fullname=DataAccess.validate(request.getParameter("usernameLogin"),request.getParameter("passwordLogin"),type);
			//System.out.println(fullname);
			if(fullname=="--") {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User or password incorrect');");
				out.println("location='Index.jsp';");
				out.println("</script>");
			}
			else if(fullname.equals("+")) {
				System.out.print("+++");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Account not yet approved by admin.');");
				out.println("location='Index.jsp';");
				out.println("</script>");
			}
			else {
				response.sendRedirect("Home.jsp");
				session.setAttribute("username", fullname);
				session.setAttribute("userType", type);
				System.out.print("else if ");

			}
		}
		else if(request.getParameter("registerSubmit")!=null)
		{
			Date date = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = sdf.parse(request.getParameter("dob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(String.valueOf(date));
			Customer customer =new Customer(
					request.getParameter("name"), request.getParameter("username"), request.getParameter("password"),
					request.getParameter("email"), request.getParameter("ssn"), request.getParameter("address"),request.getParameter("gender"),
					new java.sql.Date(date.getTime()), Long.parseLong(request.getParameter("phone")), Integer.parseInt(request.getParameter("branch")),
					Double.parseDouble(request.getParameter("balance")));
			if(DataAccess.register(customer)>0) {
				//PrintWriter out= response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Successfully Registered');");
				out.println("location='Home.jsp';");
				out.println("</script>");
			}
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Sorry, Registration unsuccessful');");
				out.println("location='Index.jsp';");
				out.println("</script>");
			}
		}
		else {
			doGet(request,response);
		}

	}

}
