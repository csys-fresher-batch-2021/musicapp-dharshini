<%@ page import="org.owasp.encoder.Encode"%>
<%@page import="in.dharshini.model.User"%>

<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<title>MusicApp</title>
<style>
.center {
	text-align: center;
	padding: 70px 0;
}

f {
	color: red;
}
</style>
</head>
<body>

	<main>
		<div class="center">
			<form method="POST" action="AdminServlet">
			<h2 style="color:#1affa3">DJ Musicz</h2>
				<h3>Admin Login</h3>
				<br /> <label>Email Id</label> <input type="email"
					placeholder="Enter Valid Emailid" name="adminEmail" id="adminEmail"
					required autofocus /><br> <br> <label>Password</label> <input
					type="password" placeholder="Enter your Password" name="adminPass"
					id="adminPass" required /> <br /> <br />

				<button class="btn btn-primary" type="submit">Submit</button>
				<button class="btn btn-danger" type="reset">Reset</button>
				<br /> <br />

				<%
				String errorMessage = request.getParameter("errorMessage");
				if (errorMessage != null) {
					String encodedString = Encode.forHtml(errorMessage);

					out.println("<f>" + encodedString + "</f>");
				}
				%>
			</form>
		</div>
	</main>
</body>
</html>