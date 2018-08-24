<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<div>

		<img src="Images/wallpaper.jpg"
			style="opacity: 0.5; height: 15cm; width: 100%" />
	</div>
	<%@include file="footer.jsp"%>



	<script>
		function myMap() {
			var myCenter = new google.maps.LatLng(35.227085, -80.843124);
			var mapCanvas = document.getElementById("map");
			var mapOptions = {
				center : myCenter,
				zoom : 5
			};
			var map = new google.maps.Map(mapCanvas, mapOptions);
			var marker = new google.maps.Marker({
				position : myCenter
			});
			marker.setMap(map);
			google.maps.event.addListener(marker, 'click', function() {
				var infowindow = new google.maps.InfoWindow({
					content : "Hello World!"
				});
				infowindow.open(map, marker);
			});
		}
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjXJvTfiEhXy3lySeyc9F6XqQWeaAbjyE&callback=myMap"></script>