<html>
<head>
<title>MusicApp</title>
<style>
.center {
	text-align: center;
	padding: 70px 0;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="center">
			<form method="POST" onsubmit="first()">
				<h1>Login</h1>
				<label>Email Id</label> <input type="email"
					placeholder="Enter Valid Emailid" name="emailid" id="emailid"
					required autofocus /><br>
				<br> <label>Password</label> <input type="text"
					placeholder="Enter your Password" name="password" id="password"
					required /><br>
				<br>
				<button class="btn btn-primary" type="submit">Submit</button>
				<button class="btn btn-danger" type="reset">Reset</button>
				<br>
				<br>
				<br> New to DGMusicz? <a href="NewRegistration.html">Create
					an Account</a> <br>
				<br> <a href="index.jsp">Logout</a>
				<!-- Should go to frst display page, Create one-->
			</form>
		</div>
	</main>
</body>
</html>
