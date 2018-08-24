package SendEmail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DataAccess;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class email
 */

@WebServlet("/email")
public class email extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub




		String email=request.getParameter("email");
		String otp=request.getParameter("otp");
		String newPassword=request.getParameter("newPwd");
		String type=request.getParameter("type");
		PrintWriter out = response.getWriter();

		HttpSession session1 = request.getSession(false);


		if(email !=null)
		{
			//System.out.println("alert('email');");
			session1.removeAttribute("otp");
			session1.removeAttribute("newPassword");
			session1.removeAttribute("emailPwd");



			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("srujan4948@gmail.com","password-1");
				}
			});

			try {
				java.util.Random generator = new java.util.Random();
				generator.setSeed(System.currentTimeMillis());
				int i = generator.nextInt(1000000) % 1000000;

				session1.setAttribute("emailPwd", email);
				session1.setAttribute("oneTime",  Integer.toString(i));

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("srujan4948@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email));
				message.setSubject("Forgot Password (Online Bank)");
				message.setText("Dear Customer," +
						"\n\n Your One time password is: "+ i + "\n Using this you can change your password." );

				Transport.send(message);

				/*System.out.println("Done");*/

				//System.out.println(session1.getAttribute("oneTime"));
				//System.out.println(session1.getAttribute("emailPwd"));

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
		else if(otp!=null)
		{
			//System.out.println(otp+"----"+session1.getAttribute("oneTime"));
			//session1.removeAttribute("emailPwd");


			if(otp.trim().equals(session1.getAttribute("oneTime")))
			{
				session1.setAttribute("pwd", true);
				//System.out.println("alert('OTP matches);");

			}
			else {
				System.out.println("alert('OTP does not match. Try again);");
			}

		}
		else if(newPassword!=null)
		{

			session1.removeAttribute("otp");
			session1.removeAttribute("pwd");
			//System.out.println(String.valueOf(session1.getAttribute("emailPwd")));
			//System.out.println(newPassword+request.getParameter("type")+"--"+newPassword);
			if(DataAccess.changePassword(newPassword, String.valueOf(session1.getAttribute("emailPwd")), type)>0) {
				session1.removeAttribute("emailPwd");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Password successfully changed');");
				out.println("location='Index.jsp';");
				out.println("</script>");
				return;
			}
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Password could not be changed');");
				out.println("location='forgotPassword.jsp';");
				out.println("</script>");
			}



			/*
			//System.out.println("alert('pwd');");
			out.println("alert('Password Successfully changed');");
			RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");  
			rd.forward(request,response);
			return;*/
		}
		RequestDispatcher rd=request.getRequestDispatcher("forgotPassword.jsp");  
		rd.forward(request,response); 
	}



}
