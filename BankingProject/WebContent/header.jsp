<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Online Bank</title>
<link rel="stylesheet" href="CSS/header.css" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/footer.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="Home.jsp"> <img
				style="max-width: 70px; height: 50px; margin-top: -17px;"
				src="Images/business.png" /></a>
		</div>
		<div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">

					<li><a href="Home.jsp"
						style="font-family: Comic Sans MS; font-weight: bold; font-size: 20px">ONLINE
							BANK</a></li>
					<c:choose>
						<c:when test="${empty sessionScope.username}">
							<%-- <%
						response.setHeader("Cache-Control","no-cache"); 
						response.setHeader("Cache-Control","no-store,must-revalidate"); 
						response.setDateHeader("Expires", 0);
						response.sendRedirect("index.jsp");
						%> --%>
							<!-- <li><a
								style="font-family: Comic Sans MS; font-weight: bold;"
								href="AdminLogin.jsp">Admin Login</a></li>
							<li><a
								style="font-family: Comic Sans MS; font-weight: bold;"
								href="#section3">Section 3</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">About Us<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#section41">Info</a></li>
									<li><a href="#section42">Contact Us</a></li>
								</ul></li> -->
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test='${sessionScope.userType=="admin"}'>
									<li><a
										style="font-family: Comic Sans MS; font-weight: bold;"
										href="ApproveAccounts">Approve Accounts</a></li>
									<li><a
										style="font-family: Comic Sans MS; font-weight: bold;"
										href="CheckAccounts">Check Account Balances</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										style="font-family: Comic Sans MS; font-weight: bold;"
										href="Balance.jsp">Balance Check</a></li>
									<li><a
										style="font-family: Comic Sans MS; font-weight: bold;"
										href="Transfer.jsp">Transfer Amount</a></li>
									<li><a
										style="font-family: Comic Sans MS; font-weight: bold;"
										href="Statement.jsp">Statement</a></li>
									<li><a
										style="font-family: Comic Sans MS; font-weight: bold;"
										href="Feedback.jsp">Feedback</a></li>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:set var="loginFlag" scope="session" value="false" />
					<c:choose>
						<%-- <c:when test="${loginFlag == false}"> --%>
						<c:when test="${empty sessionScope.username}">
							<li><a href="Index.jsp"><span
									class="glyphicon glyphicon-user"></span> Sign Up / <span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>


						</c:when>
						<c:otherwise>
							<li style="margin-top: 15px; color: white; font-weight: bold;">
								Welcome <c:out value="${sessionScope.username}" />
							</li>
							<li><a href="LoginServlet?logout=1"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>

						</c:otherwise>
					</c:choose>
				</ul>

			</div>
		</div>
	</div>
	</nav>