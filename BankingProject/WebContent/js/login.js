function required(){
	var type = document.getElementsByName('type');
	var ischecked_method = false;
	for ( var i = 0; i < type.length; i++) {
	    if(type[i].checked) {
	        ischecked_method = true;
	        break;
	    }
	}
	if(!ischecked_method)   { //payment method button is not checked
	    alert("Please select type of user to login");
	return false;
	}
}