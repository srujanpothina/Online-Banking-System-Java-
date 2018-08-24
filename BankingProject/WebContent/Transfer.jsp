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
									<h1 class="title">Transfer Funds</h1>
									<hr />
								</div>
							</div>
							<div class="main-login main-center">
								<form action="transfer" onsubmit="return transfer()"
									method="get">
									<span class="form-horizontal"> <br>

										<div class="form-group">

											<input type="hidden" name="hidden" id="hidden"
												value="<c:out value="${sessionScope.username}" />">
											<div class="input-group">
												<span class="input-group-addon"><i
													class="fa fa-envelope" aria-hidden="true"></i></span> <input
													type="email" class="form-control" name="email" required
													id="email" placeholder="Please Enter Recievers Email Id" />
											</div>

										</div> <br>
										<div class="form-group">

											<div class="input-group">
												<span class="input-group-addon"><i
													class="fa fa-envelope" aria-hidden="true"></i></span> <input
													type="text" class="form-control" required id="emailSender"
													name="emailSender" placeholder="Please Enter your email Id" />
											</div>

										</div> <br>
										<div class="form-group">

											<div class="input-group">
												<span class="input-group-addon"><i
													class="fa fa-envelope" aria-hidden="true"></i></span> <input
													type="text" class="form-control" required id="amount"
													name="amount" placeholder="Please Enter Amount to send" />
											</div>

										</div> <br>
										<div class="form-group">
											<button class="button loginbtn" name="click" id="click">
												<span>Transfer </span>
											</button>
										</div>
									</span> <br>
									<h4>
										<div class="form-group" id="balance"></div>

									</h4>
								</form>
								<br>
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
	<script>
		function transfer() {
			var name = document.getElementById("hidden").value;

			var emailSender = document.getElementById("emailSender").value;
			var emailReciever = document.getElementById("email").value;
			var amount = document.getElementById("amount").value;
			if (isNaN(amount)) {
				alert("Please enter valid amount");
				return false;
			} else if (amount <= 0) {
				alert("Amount should be greater than 0");
				return false;

			}
			return true;

		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjXJvTfiEhXy3lySeyc9F6XqQWeaAbjyE&callback=myMap"></script>
	<script type="text/javascript" src="assets/js/bootstrap.js"></script>