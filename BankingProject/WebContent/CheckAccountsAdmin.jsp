<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div
		style="text-align: center; width: 100%; position: relative; top: 1.5cm;"
		class="container">
		<h2>Accounts with low Balances</h2>
		<hr>
		<br>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-3">
				<b> Customer Name</b>
			</div>
			<div class="col-md-3">
				<b> Balance</b>
			</div>
			<div class="col-md-2">
				<b> Check to Approve <input type="checkbox" value="check"
					id="check" onclick="checkall()" name="check"></b>
			</div>

			<div class="col-md-2"></div>

		</div>
		<hr>
		<form method="post" action="NotifyLowBalances">
			<c:forEach items="${sessionScope.lowBalanceList}" var="i">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-3">
						<c:out value="${i.fullname}" />
					</div>
					<div class="col-md-3">
						<c:out value="${i.balance}" />
					</div>
					<div class="col-md-2">
						<input type="checkbox" value="${i.emailid}" id="${i.emailid}"
							name="checked">
					</div>
					<div class="col-md-2"></div>
				</div>
				<hr>
			</c:forEach>

			<div class="form-group">
				<button class="button registerbtn" name="registerSubmit"
					id="registerSubmit">
					<span>Notify Users </span>
				</button>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4" style="align: center"></div>
				<div class="col-md-4"></div>

			</div>
	</div>
	<br>
	<br>
	<div style="position: relative; bottom: 0; width: 100%;">
		<%@include file="footer.jsp"%>
	</div>
	<script src="js/map.js">
		
	</script>
	<script>
		function checkall() {
			var checkbox = document.getElementById('check');
			var allRows = document.getElementsByTagName("input");

			if (checkbox.checked) {
				//alert("checked");
				for (var i = 0; i < allRows.length; i++) {
					console.log(allRows[i])
					if (allRows[i].type == 'checkbox') {
						console.log(allRows[i])
						allRows[i].checked = true;
					}
				}
			} else {
				//alert("not checked");
				for (var i = 0; i < allRows.length; i++) {
					if (allRows[i].type == 'checkbox') {
						console.log(allRows[i])
						allRows[i].checked = false;
					}
				}
			}

		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjXJvTfiEhXy3lySeyc9F6XqQWeaAbjyE&callback=myMap"></script>
	<script type="text/javascript" src="assets/js/bootstrap.js"></script>