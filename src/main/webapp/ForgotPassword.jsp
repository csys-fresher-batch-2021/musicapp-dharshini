<%@ page import="org.owasp.encoder.Encode"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>MusicApp</title>
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
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

	<div class="center">
		<form method="POST" action="ForgotPasswordServlet">
			<h2 style="color: #1affa3">DJ Musicz</h2>
			<h3>Update Password</h3>
			<label>Enter Registered MailId</label> <input type="email"
				placeholder="Enter your registered emailid" name="emailid"
				id="emailid" required autofocus /><br> <br> <label>Enter
				New Password</label> <input type="password" placeholder="Enter New Password"
				name="password" id="password" required /> <br /> <br />
			<button class="btn btn-primary" type="submit">Update</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br /> <br />
			<a href="Login.jsp">Login</a>
			<%
			String infoMessage = (String) request.getParameter("infoMessage");
			String errorMessage = (String) request.getParameter("errorMessage");
			String errorMessage1 = (String) request.getParameter("errorMessage1");
			if (infoMessage != null) {
				String encodedInfoMessage = Encode.forHtml(infoMessage);
				out.println("<p>" + encodedInfoMessage + "</p>");
			%>
			
			<%
			} else if (errorMessage != null) {
			String encodedErrorMessage = Encode.forHtml(errorMessage);
			out.println("<f>" + encodedErrorMessage + "</f>");
			} else if (errorMessage1 != null) {
			String encodedErrorMessage1 = Encode.forHtml(errorMessage1);
			out.println("<f>" + encodedErrorMessage1 + "</f>");
			}
			%>
		</form>
	</div>
	</main>
</body>
</html>
