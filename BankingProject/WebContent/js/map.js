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
					content : "Charlotte!"
				});
				infowindow.open(map, marker);
			});
		}