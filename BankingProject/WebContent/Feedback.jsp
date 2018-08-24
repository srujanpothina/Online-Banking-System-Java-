<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css" href="CSS/form.css">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<div class="container">
		<h2>WELCOME</h2>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-8">
				<div class="container">
					<c:set var="flag" value="fromLogin" scope="session" />
					<div class="row main">
						<div class="col-md-5">
							<div class="panel-heading">
								<div class="panel-title text-center">
									<h1 class="title">Feedback</h1>
									<hr />
								</div>
							</div>
							<form action="Feedback" method="post">
								<div class="main-login main-center">
									<span class="form-horizontal"> <br>
										<div class="form-group" id="usernameDiv">
											<div class="input-group">
												<span class="input-group-addon"><i
													class="fa fa-users fa" aria-hidden="true"></i></span> <input
													type="text" disabled class="form-control"
													value="${sessionScope.username}" onfocusout="myFunction()"
													name="username" id="username"
													placeholder="Enter your Username" />
											</div>
											<input type="hidden" name="hidden"
												value="${sessionScope.username}">
										</div>

										<div class="form-group" id="feedback">

											<div class="input-group">
												<span class="input-group-addon"><i class="fa fa-home"
													aria-hidden="true"></i></span>
												<textarea required name="feedback" id="feedback"
													class="form-control" rows="4" cols="50"
													placeholder="Enter Feedback"></textarea>

											</div>

										</div> <br>
										<div class="form-group">
											<button class="button loginbtn" name="click" id="click"
												onclick="getBalance()">
												<span>Submit Feedback </span>
											</button>
										</div>
									</span> <br>
									<h4>
										<div class="form-group" id="balance"></div>
									</h4>
									<br>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3"></div>
	</div>

	</div>
	<br>
	<br>
	<%@include file="footer.jsp"%>
	<script src="js/map.js">
		
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjXJvTfiEhXy3lySeyc9F6XqQWeaAbjyE&callback=myMap"></script>
	<script type="text/javascript" src="assets/js/bootstrap.js"></script>