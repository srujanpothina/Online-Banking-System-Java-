
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

<!-- Website CSS style -->
<link rel="stylesheet" type="text/css" href="CSS/form.css">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<div class="container">
	<div class="row main">
		<div class="col-md-5">

			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Sign Up</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<form class="form-horizontal" action="LoginServlet" method="post"
					onsubmit="return submitForm()">

					<div class="form-group required" id="required"></div>
					<div class="form-group">


						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								name="name" id="name" placeholder="Enter your Name" />
						</div>

					</div>

					<div class="form-group">


						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
								type="email" class="form-control" name="email" id="email"
								required placeholder="Enter your Email" />
						</div>

					</div>

					<div class="form-group" id="usernameDiv">


						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-users fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								required onfocusout="myFunction()" name="username" id="username"
								placeholder="Enter your Username" />
						</div>

					</div>

					<div class="form-group" id="passwordDiv">


						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input required
								type="password" class="form-control" name="password"
								onfocusout="checkPasswords()" id="password"
								placeholder="Enter your Password" />
						</div>

					</div>

					<div class="form-group" id="confpasswordDiv">

						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input required
								onfocusout="checkPasswords()" type="password"
								class="form-control" name="confirm" id="confirm"
								placeholder="Confirm your Password" />
						</div>

					</div>

					<div class="form-group" id="phoneDiv">

						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-phone fa-lg" aria-hidden="true"></i></span> <input
								required onfocusout="phone()" type="text" class="form-control"
								name="phone" id="phone"
								placeholder="Enter Phone Number(XXXXXXXXXX)" />
						</div>

					</div>

					<div class="form-group" id="ssnDiv">

						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-address-card-o" aria-hidden="true"></i></span> <input
								required onfocusout="return checkSSN()" type="text"
								class="form-control" name="ssn" id="ssn"
								placeholder="Enter SSN (AAA-GG-SSSS)" />
						</div>

					</div>
					<div class="form-group" id="balanceDiv">

						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-money"
								aria-hidden="true"></i></span> <input required
								onfocusout="checkBalance()" type="number" class="form-control"
								name="balance" id="balance" placeholder="Enter Initial Balance" />
						</div>

					</div>


					<div class="form-group" id="branchDiv">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-bank"
								aria-hidden="true"></i></span> <select required id="branch"
								name="branch" class="form-control">

								<option class="form-control" value="0" selected="selected">Select
									Branch</option>
								<sql:setDataSource var="con" driver="com.mysql.jdbc.Driver"
									url="jdbc:mysql://localhost:3306/bank" user="root"
									password="root" />
								<sql:query var="result" sql="select * from branch"
									dataSource="${con}" />
								<c:forEach var="rows" items="${result.rows}">

									<option class="form-control" value="${rows.branchid}">${rows.branchlocation}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group" id="genderDiv">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-female lg"
								aria-hidden="true"></i></span> <select required id="gender"
								name="gender" class="form-control">
								<option class="form-control" value="0" selected="selected">Select
									Gender</option>
								<option class="form-control" value="male">Male</option>
								<option class="form-control" value="female">Female</option>
							</select>
						</div>
					</div>

					<div class="form-group" id="dateDiv">

						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-calendar"
								aria-hidden="true"></i></span> <input required onfocusout="checkDOB()"
								type="date" class="form-control" placeholder="Enter DOB"
								name="dob" id="dob" />
						</div>

					</div>
					<div class="form-group" id="address">

						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-home"
								aria-hidden="true"></i></span>
							<textarea required name="address" id="address"
								class="form-control" rows="4" cols="50"
								placeholder="Enter your Address"></textarea>

						</div>

					</div>
					<div class="form-group">
						<button class="button registerbtn" name="registerSubmit"
							id="registerSubmit" onclick="showDiv()">
							<span>Register </span>
						</button>
					</div>

				</form>

			</div>
		</div>
	</div>
</div>

<script src="js/register.js">
	
</script>
<script src="js/register1.js">
	
</script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
