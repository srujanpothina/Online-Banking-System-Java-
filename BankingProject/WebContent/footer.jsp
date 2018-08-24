<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>

<link type="text/css" rel="stylesheet" href="CSS/footer.css" />

<script src="js/map.js">
	
</script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjXJvTfiEhXy3lySeyc9F6XqQWeaAbjyE&callback=myMap"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%
	pageContext.setAttribute("currentYear", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR));
%>
<div id="footer">
	<div style="height: 100px" id="map"></div>
	<div class="row"
		style="bottom: 0; height: 100px; background-color: black; color: white; font-faily: arial;">
		<div class="col-md-2">
			<table>
				<tr>
					<td style="padding: 25px;"><a href="http://www.fb.com"><i
							class="fa fa-facebook-f icon"
							style="font-size: 25px; color: white"></i></a>
					<td>
					<td>&nbsp;</td>
					<td></td>

					<td style="padding: 15px;"><a href="http://www.twitter.com"><i
							class="fa fa-twitter" style="font-size: 25px; color: white"></i></a>
					<td>
				</tr>
			</table>
		</div>
		<div class="col-md-8 verticalLine">
			<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Online Bank is a very secure
			place to perform hassle free transactions and store your savings. We
			secure your money in the best place.
			<center>
				@
				<c:out value="${currentYear}" />
			</center>


		</div>
		<!-- <div class="col-md-2"></div> -->
	</div>
</div>
