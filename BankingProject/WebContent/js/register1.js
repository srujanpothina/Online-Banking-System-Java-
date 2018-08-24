
function checkBalance(){
	var bal = Number(document.getElementById("balance").value);
	var dateClass=document.querySelectorAll('#balanceDiv');
	if(bal<=0){
		document.getElementById('required').innerHTML = '       Balance should be greater than 0';
		document.getElementById('required').style.display = "block";
		for (results of dateClass) {
			results.classList.add('has-error');
		}
		return false;
	}
	else{
		document.getElementById('required').innerHTML = '';
		document.getElementById('required').style.display = "none";
		for (results of dateClass) {
			results.classList.remove('has-error');
		}
		return true;
	}
}
/*function phone()
{
	alert("a");
	var phone = document.getElementById("phone");
	var dateClass=document.querySelectorAll('#phoneDiv');
	var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	if(phone.value.match(phoneno))
	{
		document.getElementById('required').innerHTML = '';
		document.getElementById('required').style.display = "none";
		for (results of dateClass) {
			results.classList.remove('has-error');
		}
		return true;
	}
	else
	{
		document.getElementById('required').innerHTML = '       Please enter a valid Phone Number';
		document.getElementById('required').style.display = "block";
		for (results of dateClass) {
			results.classList.add('has-error');
		}
		return false;
	}
}*/