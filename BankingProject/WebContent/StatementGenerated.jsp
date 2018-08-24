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
	<div id="printDiv"
		style="text-align: center; width: 100%; position: relative; top: 1.5cm;"
		class="container">
		<h2>Statement</h2>
		<hr>
		<div class="row">
			<div class="col-md-3">
				<b>Sender Acc No</b>
			</div>
			<div class="col-md-3">
				<b> Receiver Acc No</b>
			</div>
			<div class="col-md-3">
				<b> Amount </b>
			</div>

			<div class="col-md-3">
				<b> Date </b>
			</div>

		</div>
		<hr>

		<c:forEach items="${sessionScope.statementList}" var="i">
			<div class="row">
				<div class="col-md-3">
					<c:out value="${i.sender}" />
				</div>
				<div class="col-md-3">
					<c:out value="${i.receiver}" />
				</div>
				<div class="col-md-3">
					<c:out value="${i.amount}" />
				</div>
				<div class="col-md-3">
					<c:out value="${i.date}" />
				</div>
			</div>
			<hr>
		</c:forEach>

		<div class="main-center form-group">
			<button class="button loginbtn" name="click" id="click"
				onclick="print()">
				<span>Print </span>
			</button>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4" style="align: center"></div>
			<div class="col-md-4"></div>

		</div>
	</div>

	<br>
	<%-- <div class="container">
	<h2>WELCOME</h2>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="container">
				<c:set var="flag" value="fromLogin" scope="session" />
				<div class="row main">
					<div class="col-md-5">
						<div class="panel-heading">
							<div class="panel-title text-center">
								<h1 class="title">Account Statement</h1>
								<hr />
							</div>
						</div>
						<center>
							<div class="main-login" id="print">
								<br> <b> Sender &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Receiver
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Amount
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Date</b>

								<c:forEach items="${sessionScope.statementList}" var="i">
									<br>
									<c:out value="${i.sender}" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:out
										value="${i.receiver}" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:out value="${i.amount}" /> 
								&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${i.date}" />

								</c:forEach>

								<br>

								<div class="main-center form-group">
									<button class="button loginbtn" name="click" id="click"
										onclick="print()">
										<span>Print </span>
									</button>
								</div>

								<br> <br>
							</div>
						</center>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>

	</div>
 --%>
	<br>
	<br>
	<div style="position: fixed; bottom: 0; width: 100%;">
		<%@include file="footer.jsp"%>
	</div>
	<script src="js/map.js">
		
	</script>
	<script>
		function print() {
			var prtContent = document.getElementById("printDiv");
			var WinPrint = window
					.open('', '',
							'left=0,top=0,width=800,height=900,toolbar=0,scrollbars=0,status=0');
			WinPrint.document.write(prtContent.innerHTML);
			WinPrint.document.close();
			WinPrint.focus();
			WinPrint.print();
			WinPrint.close();
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjXJvTfiEhXy3lySeyc9F6XqQWeaAbjyE&callback=myMap"></script>
	<script type="text/javascript" src="assets/js/bootstrap.js"></script>