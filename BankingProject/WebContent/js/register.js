var flag=false;

function checkDOB(){
	var date=document.getElementById("dob").value;
	var dateClass=document.querySelectorAll('#dateDiv');
	

	if(date=="")
	{
		flag=true;
		document.getElementById('required').innerHTML = '       Please select a valid Date';
		document.getElementById('required').style.display = "block";
		for (results of dateClass) {
			results.classList.add('has-error');
		}
		return false;
	}
	else{
		//Date exists
		var myDate = new Date(date);
		var today = new Date();
		if ( myDate > today ) { 

			flag=true;
			document.getElementById('required').innerHTML = 'You cannot enter a date in the future';
			document.getElementById('required').style.display = "block";
			for (results of dateClass) {
				results.classList.add('has-error');
			}
			return false;
		}
		else{
			var ageDifMs = Date.now() - myDate.getTime();
			var ageDate = new Date(ageDifMs); // miliseconds from epoch
			var age=Math.abs(ageDate.getUTCFullYear() - 1970);

			if(age<18)
			{
				flag=true;
				document.getElementById('required').innerHTML = 'Sorry, You should be over 18 years.';
				document.getElementById('required').style.display = "block";
				for (results of dateClass) {
					results.classList.add('has-error');
				}
				return false;
			}
			else{
				flag=false;
				document.getElementById('required').innerHTML = '';
				document.getElementById('required').style.display = "none";
				for (results of dateClass) {
					results.classList.remove('has-error');
				}
			}


		}
	}


}

function checkPasswords(){
	var password = document.getElementById("password").value;
	var confirm = document.getElementById("confirm").value;
	
	var passClasses = document.querySelectorAll('#passwordDiv');
	var confClasses = document.querySelectorAll('#confpasswordDiv');
	if(password.length<8)
	{
		flag=true;
		for (results of passClasses) {
			results.classList.add('has-error');
		}
		document.getElementById('required').innerHTML = 'Password should be minimum 8 characters';
		document.getElementById('required').style.display = "block";
		return;
	}
	/* else{
		for (results of passClasses) {
			  results.classList.remove('has-error');
		  }
		document.getElementById('required').innerHTML = '';
		document.getElementById('required').style.display = "none";
		return;
	} */

	if(confirm!=password){
		flag=true;
		document.getElementById('required').innerHTML = 'Password and confirm password do not match';
		document.getElementById('required').style.display = "block";
		for (results of confClasses) {
			results.classList.add('has-error');
		}
	}
	else
	{
		flag=false;
		document.getElementById('required').style.display = "none";
		for (result of passClasses) {
			result.classList.remove('has-error');
		}

		for (results of confClasses) {
			results.classList.remove('has-error');
		}
	}

}
function myFunction() {
	var username = document.getElementById("username").value;

	var classes = document.querySelectorAll('#usernameDiv');

	var name = $('#username').val();
	$.ajax({	
		type:'POST',
		data: {username: name},
		url:	'checkUsername',
		success: function(result){
			if(result=="error"){
				flag=true;
				document.getElementById('required').innerHTML = 'Username is already in use, try another';
				document.getElementById('required').style.display = "block";
				for (results of classes) {
					results.classList.add('has-error');
				}
			}
			else{
				flag=false;
				document.getElementById('required').innerHTML = 'This username is already taken';
				document.getElementById('required').style.display = "none";
				for (results of classes) {
					results.classList.remove('has-error');
				}
			}
		},
		error: function(data) {

		} 

	});

}
function showDiv() {
	document.getElementById('required').style.display = "none";
}

function submitForm()
{
	var genderClasses = document.querySelectorAll('#genderDiv');
	var classes = document.querySelectorAll('#branchDiv');
	var sel = document.getElementById("branch");
	var gender=document.getElementById("gender");
	var text= sel.options[sel.selectedIndex].value.trim();
	var genderVal=gender.options[gender.selectedIndex].value.trim();
	
	if(genderVal=="0")
	{
		flag=true;

		document.getElementById('required').innerHTML = 'Please select a gender';
		document.getElementById('required').style.display = "block";
		for (results of genderClasses) {
			results.classList.add('has-error');
		}
		return false;
	}
	else{

		flag=false;
		document.getElementById('required').innerHTML = '';
		document.getElementById('required').style.display = "none";
		for (results of genderClasses) {
			results.classList.remove('has-error');
		}
	}
	if(text=="0")
	{
		flag=true;

		document.getElementById('required').innerHTML = 'Please select a branch';
		document.getElementById('required').style.display = "block";
		for (results of classes) {
			results.classList.add('has-error');
		}
		return false;
	}
	else{

		flag=false;
		document.getElementById('required').innerHTML = '';
		document.getElementById('required').style.display = "none";
		for (results of classes) {
			results.classList.remove('has-error');
		}
	}

	if(flag)
	{

		return false;
	} 
	return true;
}