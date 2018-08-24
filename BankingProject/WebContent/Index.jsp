<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<div class="container">
		<h2>WELCOME</h2>
		<div class="row">
			<div class="col-md-6">
				<%@include file="Register.jsp"%>
			</div>
			<div class="col-md-6">
				<%@include file="Login.jsp"%>
			</div>
		</div>

	</div>
	<br>
	<br>
	<%@include file="footer.jsp"%>
	<script src="js/map.js">
		
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjXJvTfiEhXy3lySeyc9F6XqQWeaAbjyE&callback=myMap"></script>