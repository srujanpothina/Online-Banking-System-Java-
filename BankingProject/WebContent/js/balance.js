function getBalance() {

	var name = document.getElementById("hidden").value;
	var email = document.getElementById("email").value;
	//alert(email);
	$
	.ajax({
		type : 'GET',
		data : {
			fullname : name,
			email : email
		},
		url : 'getBalance',
		success : function(result) {
			if (result == "error") {
				document.getElementById('balance').innerHTML = "<center><i>Please enter your Email</o></center>";
				document.getElementById('balance').style.display = "block";
			} else {
				document.getElementById('balance').innerHTML = "<center><b>$ "
					+ result+"</b></center>";
				document.getElementById('balance').style.display = "block";
			}
		},
		error : function(data) {

		}

	});

}