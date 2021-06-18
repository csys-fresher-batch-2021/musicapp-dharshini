
<!DOCTYPE html>
<html lang="en">

<head>
<title>MusicApp</title>
<style>
.center {
	text-align: center;
	padding: 70px 0;
}

p {
	color: green;
}

f {
	color: red;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<div class="center">
			<form method="POST" action="ForgotPasswordServlet">
				<h3>Update Password</h3>
				<label>Enter Registered MailId</label> <input type="email"
					placeholder="Enter your registered emailid" name="emailid"
					id="emailid" required autofocus /><br> <br> <label>Enter
					New Password</label> <input type="password"
					placeholder="Enter New Password" name="password" id="password"
					required /> <br /> <br />

				<button class="btn btn-primary" type="submit">Update</button>
				<button class="btn btn-danger" type="reset">Reset</button>
				<br /> <br />
				<%
				String infoMessage = (String) request.getParameter("infoMessage");
				String errorMessage = (String) request.getParameter("errorMessage");
				String errorMessage1 = (String) request.getParameter("errorMessage1");
				if (infoMessage != null) {
					out.println("<p>" + infoMessage + "</p>");
				%>
				Click Below To Login
				<br /> <a class="btn btn-secondary" href="Login.jsp">Login</a>
				<%
				} else if (errorMessage != null) {
				out.println("<f>" + errorMessage + "</f>");
				} else if (errorMessage1 != null) {
				out.println("<f>" + errorMessage1 + "</f>");
				}
				%>
			</form>
		</div>
	</main>
</body>
</html>
