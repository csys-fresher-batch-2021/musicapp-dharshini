<%@ page import="org.owasp.encoder.Encode"%>
<%@page import="in.dharshini.model.User"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>MusicApp</title>
<style>
.center {
	text-align: center;
	padding: 70px 0;
}

.border1 {
	border: 10px solid black;
	display: inline-block;
	height: 250px;
	border-width: 2px;
	padding: 20px;
	border-radius: 8px;
	background-color: rgba(192, 192, 192, 0.3);
}

body {
	background-image: url("ImageUtilitiesServlet?imageName=Login-Image");
	background-repeat: no-repeat;
	background-size: 103% 130%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<div class="center">
			<form method="POST" action="LoginServlet">
				<h1 style="color: darkturquoise">DJ Musicz</h1>
				<h2 style="color: purple">Login</h2>
				<br />
				<div class="border1">
					<label style="color: mediumseagreen"><strong>Email
							Id</strong></label> <input type="email" placeholder="Enter Valid Emailid"
						name="emailid" id="emailid" required autofocus /><br> <br>
					<label style="color: mediumseagreen"><strong>Password</strong></label>
					<input type="password" placeholder="Enter your Password"
						name="password" id="password" required /> <br /> <br /> <a
						href="ForgotPassword.jsp"> <strong>Forgot Password?</strong></a><br />
					<br />
					<button class="btn btn-primary" type="submit">Submit</button>
					<button class="btn btn-danger" type="reset">Reset</button>
					<br />
					<%
					String message = request.getParameter("errormessage");
					if (message != null) {
						String encodedString = Encode.forHtml(message);

						out.println("<font color='red'>" + encodedString + "</font>");
					}
					%>
					<br> <br> <br> <label style="color: lime"><strong>New
							to DJMusicz?</strong></label> <a href="Registration.jsp"><strong>Create
							an Account</strong></a> <br> <a href="index.jsp"><strong>Logout</strong></a>
				</div>
			</form>
		</div>
	</main>
</body>
</html>