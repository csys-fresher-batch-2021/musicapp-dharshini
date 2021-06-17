<%@ page import="org.owasp.encoder.Encode"%>
<!DOCTYPE html>
<html lang="en">

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
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<div class="center">
			<%
			String errorMessage = request.getParameter("errormessage");
			if (errorMessage != null) {
				String encodedString = Encode.forHtml(errorMessage);
				out.println("<font color='red'>" + encodedString + "</font>");
			}
			%>
			<form method="POST" action="RegistrationServlet">
				<h1>Registration</h1>
				<br /> <label>First Name</label> <input type="text" name="fName"
					id="fName" placeholder="Enter Your First Name" required autofocus /><br>
				<br> <label>Last name</label> <input type="text" name="lName"
					id="lName" placeholder="Enter Your Last Name" required /><br>
				<br> <label>Email Id</label> <input type="email" name="email"
					id="email" placeholder="Enter Your Email Id" required /><br>
				<br> <label>Confirm Your Email Id</label> <input type="email"
					name="checkEmail" id="checkEmail"
					placeholder="Re-Enter Your Email Id" required /><br> <br>
				<label>Password</label> <input type="password" name="password"
					id="password" placeholder="Enter Your Last Name" required /><br>
				<br> <label>Gender:</label> <input type="radio" name="male"
					id="M" required>Male <input type="radio" name="male" id="F"
					required>Female <br> <br>
				<button class="btn btn-secondary" type="submit">Submit</button>
				<br /> <br /> <br> <br> Already Signed In? <a
					href="Login.jsp">Login</a>

			</form>
		</div>
	</main>
</body>

</html>