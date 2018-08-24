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
	<c:set var="flag" value="fromLogin" scope="session" />
	<div class="row main">
		<div class="col-md-5">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Sign In</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<form class="form-horizontal" action="LoginServlet" method="post"
					onsubmit="return required()">

					<div class="form-group">


						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								name="usernameLogin" id="usernameLogin" required
								placeholder="Username" />
						</div>

					</div>


					<div class="form-group">


						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
								type="password" class="form-control" name="passwordLogin"
								required id="passwordLogin" placeholder="Password" />
						</div>

					</div>
					<div class="form-group">


						<div class="input-group">
							&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <input type="radio" name="type"
								value="user"> User&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="type" value="admin"> Admin
						</div>

					</div>


					<div class="form-group">
						<center>
							<a href="forgotPassword.jsp">Forgot Password?</a>
						</center>
					</div>

					<div class="form-group ">
						<button class="button loginbtn" name="loginSubmit"
							id="loginSubmit">
							<span>Login </span>
						</button>
					</div>

				</form>

			</div>
		</div>
	</div>
</div>

<script src="js/login.js">
	
</script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
