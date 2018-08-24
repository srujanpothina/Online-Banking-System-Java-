function checkOTP() {

	var otp = document.getElementById("otp").value;
	var otpHidden = document.getElementById("otpSession").value;

	if (otp == otpHidden) {
		document.getElementById('warning').innerHTML = '';
		document.getElementById('warning').style.display = "none";
		return true;
	} else {

		document.getElementById('warning').innerHTML = 'Otp entered is wrong';
		document.getElementById('warning').style.display = "block";
	}
	return false;

}
function checkEmail() {
	var flag = true;
	var email = document.getElementById("email").value;

	$
	.ajax({
		type : 'POST',
		data : {
			hidden : email
		},
		url : 'checkUsername',
		async : false,
		success : function(result) {
			if (result == "error") {
				flag = false;
				document.getElementById('warning').innerHTML = 'Email does not exist in our records';
				document.getElementById('warning').style.display = "block";

			} else {
				flag = true;
				document.getElementById('warning').innerHTML = '';
				document.getElementById('warning').style.display = "none";

			}
		},
		error : function(data) {

		}

	});
	return flag;

}

function myFunction() {
	var div = document.getElementById('warning');
	div.style.display = "none";
}

function validateForm() {

	var pass = document.getElementById("newPwd").value;
	var confPass = document.getElementById("confNewPwd").value;
	var div = document.getElementById('warning');
	if (pass.length < 8) {
		document.getElementById('warning').innerHTML = 'Password Length should be more than 8 characters';
		document.getElementById('warning').style.display = "block";
		return false;
	}
	if (pass != confPass) {

		document.getElementById('warning').innerHTML = 'Passwords do not match';
		document.getElementById('warning').style.display = "block";
		//div.style.display = "block";

		return false;
	} else {
		div.style.display = "none";

		var type = document.getElementsByName('type');
		var ischecked_method = false;
		for (var i = 0; i < type.length; i++) {
			if (type[i].checked) {
				ischecked_method = true;
				break;
			}
		}
		if (!ischecked_method) {
			document.getElementById('warning').innerHTML = 'Please select type of user';
			document.getElementById('warning').style.display = "block";
			return false;
		} else {
			document.getElementById('warning').innerHTML = '';
			document.getElementById('warning').style.display = "none";
		}
		return true;
	}
}

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