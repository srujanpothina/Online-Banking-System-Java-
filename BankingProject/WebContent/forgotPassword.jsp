<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

<!-- Website CSS style -->
<link rel="stylesheet" type="text/css" href="CSS/form.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>
<body onload="myFunction()" data-spy="scroll" data-target=".navbar"
	data-offset="50">
	<br>
	<br>
	<br>
	<br>
	<c:if test="${not empty sessionScope.flag}">
		<c:remove var="flag" scope="session" />
		<c:if test="${not empty sessionScope.oneTime}">
			<c:remove var="oneTime" scope="session" />
		</c:if>
		<c:if test="${not empty sessionScope.pwd}">
			<c:remove var="pwd" scope="session" />
		</c:if>
		<c:if test="${not empty sessionScope.emailPwd}">
			<c:remove var="emailPwd" scope="session" />
		</c:if>
	</c:if>


	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="container">

					<div class="row main">
						<div class="col-md-6">
							<div class="panel-heading">
								<div class="panel-title text-center">
									<h1 class="title">Forgot Password</h1>
									<hr />
								</div>
							</div>
							<div id="warning"
								style="margin-left: 3cm; display: none; align: center; color: red; font-size: 14px;"></div>
							<br>
							<c:choose>

								<c:when
									test="${not empty sessionScope.oneTime && sessionScope.pwd == true}">
									<div class="main-login main-center">

										<form class="form-horizontal" method="post" action="email">

											<div class="form-group">


												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa fa-lock fa" aria-hidden="true"></i></span> <input
														type="password" class="form-control" name="newPwd"
														id="newPwd" placeholder="Enter New Password" required />
												</div>

											</div>
											<div class="form-group">


												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa fa-lock fa" aria-hidden="true"></i></span> <input
														type="password" class="form-control" name="confNewPwd"
														id="confNewPwd" placeholder="Confirm New Password"
														required />
												</div>

											</div>
											<div class="form-group">


												<div class="input-group">
													&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <input type="radio"
														name="type" id="type" value="user">
													User&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<input type="radio" id="type" name="type" value="admin">
													Admin
												</div>

											</div>

											<div class="form-group ">
												<button class="button loginbtn"
													onclick="return validateForm()">
													<span>Change Password </span>
												</button>
											</div>

										</form>

									</div>
								</c:when>
								<c:when
									test="${not empty sessionScope.emailPwd && not empty sessionScope.oneTime && empty sessionScope.pwd }">

									<div class="main-login main-center">

										<form class="form-horizontal" method="post" action="email">

											<div class="form-group">


												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa fa-lock fa" aria-hidden="true"></i></span> <input
														type="password" class="form-control" name="otp" id="otp"
														required placeholder="Enter OTP" />
												</div>

											</div>
											<input type="hidden" value="forgot" name="hidden"> <input
												type="hidden" value="${sessionScope.oneTime}"
												name="otpSession" id="otpSession">
											<div class="form-group ">
												<button class="button loginbtn" onclick="return checkOTP()">
													<span>Validate OTP </span>
												</button>
											</div>

										</form>

									</div>
								</c:when>
								<c:otherwise>
									<div class="main-login main-center">

										<form class="form-horizontal" method="post" action="email">

											<div class="form-group">


												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
														type="email" class="form-control" name="email" id="email"
														required placeholder="Enter Email Id" />
												</div>

											</div>

											<div class="form-group ">
												<button class="button loginbtn"
													onclick="return checkEmail()" />
												<span>Get OTP </span>
												</button>
											</div>

										</form>
									</div>
								</c:otherwise>
							</c:choose>




						</div>
					</div>
				</div>


				<script type="text/javascript" src="assets/js/bootstrap.js"></script>

			</div>
			<div class="col-md-3"></div>
		</div>

	</div>

	<br>
	<br>


	<br>
	<br>
	<%@include file="footer.jsp"%>
	<script src="js/forgotPassword.js">
		
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjXJvTfiEhXy3lySeyc9F6XqQWeaAbjyE&callback=myMap"></script>