package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataAccess {
	public static boolean checkUsername(String username)
	{
		boolean status = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;


			String query="select * from Customer where username=?";

			ps = conn.prepareStatement(query);
			ps.setString(1, username);

			rs=ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}
	public static int register(Customer customer) {
		boolean status = false;
		Connection conn = null;
		Statement st = null;
		int rs = 0;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;


			String query="insert into customer (customername,ssn,dob,address,phoneno,emailid,branchid,username,password,gender,balance,opendate) values(?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(query);
			ps.setString(1, customer.fullName);
			ps.setString(2, customer.ssn);
			ps.setDate(3, (Date) customer.dob);
			ps.setString(4, customer.address);
			ps.setLong(5, customer.phone);
			ps.setString(6, customer.emailId);
			ps.setInt(7, customer.branch);
			ps.setString(8, customer.username);
			ps.setString(9, hashPassword(customer.password));
			ps.setString(10, customer.gender);
			ps.setDouble(11, customer.balance);
			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			java.sql.Date date = new java.sql.Date(currentDate.getTime());
			ps.setDate(12, date );

			rs=ps.executeUpdate();


		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return rs;
	}
	public static int changePassword(String newPwd,String email,String type) {
		boolean status = false;
		Connection conn = null;
		Statement st = null;
		int rs = 0;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;


			String query="";
			if(type.trim().equals("user")) {
				System.out.println(newPwd+email+type);
				query="update Customer set password=? where emailid=?";
			}else {
				query="update Admin set password=? where emailid=?";
			}


			ps = conn.prepareStatement(query);
			ps.setString(1, hashPassword(newPwd));
			ps.setString(2, email);


			rs=ps.executeUpdate();


		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return rs;
	}
	public static String validate(String Name, String Pass,String type) {		
		boolean status = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		String fullname="";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;
			String query="";
			//String query="select * from login where user='"+ Name+"' and password='"+Pass+"'";
			System.out.println(type);
			if(type=="user")
				query="select CustomerName from Customer where username=? and password=?";
			else
				query="select name from Admin where username=? and password=?";

			ps = conn.prepareStatement(query);
			ps.setString(1, Name);
			ps.setString(2, hashPassword(Pass));
			//ps.execute();
			/*String query
              = "INSERT INTO User (Email, FirstName, LastName) "
              + "VALUES (?, ?, ?)";*/
			rs=ps.executeQuery();
			status = rs.next();
			//System.out.println(status);

			if(type=="user" && status)
			{
				query="select CustomerName from Customer where username=? and password=? and islocked=1";
				ps = conn.prepareStatement(query);
				ps.setString(1, Name);
				ps.setString(2, hashPassword(Pass));
				rs=ps.executeQuery();
				status = rs.next();
				if(!status)
					return "+";
			}
			if(!status) {

				return "--";
			}

			fullname=rs.getString(1);

			System.out.println(fullname);


		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return fullname;
	}

	public static String getName (String Name, String Pass) {		
		String fullName=null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;


		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
			st = conn.createStatement();
			String query="select * from branch";
			rs=st.executeQuery(query);
			if (rs.next())
				fullName=rs.getString("fullName");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return fullName;
	}
	public static boolean checkEmail(String email) {
		boolean status = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;


			String query="select * from Customer where emailid=?";

			ps = conn.prepareStatement(query);
			ps.setString(1, email.trim());

			rs=ps.executeQuery();
			status = rs.next();
			if(status)
				return status;
			System.out.println(email+"-Forgot--User--"+status);
			query="select * from Admin where emailid=?";

			ps = conn.prepareStatement(query);
			ps.setString(1, email);

			rs=ps.executeQuery();
			status = rs.next();
			System.out.println("Forgot--Admin--"+status);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}
	public static double getBalance(String name,String email) {
		double balance=0.0; 
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean status=false;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;


			String query="select balance from Customer where customername=? and emailid=?";

			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email.trim());

			rs=ps.executeQuery();
			status = rs.next();
			if(rs==null || !status)
				return -1;
			else
				return 	rs.getDouble("balance");


		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return balance;
	}
	public static int transfer(String name,String email, String emailSender, Double amount) {

		double balance=0.0; 
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean status=false;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;


			/*insert into transfer (amount,senderAccno,recieverAccno,date_time)values(10000,100000000,100000001,date '2017-12-21');
			update Customer set balance=balance-100 where accno=100000000 and balance>100;
			update Customer set balance=balance+10000 where accno=100000001;*/

			String query="select * from Customer where customername=? and emailid=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, emailSender.trim());
			rs=ps.executeQuery();
			status = rs.next();
			if(rs==null || !status)
				return -1; // sender invalid
			int accNoSender=rs.getInt("accNo");
			if(rs.getDouble("balance")<amount) {
				return -2; // insufficient funds
			}

			query="select * from Customer where emailid=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, email.trim());
			rs=ps.executeQuery();
			status = rs.next();
			if(rs==null || !status)
				return -3;// reciever invalid


			int accNoReciever=rs.getInt("accNo");

			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			java.sql.Date date = new java.sql.Date(currentDate.getTime());

			query="insert into transfer (amount,senderAccno,recieverAccno,date_time)values(?,?,?,?);";
			ps = conn.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setInt(2, accNoSender);
			ps.setInt(3, accNoReciever);
			ps.setDate(4, date);


			int rs1=ps.executeUpdate();
			if(rs1 >0)
			{
				query="update customer set balance=balance - ? where accno = ?";
				ps = conn.prepareStatement(query);
				ps.setDouble(1,amount);
				ps.setInt(2, accNoSender);
				int updateSender=ps.executeUpdate();

				query="update customer set balance=balance + ? where accno = ?";
				ps = conn.prepareStatement(query);
				ps.setDouble(1,amount);
				ps.setInt(2, accNoReciever);
				int updateReceiver=ps.executeUpdate();

				return 1;
			}
			else{
				return -4;// could not transfer.
			}


		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public static ArrayList<TransferObj> statement(String name, java.util.Date startDate, java.util.Date endDate, String email) {

		double balance=0.0; 
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean status=false;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		ArrayList<TransferObj> list=new ArrayList<TransferObj>();
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;

			System.out.println("Data in data access--"+name+email+startDate+endDate);

			String query="select * from Customer where customername=? and emailid=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email.trim());
			rs=ps.executeQuery();
			status = rs.next();

			if(rs==null || !status)
				return null; // email invalid

			int accNoSender=rs.getInt("accNo");
			System.out.println("Accno"+accNoSender);

			Calendar calendar = Calendar.getInstance();
			java.sql.Date date1 = new java.sql.Date(startDate.getTime());
			java.sql.Date date2 = new java.sql.Date(endDate.getTime());

			query="select * from Transfer where (senderAccNo = ? or recieverAccNo = ? ) and date_time >= ? and date_time <= ? ";

			ps = conn.prepareStatement(query);
			ps.setInt(1, accNoSender);
			ps.setInt(2, accNoSender);
			ps.setDate(3, date1);
			ps.setDate(4, date2);

			rs=ps.executeQuery();
			while (rs.next()) {
				//int sender, int receiver, Double amount, Date date
				TransferObj obj=new TransferObj(rs.getInt("senderAccno"),rs.getInt("senderAccno"),rs.getDouble("amount"),rs.getDate("date_time"));
				list.add(obj);
			}
			System.out.println("Size--"+list.size());
			status = rs.next();
			if(list.size()<=0) {
				return null;// No data found
			}
			return list;


		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	public static int feedback(String name, String feedback) {
		boolean status = false;
		Connection conn = null;
		Statement st = null;
		int rs = 0;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;

			String query="insert into feedback (name,feedback) values(?,?)";

			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, feedback);

			rs=ps.executeUpdate();


		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return rs;
	}
	public static ArrayList<TransferObj> approveRequired() {
		// 		boolean status = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<TransferObj> list=new ArrayList<TransferObj>();

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;

			String query="select * from customer where islocked=0";

			ps = conn.prepareStatement(query);

			rs=ps.executeQuery();
			while (rs.next()) {
				TransferObj obj=new TransferObj(rs.getString("customername"),rs.getString("emailid"));
				list.add(obj);
			}
			System.out.println("Size--of this-----"+list.size());
			boolean status = rs.next();
			if(list.size()<=0) {
				return null;// No data found
			}


		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return list;
	}
	public static int approveAccounts(ArrayList<String> email) {
		// boolean status = false;
		Connection conn = null;
		Statement st = null;
		int rs = 0;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		System.out.println(email.size());
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;
			String query="";
			for(String emails : email)
			{
				query = "update customer set islocked = 1 where emailid=?";

				ps = conn.prepareStatement(query);

				ps.setString(1, String.valueOf(emails.trim()));

				rs=ps.executeUpdate();
				if(rs>0) {
					sendEmail(emails.trim(),0);
				}

			}



		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return rs;
	}
	public static ArrayList<TransferObj> getLowBalanceAccounts() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<TransferObj> list=new ArrayList<TransferObj>();

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bank";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);

			st = conn.createStatement();
			PreparedStatement ps = null;

			String query="select * from customer where balance<1500";

			ps = conn.prepareStatement(query);

			rs=ps.executeQuery();
			while (rs.next()) {
				TransferObj obj=new TransferObj(rs.getString("customername"),rs.getString("emailid"),rs.getDouble("balance"));
				list.add(obj);
			}
			System.out.println("Size--of this-----"+list.size());
			boolean status = rs.next();
			if(list.size()<=0) {
				return null;// No data found
			}


		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return list;
	}

	public static void sendEmail(String email,int i) {
		String text="Dear Customer, \n\n Your account has been approved. You can login with the credentials you have used during account creation. \n \n Hope we serve you at the best. \n \n Thanks";
		String subject="Account Approved (Online Bank)";
		if(i==1) {
			text="Dear Customer, \n\n Your account has low balance. Please meet minimum balance requirement to avoid additional charges of $5. \n Thanks";
			subject="Low Balance Alert (Online Bank)";
		}
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

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("srujan4948@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public static String hashPassword(String password) throws NoSuchAlgorithmException {
		try{
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] b=md.digest();
			StringBuffer sb=new StringBuffer();
			for(byte b1:b){
				sb.append(Integer.toHexString(b1 & 0xff).toString());
			}
			System.out.println("Hashed--"+sb.toString());
			return sb.toString();
		}
		catch(Exception e){
			return "Error-Hash";
		}
	}


}
